import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractBankAccountTest {
    protected BankAccount bankAccount;
    protected AccountHolder accountHolder;

    @BeforeEach
    public abstract void beforeEach();

    @Test
    public void testInitiallyEmpty(){
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    public abstract void testDeposit();

    @Test
    public abstract void testWithdraw();

    @Test
    public void testNegativeDeposit(){
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.deposit(this.accountHolder.getId(), -100));
    }

    @Test
    public void testNegativeWithdraw(){
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.withdraw(this.accountHolder.getId(), -100));
    }

    @Test
    public void testTooMuchWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.withdraw(this.accountHolder.getId(), 120));
    }
}
