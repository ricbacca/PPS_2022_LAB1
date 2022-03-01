import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    public void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder);
    }

    @Override
    @Test
    public void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Override
    @Test
    public void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }
}
