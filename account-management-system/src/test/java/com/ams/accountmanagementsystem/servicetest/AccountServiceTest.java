package com.ams.accountmanagementsystem.servicetest;

import com.ams.accountmanagementsystem.model.Account;
import com.ams.accountmanagementsystem.service.AccountService;
import com.ams.accountmanagementsystem.service.TransactionService;
import com.ams.accountmanagementsystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @Mock
    private UserService userService;

    private Map<String, Account> accounts;

    @BeforeEach
    void setUp() {
        accounts = new HashMap<>();
        MockitoAnnotations.initMocks(this); 
        accountService = new AccountService(accounts, transactionService, userService); 
    }

    @Test
    void testOpenAccount() {
        String customerId = "123";
        double initialCredit = 100.0;
        when(userService.customerExists(customerId)).thenReturn(true);
        Account account = accountService.openAccount(customerId, initialCredit);
        assertNotNull(account);
    }
    @Test
    void testOpenAccount_CustomerDoesNotExist() {
        String customerId = "50";
        double initialCredit = 100.0;
        when(userService.customerExists(customerId)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> accountService.openAccount(customerId, initialCredit));
    }

    @Test
    void testAccountExists() {
        String customerId = "123";
        Account expectedAccount = new Account("123", customerId, 0);
        accounts.put("123", expectedAccount);
        Account actualAccount = accountService.getAccountByCustomerId(customerId);
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    void testAccountDoesNotExist() {
        String customerId = "112";
        assertThrows(IllegalArgumentException.class, () -> accountService.getAccountByCustomerId(customerId));
    }

}
