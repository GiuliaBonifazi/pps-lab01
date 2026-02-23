package example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WithdrawFeeBankAccountTest {

    private static final int ID_RIGHT = 0;
    private static final double EMPTY_BALANCE = 0;
    private static final double DEPOSIT_AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", ID_RIGHT);
        bankAccount = new WithdrawFeeBankAccount(accountHolder, EMPTY_BALANCE);
    }

    @Test
    public void testWithdraw(){
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT);
        assertEquals(
          EMPTY_BALANCE + DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - WithdrawFeeBankAccount.WITHDRAW_FEE,
          bankAccount.getBalance()
        );
    }
}
