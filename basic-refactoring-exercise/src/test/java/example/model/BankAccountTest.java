package example.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    public static final double BALANCE_EMPTY = 0;

    public static void testInitialBalance(BankAccount bankAccount) {
        assertEquals(BALANCE_EMPTY, bankAccount.getBalance());
    }

    public static void testDeposit(
        BankAccount bankAccount,
        int accountHolderId,
        double expectedBalance,
        double depositAmount
    ) {
        bankAccount.deposit(accountHolderId, depositAmount);
        assertEquals(
            expectedBalance,
            bankAccount.getBalance()
        );
    }

    public static void testWithdraw(
        BankAccount bankAccount,
        int accountHolderId,
        double expectedBalance,
        double depositAmount,
        double withdrawAmount
    ) {
        bankAccount.deposit(accountHolderId, depositAmount);
        bankAccount.withdraw(accountHolderId, withdrawAmount);
        assertEquals(
            expectedBalance,
            bankAccount.getBalance()
        );
    }
}
