package com.ams.accountmanagementsystem.modeltest;

import com.ams.accountmanagementsystem.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testUserConstructorAndGetters() {
        String customerId = "CID123";
        String name = "John";
        String surname = "Doe";
        User user = new User(customerId, name, surname);
        assertEquals(customerId, user.getcustomerId());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
    }

    @Test
    void testUserSetters() {
        User user = new User("123", "John", "Doe");
        String newCustomerId = "456";
        String newName = "Jane";
        String newSurname = "Smith";
        user.setcustomerId(newCustomerId);
        user.setName(newName);
        user.setSurname(newSurname);
       assertEquals(newCustomerId, user.getcustomerId());
        assertEquals(newName, user.getName());
        assertEquals(newSurname, user.getSurname());
    }
}
