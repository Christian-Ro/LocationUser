package com.locationproject.Service;

import com.locationproject.Model.User;
import com.locationproject.Repository.LocationRepository;
import com.locationproject.Repository.MockUserRepository;
import com.locationproject.Repository.UserRepository;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    private UserService testService;
    private LocationService locationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("mockLocationServiceWebClient")
    private WebClient mockLocationWebClient;
    @Autowired
    @Qualifier("mockWebServer")
    private MockWebServer mockWebServer;

    @BeforeEach
    public void setup() {
        locationService = new LocationService(mockLocationWebClient);
        testService = new UserService(userRepository, locationService);
    }

    @Test
    public void saveUserSuccess() {
        User testUser = new User();
        testUser.setUserName("John");
        testUser.setLocation("WorldWide");

        User userResponse = testService.saveUser(testUser);


        assertNotNull(userResponse, "Value is null");
        assertEquals("John", userResponse.getUserName(), "Not the same value");
    }

    @AfterEach
    public void shutDown() throws IOException {
        mockWebServer.shutdown();
    }
}
