import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Hashtable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {


    private TransactionRepository transactionRepository;
    @Mock Timer timer;


    @Before
    public void setUp() throws Exception {

        this.transactionRepository = new TransactionRepository(timer);
    }

    @Test
    public void store_a_deposit_transaction() {

        given(timer.todayAsString()).willReturn("19/05/2019");
        transactionRepository.addDeposit(100);

        assertThat(transactionRepository.allTransactions().size(), is(1));
        assertThat(transactionRepository.allTransactions().get(0), is(new Transaction(100, "19/05/2019")));

    }
}