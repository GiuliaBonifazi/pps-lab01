package example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WithdrawFeeBankAccountTest {

    private static final int ID_RIGHT = 0;
    private static final int ID_WRONG = 1;
    private static final double DEPOSIT_AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT_RIGHT = 70;
    private static final double WITHDRAW_AMOUNT_WRONG = 100;
    private static final String ACCOUNT_HOLDER_NAME = "Mario";
    private static final String ACCOUNT_HOLDER_SURNAME = "Rossi";
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder(
            ACCOUNT_HOLDER_NAME,
            ACCOUNT_HOLDER_SURNAME,
            ID_RIGHT
        );
        bankAccount = new WithdrawFeeBankAccount(accountHolder, BankAccountTest.BALANCE_EMPTY);
    }

    @Test
    void testInitialBalance() {
        BankAccountTest.testInitialBalance(bankAccount);
    }

    @Test
    void testDepositRight() {
        BankAccountTest.testDeposit(
            bankAccount,
            accountHolder.id(),
            BankAccountTest.BALANCE_EMPTY + DEPOSIT_AMOUNT,
            DEPOSIT_AMOUNT
        );
    }

    @Test
    void testDepositWrongId() {
        BankAccountTest.testDeposit(
            bankAccount,
            ID_WRONG,
            BankAccountTest.BALANCE_EMPTY,
            DEPOSIT_AMOUNT
        );
    }

    @Test
    public void testWithdrawRight() {
        final double withdrawPlusFee = WITHDRAW_AMOUNT_RIGHT + WithdrawFeeBankAccount.WITHDRAW_FEE;
        BankAccountTest.testWithdraw(
            bankAccount,
            accountHolder.id(),
            BankAccountTest.BALANCE_EMPTY + DEPOSIT_AMOUNT - withdrawPlusFee,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_RIGHT
        );
    }

    @Test
    public void testWithdrawWrongId() {
        BankAccountTest.testWithdraw(
            bankAccount,
            ID_WRONG,
            BankAccountTest.BALANCE_EMPTY,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_RIGHT
        );
    }

    @Test
    public void testWithdrawAmountTooHigh() {
        BankAccountTest.testWithdraw(
            bankAccount,
            accountHolder.id(),
            BankAccountTest.BALANCE_EMPTY + DEPOSIT_AMOUNT,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_WRONG
        );
    }
}
