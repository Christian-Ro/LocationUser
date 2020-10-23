package com.locationproject.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class GetLocation {

    public GetLocation(){

    }

    public String getLocationData() throws URISyntaxException{

        String location = "Test";
            //        String key = ""; //Get google ke
        RestTemplate restTemplate = new RestTemplate();
//
//        //final String baseUrl = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + key;
        final String baseUrl2 = "http://ip-api.com/json/";
        URI uri = new URI(baseUrl2);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        //TODO make object out of the result location response
        //For now, just get the location

        System.out.println("Result: "+ result.getHeaders().containsValue("zip"));


        return location;
    }
}
