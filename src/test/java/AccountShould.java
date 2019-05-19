import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {


    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void setUp() throws Exception {
        this.account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void deposit_an_amount() {

        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void withdrawal_an_amount() {

        account.withdrawal(100);

        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_statement() {

        List<Transaction> transactions = new ArrayList<>();

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
