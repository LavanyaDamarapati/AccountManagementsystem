package com.ams.accountmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.ams.accountmanagementsystem.model.Transaction;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TransactionService {

    private static final Logger logger = Logger.getLogger(TransactionService.class.getName());

    private final Map<String, Transaction> transactions;

    public TransactionService(Map<String, Transaction> transactions) {
        this.transactions = transactions;
    }
    
// This method is used to get the values of the transaction based on the AccountId
    public Transaction getTransactionByAccountId(String accountId) {
        for (Transaction transaction : transactions.values()) {
            if (transaction.getAccountId().equals(accountId)) {
                return transaction;
            }
        }
        logger.log(Level.SEVERE, "Transaction not found for the accountID " + accountId);
        throw new IllegalArgumentException("Transaction not found for accountID " + accountId);
    }
    
// This method is used to create transaction
    public void createTransaction(String accountId, double amount) {
    	String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, accountId, amount);

        transactions.put(transaction.getTransactionId(), transaction);
    }
    
 // This method is used to generate transactionID    
      private String generateTransactionId() {
    	int transactionCounter = 0;
        transactionCounter++;
        return String.valueOf(transactionCounter);

}
}