package example.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {


    private static final double DEPOSIT_AMOUNT =  100;
    private static final double WITHDRAW_AMOUNT_RIGHT = 70;
    private static final double WITHDRAW_AMOUNT_WRONG = 200;
    private static final int ID_WRONG = 2;
    private static final int ID_RIGHT = 1;
    private static final String ACCOUNT_HOLDER_NAME = "Mario";
    private static final String ACCOUNT_HOLDER_SURNAME = "Rossi";
    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder(
            ACCOUNT_HOLDER_NAME,
            ACCOUNT_HOLDER_SURNAME,
            ID_RIGHT
        );
        bankAccount = new SimpleBankAccount(accountHolder, BankAccountTest.BALANCE_EMPTY);
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
    void testWithdrawRight() {
        BankAccountTest.testWithdraw(
            bankAccount,
            accountHolder.id(),
            BankAccountTest.BALANCE_EMPTY + DEPOSIT_AMOUNT - WITHDRAW_AMOUNT_RIGHT,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_RIGHT
        );
    }

    @Test
    void testWithdrawAmountTooHigh() {
        BankAccountTest.testWithdraw(
            bankAccount,
            accountHolder.id(),
            BankAccountTest.BALANCE_EMPTY + DEPOSIT_AMOUNT,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_WRONG
        );
    }

    @Test
    void testWithdrawWrongId() {
        BankAccountTest.testWithdraw(
            bankAccount,
            ID_WRONG,
            BankAccountTest.BALANCE_EMPTY,
            DEPOSIT_AMOUNT,
            WITHDRAW_AMOUNT_RIGHT
        );
    }
}
