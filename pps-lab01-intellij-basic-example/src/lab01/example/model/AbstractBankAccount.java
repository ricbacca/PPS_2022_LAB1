package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public abstract class AbstractBankAccount implements BankAccount {

    private double balance = 0;
    protected final AccountHolder holder;

    public AbstractBankAccount(final AccountHolder holder) {
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && checkPositiveAmount(amount)) {
            this.balance += (amount - getFee());
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount) && checkPositiveAmount(amount)) {
            this.balance -= (amount + getFee());
        }
    }

    protected abstract int getFee();

    protected boolean isWithdrawAllowed(final double amount){
        if(this.balance >= (amount + getFee()))
            return true;
        else throw new IllegalArgumentException("Amount must be less than balance !");
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected boolean checkPositiveAmount(final double amount){
        if(amount > 0)
            return true;
        else
            throw new IllegalArgumentException("Values should be positive !");
    }
}
