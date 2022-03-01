package lab01.example.model;

public class SimpleBankAccount extends AbstractBankAccount {

    public SimpleBankAccount(AccountHolder holder) {
        super(holder);
    }

    @Override
    protected int getFee() {
        return 0;
    }
}
