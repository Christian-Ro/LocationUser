package com.locationproject.Service;

import com.locationproject.Application;
import com.locationproject.Configuration.TestConfiguration;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@SpringBootTest(classes = {Application.class, TestConfiguration.class})
public class LocationServiceTest {

    private LocationService testLocation;

    @Autowired
    @Qualifier("locationServiceWebClient")
    private WebClient mockLocationWebClient;
    @Autowired
    private MockWebServer mockWebServer;

    @BeforeEach
    public void setup() {
  
        testLocation = new LocationService(mockLocationWebClient);
    }

    @Test
    public void locationRetrievalTest() throws InterruptedException {
//        RecordedRequest recordedRequest = mockWebServer.takeRequest();
//        System.out.println("Path: " + recordedRequest.getPath());
        String returnedCity = testLocation.getCityLocation();

        Assertions.assertEquals("City", returnedCity);
    }

    @AfterEach
    public void shutDown() throws IOException {
        mockWebServer.shutdown();
    }
}
