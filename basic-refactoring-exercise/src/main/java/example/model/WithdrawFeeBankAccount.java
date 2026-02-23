package example.model;

public class WithdrawFeeBankAccount implements BankAccount {
    public static final double WITHDRAW_FEE = 1;
    private final SimpleBankAccount bankAccount;

    public WithdrawFeeBankAccount(AccountHolder accountHolder, double balance) {
        bankAccount = new SimpleBankAccount(accountHolder, balance);
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        bankAccount.deposit(userID, amount);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        bankAccount.withdraw(userID, amount + WITHDRAW_FEE);
    }
}
