import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
        AtomicInteger balance = new AtomicInteger(0);

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::date))
                .map(transaction -> transaction.date() + " || " + abs(transaction.amount()) + ".00 || " + balance.addAndGet(transaction.amount()) + ".00")
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(line -> console.print(line));
        }



}
