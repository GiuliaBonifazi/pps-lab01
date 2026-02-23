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
    private static final double BALANCE_EMPTY = 0;
    private static final int ID_WRONG = 2;
    private static final int ID_RIGHT = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID_RIGHT);
        bankAccount = new SimpleBankAccount(accountHolder, BALANCE_EMPTY);
    }

    @Test
    void testInitialBalance() {
        assertEquals(BALANCE_EMPTY, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        assertEquals(
            BALANCE_EMPTY + DEPOSIT_AMOUNT,
            bankAccount.getBalance()
        );
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.deposit(ID_WRONG, DEPOSIT_AMOUNT);
        assertEquals(
            BALANCE_EMPTY + DEPOSIT_AMOUNT,
            bankAccount.getBalance()
        );
    }

    @Test
    void testWithdrawWrongId() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT_RIGHT);
        assertEquals(
            BALANCE_EMPTY + DEPOSIT_AMOUNT - WITHDRAW_AMOUNT_RIGHT,
            bankAccount.getBalance()
        );
    }

    @Test
    void testWithdrawAmountTooHigh() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT_WRONG);
        assertEquals(
            BALANCE_EMPTY + DEPOSIT_AMOUNT,
            bankAccount.getBalance()
        );
    }

    @Test
    void testWrongAccountHolderIdWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(ID_WRONG, WITHDRAW_AMOUNT_RIGHT);
        assertEquals(
            BALANCE_EMPTY +  DEPOSIT_AMOUNT,
            bankAccount.getBalance()
        );
    }
}
