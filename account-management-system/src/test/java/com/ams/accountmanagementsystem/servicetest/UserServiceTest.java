package com.ams.accountmanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ams.accountmanagementsystem.model.User;
import com.ams.accountmanagementsystem.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private Map<String, User> users;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        users = new HashMap<>();
        users.put("123", new User("123", "John", "Doe"));
        userService.setUsers(users);
    }

    @Test
    void testCustomerExists() {
        String customerId = "123";
        boolean exists = userService.customerExists(customerId);
        assertTrue(exists);
    }

    @Test
    void testCustomerDoesNotExist() {
        String customerId = "200";
        boolean exists = userService.customerExists(customerId);
        assertFalse(exists);
    }

  
    @Test
    void testUserDoesNotExist() {
        String customerId = "101";
        User actualUser = userService.getUser(customerId);
        assertNull(actualUser);
    }
}
