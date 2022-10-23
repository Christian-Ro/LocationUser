package com.locationproject.Configuration;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

    @Bean(value = "mockWebServer")
    public MockWebServer mockWebServer() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.enqueue(new MockResponse().setBody("WorldWide").addHeader("Content-Type", "application/json"));
        mockWebServer.start();
        return  mockWebServer;
    }

    @Primary
    @Bean(value = "locationServiceWebClient")
    public WebClient locationServiceWebClient(@Qualifier("mockWebServer") MockWebServer mockWebServer) {

        String baseUrl = UriComponentsBuilder.newInstance().scheme("http").host(mockWebServer.getHostName() + ":" + mockWebServer.getPort()).build().toUriString();

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", baseUrl))
                .build();
    }
}
