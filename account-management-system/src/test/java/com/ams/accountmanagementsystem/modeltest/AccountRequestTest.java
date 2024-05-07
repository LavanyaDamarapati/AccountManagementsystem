package com.ams.accountmanagementsystem.modeltest;

import org.junit.jupiter.api.Test;

import com.ams.accountmanagementsystem.model.AccountRequest;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRequestTest {

    @Test
    void testGettersAndSetters() {
        String customerId = "123";
        double initialCredit = 100.0;
        AccountRequest accountRequest = new AccountRequest(customerId, initialCredit);
        assertEquals(customerId, accountRequest.getCustomerId());
        assertEquals(initialCredit, accountRequest.getInitialCredit(), 0.0);
    }
}
