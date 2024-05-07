package com.ams.accountmanagementsystem;
import com.ams.accountmanagementsystem.model.User;
import com.ams.accountmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationInitializer {

    private final UserService userService;

    @Autowired
    public ApplicationInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initialize() {
        User user1 = new User("123", "John", "Doe");
        User user2 = new User("456", "Alice", "Smith");
        User user3 = new User("100", "John", "Doe");
        User user4 = new User("200", "Alice", "Smith");

        Map<String, User> usersMap = new HashMap<>();
        usersMap.put(user1.getcustomerId(), user1);
        usersMap.put(user2.getcustomerId(), user2);
        usersMap.put(user3.getcustomerId(), user3);
        usersMap.put(user4.getcustomerId(), user4);

        userService.setUsers(usersMap);
    }
}
