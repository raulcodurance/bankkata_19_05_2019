import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private Timer timer;
    private List<Transaction> transactions;

    public TransactionRepository(Timer timer) {

        this.transactions = new ArrayList<>();
        this.timer = timer;
    }

    public void addDeposit(int amount) {


        transactions.add(new Transaction(amount, timer.todayAsString()));
    }

    public void addWithdrawal(int amount) {
        throw new UnsupportedOperationException();
    }

    public List<Transaction> allTransactions() {

        return Collections.unmodifiableList(transactions);

    }
}
