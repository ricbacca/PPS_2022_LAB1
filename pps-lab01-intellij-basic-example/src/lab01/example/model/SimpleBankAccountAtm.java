package lab01.example.model;

public class SimpleBankAccountAtm extends AbstractBankAccount {
    private final static int FEE = 1;

    public SimpleBankAccountAtm(AccountHolder holder) {
        super(holder);
    }

    @Override
    protected int getFee() {
        return FEE;
    }
}
