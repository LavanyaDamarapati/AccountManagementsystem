package com.ams.accountmanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ams.accountmanagementsystem.model.Account;
import com.ams.accountmanagementsystem.model.AccountRequest;
import com.ams.accountmanagementsystem.model.Transaction;
import com.ams.accountmanagementsystem.model.User;
import com.ams.accountmanagementsystem.model.UserResponse;
import com.ams.accountmanagementsystem.service.AccountService;
import com.ams.accountmanagementsystem.service.TransactionService;
import com.ams.accountmanagementsystem.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class CurrentAccountController {

    private static final Logger logger = Logger.getLogger(CurrentAccountController.class.getName());

    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    public CurrentAccountController(UserService userService, AccountService accountService, TransactionService transactionService) {
        this.userService = userService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }
//Method to open a new current account
    @PostMapping("/accounts")
    public ResponseEntity<String> openCurrentAccount(@RequestBody AccountRequest accountRequest) {
        try {
        	String  customerId = accountRequest.getCustomerId();
            double initialCredit = accountRequest.getInitialCredit();

        	if  (!userService.customerExists(customerId)) {
                 String errorMessage = "CustomerID " + customerId + " does not exist.";
                 logger.log(Level.SEVERE, errorMessage);
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
             }

             accountService.openAccount(customerId, initialCredit);
             return ResponseEntity.ok("Account opened successfully for the  customer ID " + customerId);
         } catch (Exception e) {
             String errorMessage = "Error while opening the  account: " + e.getMessage();
             logger.log(Level.SEVERE, errorMessage, e);
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
         }
     } 
    
//Method to fetch all the user details  
    @GetMapping("/users/{customerId}")
     public ResponseEntity<UserResponse> getUserInformation(@PathVariable String customerId) {
         try {
             if (!userService.customerExists(customerId)) {
                 String errorMessage = "CustomerID " + customerId + " doesn't exist.";
                 logger.log(Level.SEVERE, errorMessage);
                 return ResponseEntity.notFound().build();
             }
             User user = userService.getUser(customerId);
             Account account = accountService.getAccountByCustomerId(customerId);
             Transaction transaction = transactionService.getTransactionByAccountId(account.getAccountId());

             UserResponse userResponse = new UserResponse(user.getName(), user.getSurname(), account.getBalance(), transaction);
             return ResponseEntity.ok(userResponse);
         } catch (Exception e) {
             String errorMessage = "Error while retrieving the user information: " + e.getMessage();
             logger.log(Level.SEVERE, errorMessage, e);
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
     }
 }