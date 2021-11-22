package src.main.model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

import src.main.model.account.Account;

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

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction[] getTransactions(String accountId) {
        List<Transaction> list = this.transactions.stream()
            .filter((transaction) -> transaction.getId().equals(accountId))
            .collect(Collectors.toList());

        return list.toArray(new Transaction[list.size()]);
    }

  
}
