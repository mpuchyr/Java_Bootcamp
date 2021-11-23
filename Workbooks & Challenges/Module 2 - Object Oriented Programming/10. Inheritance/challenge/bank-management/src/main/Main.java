package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.main.model.account.Chequing;
import src.main.model.Bank;
import src.main.model.Transaction;
import src.main.model.account.*;

public class Main {

   // Mac users:
    static String ACCOUNTS_FILE = "bank-management/src/main/data/accounts.txt";            
    static String TRANSACTIONS_FILE = "bank-management/src/main/data/transactions.txt";

    // Windows users:
    //  static String ACCOUNTS_FILE = "src\\main\\data\\accounts.txt";            
    //  static String TRANSACTIONS_FILE = "src\main\data\transactions.txt";

    static Bank bank = new Bank();

    public static void main(String[] args) {


        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");
                transactionHistory(account.getId());
            }
            
         } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    /**
     * Function name: wait
     * @param milliseconds
     * 
     * Inside the function:
     *  1. Makes the code sleep for X milliseconds.
     */

     public static void wait(int milliseconds) {
         try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
     }

    public static Account createObject(String[] values) throws Exception { 
        return (Account)Class.forName("src.main.model.account." + values[0])
            .getConstructor(String.class, String.class, double.class)
            .newInstance(values[1], values[2], Double.parseDouble(values[3]));
    }

    public static ArrayList<Account> returnAccounts() throws Exception {
        ArrayList<Account> accounts = new ArrayList<Account>();
        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            String[] accountInfo = scan.nextLine().split(",");
            accounts.add(createObject(accountInfo));
        }

        scan.close();
        return accounts;

    }

    public static void loadAccounts(ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            bank.addAccount(accounts.get(i));
        }
    }

    public static ArrayList<Transaction> returnTransactions() throws Exception {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            String[] info = scan.nextLine().split(",");
            Transaction transaction = new Transaction(Transaction.TransactionType.valueOf(info[1]), Long.parseLong(info[0]), info[2], Double.parseDouble(info[3]));
            transactions.add(transaction);
        }
        scan.close();
        Collections.sort(transactions);
        return transactions;
    }

    public static void runTransactions(ArrayList<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            bank.executeTransaction(transactions.get(i));
        }
    }

    public static void transactionHistory(String id) {
        Transaction[] transactions = bank.getTransactions(id);
        System.out.println("t\t\t\t   TRANSACTION HISTORY\n\t");
        for (int i = 0; i < transactions.length; i++) {
            System.out.println("\t" + transactions[i] + "\n");
        }
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) + "\n\n\n\n");
    }

}
