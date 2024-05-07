package com.ams.accountmanagementsystem.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ams.accountmanagementsystem.controller.CurrentAccountController;
import com.ams.accountmanagementsystem.model.Account;
import com.ams.accountmanagementsystem.model.AccountRequest;
import com.ams.accountmanagementsystem.model.Transaction;
import com.ams.accountmanagementsystem.model.User;
import com.ams.accountmanagementsystem.service.AccountService;
import com.ams.accountmanagementsystem.service.TransactionService;
import com.ams.accountmanagementsystem.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrentAccountControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private CurrentAccountController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testOpenCurrentAccount() throws Exception {
        when(userService.customerExists("200")).thenReturn(true);
        when(accountService.openAccount("200", 100)).thenReturn(new Account("200", "200", 100));
        AccountRequest request = createAccountRequest("200", 100);
        mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
        verify(userService, times(1)).customerExists("200");
        verify(accountService, times(1)).openAccount("200", 100);
    }

    private AccountRequest createAccountRequest(String customerId, double initialCredit) {
        return new AccountRequest(customerId, initialCredit);
    }

    @Test
    public void testGetUserInformation() throws Exception {
        when(userService.customerExists("123")).thenReturn(true);
        when(userService.getUser("123")).thenReturn(new User("123", "John", "Doe"));
        when(accountService.getAccountByCustomerId("123")).thenReturn(new Account("1", "123", 100));
        when(transactionService.getTransactionByAccountId("1")).thenReturn(new Transaction("1", "123", 100));
        mockMvc.perform(get("/users/123"))
                .andExpect(status().isOk());
    }
}
