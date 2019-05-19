import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    private StatementPrinter statementPrinter;

    @Mock Console console;

    @Before
    public void setUp() throws Exception {

        this.statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void print_statement_headers() {


        List<Transaction> transactions = new ArrayList<>();
        statementPrinter.print(transactions);

        verify(console).print("date || amount || balance");
    }

    @Test
    public void print_statement_transaction() {

        List<Transaction> transactions = Collections.singletonList(new Transaction(100, "16/05/2019"));

        statementPrinter.print(transactions);

        verify(console).print("date || amount || balance");
        verify(console).print("16/05/2019 || 100 || 100");



    }
}