import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BankStatementFeature {


    @Mock Console console;
    private Account account;

    @Before
    public void setUp() throws Exception {

        this.account = new Account();
    }

    @Test
    public void print_statements() {

        account.deposit(1000);
        account.deposit(2000);
        account.withdrawal(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).print("date || amount || balance");
        inOrder.verify(console).print("14/01/2012 || || 500.00 || 2500.00");
        inOrder.verify(console).print("13/01/2012 || 2000.00 || || 3000.00");
        inOrder.verify(console).print("10/01/2012 || 1000.00 || || 1000.00");
    }
}
