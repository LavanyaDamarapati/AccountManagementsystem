package com.ams.accountmanagementsystem.modeltest;
import org.junit.jupiter.api.Test;

import com.ams.accountmanagementsystem.model.Account;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testConstructorAndGetters() {
        String accountId = "123";
        String customerId = "123";
        double balance = 100.0;
        Account account = new Account(accountId, customerId, balance);
        assertEquals(accountId, account.getAccountId());
        assertEquals(customerId, account.getCustomerId());
        assertEquals(balance, account.getBalance());
    }

    @Test
    void testSetters() {
        Account account = new Account("123", "123", 100.0);
        String newAccountId = "123";
        String newCustomerId = "123";
        double newBalance = 200.0;
        account.setAccountId(newAccountId);
        account.setCustomerId(newCustomerId);
        account.setBalance(newBalance);
        assertEquals(newAccountId, account.getAccountId());
        assertEquals(newCustomerId, account.getCustomerId());
        assertEquals(newBalance, account.getBalance());
    }
}
