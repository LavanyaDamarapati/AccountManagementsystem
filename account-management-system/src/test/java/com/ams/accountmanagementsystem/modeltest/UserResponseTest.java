package com.ams.accountmanagementsystem.modeltest;

import com.ams.accountmanagementsystem.model.Transaction;
import com.ams.accountmanagementsystem.model.UserResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserResponseTest {

    @Test
    void testUserResponseConstructorAndGetters() {
        String name = "John";
        String surname = "Doe";
        double balance = 100.0;
        Transaction transaction = new Transaction("1", "123", 50.0);
        UserResponse userResponse = new UserResponse(name, surname, balance, transaction);
        assertEquals(name, userResponse.getName());
        assertEquals(surname, userResponse.getSurname());
        assertEquals(balance, userResponse.getBalance());
        assertEquals(transaction, userResponse.getTransaction());
    }

    @Test
    void testUserResponseSetters() {
        UserResponse userResponse = new UserResponse("John", "Doe", 100.0, new Transaction("1", "456", 50.0));
        String newName = "Jane";
        String newSurname = "Smith";
        double newBalance = 200.0;
        Transaction newTransaction = new Transaction("1456", "789", 75.0);
        userResponse.setName(newName);
        userResponse.setSurname(newSurname);
        userResponse.setBalance(newBalance);
        userResponse.setTransaction(newTransaction);
        assertEquals(newName, userResponse.getName());
        assertEquals(newSurname, userResponse.getSurname());
        assertEquals(newBalance, userResponse.getBalance());
        assertEquals(newTransaction, userResponse.getTransaction());
    }
}
