package src.main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {

    public enum TransactionType {
        DEPOSIT, WITHDRAW
    }

    private TransactionType type;
    private long timestamp;
    private String id;
    private double amount;

    public Transaction (TransactionType type, long timestamp, String id, double amount) {
        if (id == null || id.isBlank() || amount < 0) {
            throw new IllegalArgumentException("INVALID PARAMS");
        }
        
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction (Transaction source) {
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }


    // Getters

    public TransactionType getType() {
        return this.type;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getId() {
        return this.id;
    }

    public double getAmount() {
        return this.amount;
    }

    // Setters

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID ID");
        }
        this.id = id;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("INVALID AMOUNT");
        }
        this.amount = amount;
    }

    public String returnDate(long timestamp) {
        Date date = new Date(this.timestamp * 1000);
        String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return formattedDate;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction)o;
        return this.type.equals(transaction.getType())
            && this.timestamp == transaction.getTimestamp()
            && this.id.equals(transaction.getId())
            && this.amount == transaction.getAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.timestamp, this.id, this.amount);
    }

    @Override
    public int compareTo(Transaction o) {
        return Long.compare(this.timestamp, o.timestamp);
    }
    


    @Override
    public String toString() {
        return this.type.toString() + "    " +
            "\t" + this.returnDate(this.timestamp) + "" +
            "\t" + this.id + "" +
            "\t$" + this.amount + ""; 
    }



}
