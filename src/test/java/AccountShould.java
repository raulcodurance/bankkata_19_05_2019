import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class AccountShould {


    @Mock
    TransactionRepository transactionRepository;

    private Account account;

    @Before
    public void setUp() throws Exception {
        this.account = new Account();
    }

    @Test
    public void deposit_an_amount() {

        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }
}
