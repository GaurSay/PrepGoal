package LowLevelDesign.Splitwise.Services;

import LowLevelDesign.Splitwise.Models.Transaction;

import java.math.BigDecimal;
import java.util.*;

public class SettlementService {

    static class Node {

        String userId;
        BigDecimal amount;

        Node(String userId, BigDecimal amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    public List<Transaction> settle(Map<String, Map<String, BigDecimal>> balances) {

        Map<String, BigDecimal> netBalance = new HashMap<>();

        for (String u : balances.keySet()) {

            for (Map.Entry<String, BigDecimal> entry : balances.get(u).entrySet()) {

                String v = entry.getKey();
                BigDecimal amt = entry.getValue();

                netBalance.put(u, netBalance.getOrDefault(u, BigDecimal.ZERO).subtract(amt));

                netBalance.put(v, netBalance.getOrDefault(v, BigDecimal.ZERO).add(amt));
            }
        }

        List<Transaction> transactions = new ArrayList<>();

        PriorityQueue<Node> creditors = new PriorityQueue<>((a, b) -> b.amount.compareTo(a.amount));

        PriorityQueue<Node> debtors = new PriorityQueue<>((a, b) -> b.amount.compareTo(a.amount));

        for (Map.Entry<String, BigDecimal> entry : netBalance.entrySet()) {

            if (entry.getValue().compareTo(BigDecimal.ZERO) > 0)
                creditors.add(new Node(entry.getKey(), entry.getValue()));

            else if (entry.getValue().compareTo(BigDecimal.ZERO) < 0)
                debtors.add(new Node(entry.getKey(), entry.getValue().negate()));
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {

            Node creditor = creditors.poll();
            Node debtor = debtors.poll();

            assert debtor != null;
            BigDecimal settle = creditor.amount.min(debtor.amount);

            System.out.println(debtor.userId + " pays " + creditor.userId + " : " + settle);

            transactions.add(new Transaction(debtor.userId, creditor.userId, settle));

            creditor.amount = creditor.amount.subtract(settle);

            debtor.amount = debtor.amount.subtract(settle);

            if (creditor.amount.compareTo(BigDecimal.ZERO) > 0) creditors.add(creditor);

            if (debtor.amount.compareTo(BigDecimal.ZERO) > 0) debtors.add(debtor);
        }

        return transactions;
    }


    public void applySettlement(
            Map<String, Map<String, BigDecimal>> balances,
            List<Transaction> transactions
    ) {

        for (Transaction t : transactions) {

            String from = t.from;
            String to = t.to;
            BigDecimal amount = t.amount;

            Map<String, BigDecimal> inner = balances.get(from);

            if (inner == null) continue;

            BigDecimal existing = inner.get(to);

            if (existing == null) continue;

            if (existing.compareTo(amount) > 0) {

                inner.put(to, existing.subtract(amount));

            } else {

                inner.remove(to);

                if (inner.isEmpty()) {
                    balances.remove(from);
                }
            }
        }
    }
}