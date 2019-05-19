import java.util.Objects;

import static java.lang.Math.abs;

public class Transaction {
    private final int amount;
    private final String date;

    public Transaction(int amount, String date) {

        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }

    public String date() {
       return this.date;
    }

    public int amount() {
        return this.amount;
    }
}
