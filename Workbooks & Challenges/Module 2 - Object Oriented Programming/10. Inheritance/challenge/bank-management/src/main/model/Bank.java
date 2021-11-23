package src.main.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

import src.main.model.account.Account;
import src.main.model.account.Chequing;
import src.main.model.account.impl.Taxable;

public class Bank {

    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();
    }

    public void addAccount(Account account) {
        accounts.add(account.clone());
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    private void withdrawTransaction(Transaction transaction) {
        if (getAccount(transaction.getId()).withdrawal(transaction.getAmount())) {
            addTransaction(transaction);
        }
    }

    private void depositTransaction(Transaction transaction) {
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction.getType().equals(Transaction.TransactionType.WITHDRAW)) {
            withdrawTransaction(transaction);
        } else {
            depositTransaction(transaction);
        }
    }

    private double getIncome(Taxable account) {
        Transaction[] transactions = getTransactions(((Chequing)account).getId());
        return Arrays.stream(transactions)
            .mapToDouble((transaction) -> {
                if (transaction.getType().equals(Transaction.TransactionType.WITHDRAW)) {
                    return transaction.getAmount() * -1;
                } else {
                    return transaction.getAmount();
                }
            })
            .sum();      
    }

    public void deductTaxes() {
        for (Account account: accounts) {
            if (Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }
    }

    public Transaction[] getTransactions(String accountId) {
        List<Transaction> list = this.transactions.stream()
            .filter((transaction) -> transaction.getId().equals(accountId))
            .collect(Collectors.toList());

        return list.toArray(new Transaction[list.size()]);
    }

    public Account getAccount(String transactionId) {
        return accounts.stream()
            .filter((account) -> account.getId().equals(transactionId))
            .findFirst()
            .orElse(null);
    }

  
}
