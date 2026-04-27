package LowLevelDesign.Splitwise.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final String transactionId;
    public final String from;   // debtor
    public final String to;     // creditor
    public final BigDecimal amount;
    private final LocalDateTime timestamp;

    public Transaction(String from, String to, BigDecimal amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getfrom() {
        return from;
    }

    public String getto() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
