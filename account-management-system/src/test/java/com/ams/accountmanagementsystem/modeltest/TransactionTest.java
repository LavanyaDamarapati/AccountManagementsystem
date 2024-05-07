package com.ams.accountmanagementsystem.modeltest;

import com.ams.accountmanagementsystem.model.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    void testTransactionConstructorAndGetters() {
        String transactionId = "1";
        String accountId = "123";
        double amount = 100.0;
        Transaction transaction = new Transaction(transactionId, accountId, amount);
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(accountId, transaction.getAccountId());
        assertEquals(amount, transaction.getAmount());
    }

    @Test
    void testTransactionSetters() {
        Transaction transaction = new Transaction("1", "123", 100.0);
        String newTransactionId = "1";
        String newAccountId = "123";
        double newAmount = 100.0;
        transaction.setTransactionId(newTransactionId);
        transaction.setAccountId(newAccountId);
        transaction.setAmount(newAmount);
        assertEquals(newTransactionId, transaction.getTransactionId());
        assertEquals(newAccountId, transaction.getAccountId());
        assertEquals(newAmount, transaction.getAmount());
    }
}
