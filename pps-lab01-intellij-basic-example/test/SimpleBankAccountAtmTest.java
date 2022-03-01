import lab01.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleBankAccountAtmTest extends AbstractBankAccountTest {
    @Override
    @BeforeEach
    public void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountAtm(accountHolder);
    }

    @Override
    @Test
    public void testDeposit(){
        final double amount = 100;
        final int fee = 1;
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(amount-fee, bankAccount.getBalance());
    }

    /**
     * Test Withdraw with Fee
     * Standard Fee = 1
     * We make two different operations from an ATN: deposit + withdraw
     * So total Fee = 2
     */
    @Override
    @Test
    public void testWithdraw() {
        final double amount = 100;
        final double withdraw = 30;
        final int fee = 1;
        bankAccount.deposit(accountHolder.getId(), amount);
        bankAccount.withdraw(accountHolder.getId(), withdraw);
        assertEquals(amount-withdraw-fee-fee, bankAccount.getBalance());
    }
}
