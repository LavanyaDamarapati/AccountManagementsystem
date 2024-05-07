package com.ams.accountmanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ams.accountmanagementsystem.model.Transaction;
import com.ams.accountmanagementsystem.service.TransactionService;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private Map<String, Transaction> transactions;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
    	transactionService = new TransactionService(transactions);
    }

    @Test
    void testGetTransactionByAccountId_TransactionExists() {
        String accountId = "123";
        Transaction actualTransaction = null;
        actualTransaction = transactionService.getTransactionByAccountId(accountId);
        assertNotNull(actualTransaction);
    }

    @Test
    void testGetTransactionByAccountId_TransactionDoesNotExist() {
        String accountId = "123";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> transactionService.getTransactionByAccountId(accountId));

        assertEquals("Transaction not found for accountID " + accountId, exception.getMessage());
    }

    @Test
    void testCreateTransaction() {
        String accountId = "123";
        double amount = 100.0;
        transactionService.createTransaction(accountId, amount);
        assertTrue(transactions.containsKey(isNotNull()));
    }
}
