package com.locationproject.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class GetLocation {

    public GetLocation() throws URISyntaxException {

        String key = ""; //Get google ke
        RestTemplate restTemplate = new RestTemplate();

        //final String baseUrl = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + key;
        final String baseUrl2 = "http://ip-api.com/json/";
        URI uri = new URI(baseUrl2);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        System.out.println("Result: "+ result.toString());
    }
}
