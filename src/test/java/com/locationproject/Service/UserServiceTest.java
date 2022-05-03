package com.locationproject.Service;

import com.locationproject.Model.User;
import com.locationproject.Repository.UserRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @Autowired
    private UserService testService;

    private UserRepositoryTest userRepositoryTest;
    @BeforeEach
    public void setup() {
        testService = new UserService(userRepositoryTest);
    }

    @Test
    public void saveUserSuccess() {

        User testUser = new User();
        testUser.setUserName("John");
        testUser.setLocation("WorldWide");
        User userResponse = testService.saveUser(testUser);

        assertEquals("John", userResponse.getUserName(), "Not the same value");
    }
}
