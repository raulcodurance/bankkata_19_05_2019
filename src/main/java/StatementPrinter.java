import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.toList;

public class StatementPrinter {
    private Console console;

    public StatementPrinter(Console console) {

        this.console = console;
    }

    public void print(List<Transaction> transactions) {

        console.print("date || amount || balance");
        int balance = 0;

        List<Transaction> orderedTransactions = transactions.stream().sorted(Comparator.comparing(Transaction::date)).collect(toList());
        for(Transaction transaction : orderedTransactions){

            balance += transaction.amount();

            // 14/01/2012 || || 500.00 || 2500.00
            console.print(transaction.date() + " || " + abs(transaction.amount()) + " || " + balance );
        }

    }

}
