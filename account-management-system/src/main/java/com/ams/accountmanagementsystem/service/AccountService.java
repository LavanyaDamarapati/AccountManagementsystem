package com.ams.accountmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.ams.accountmanagementsystem.model.Account;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountService {

    private static final Logger logger = Logger.getLogger(AccountService.class.getName());

    private final Map<String, Account> accounts;
    private final TransactionService transactionService;
    private final UserService userService;

    public AccountService(Map<String, Account> accounts, TransactionService transactionService, UserService userService) {
        this.accounts = accounts;
        this.transactionService = transactionService;
        this.userService = userService;
    }
//This method to open account
    public Account openAccount(String customerId, double initialCredit) {
        if (!userService.customerExists(customerId)) {
            logger.log(Level.SEVERE, "CustomerID " + customerId + " does not exist.");
            throw new IllegalArgumentException("CustomerID " + customerId + " does not exist.");
        }
        if (accountExistsForCustomer(customerId)) {
            throw new IllegalArgumentException("An account already exists for  the customer with  the ID " + customerId);
        }
        String accountId = generateAccountId(customerId); 
        Account account = new Account(accountId, customerId, 0); 

        accounts.put(account.getAccountId(), account);

        if (initialCredit != 0) {
            transactionService.createTransaction(account.getAccountId(), initialCredit);
            account.setBalance(initialCredit);
        }

        return account;
    }
 //This method to used to check  whether an account already exists for this customer or not 
    private boolean accountExistsForCustomer(String customerId) {
        for (Account account : accounts.values()) {
            if (account.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

//This method to generate AccountID
	private String generateAccountId(String customerId) {
        return customerId; 
    }

//This method to get the values of the account based on the CustomerID
    public Account getAccountByCustomerId(String customerId) {
        for (Account account : accounts.values()) {
            if (account.getCustomerId().equals(customerId)) {
                return account;
            }
        }
        logger.log(Level.SEVERE, "Account not found for the customerID " + customerId);
        throw new IllegalArgumentException("Account not found for the customerID " + customerId);
    }
}

