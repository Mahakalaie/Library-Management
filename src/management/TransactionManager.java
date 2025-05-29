package management;

import datastructures.lists.CustomArrayList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    // TODO: Define a data structure that stores transactions
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        // TODO: Initialize your data structure here
        transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        // TODO: Add the transaction to your data structure
        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        // TODO:
        return transactions.get(index);
    }
}
