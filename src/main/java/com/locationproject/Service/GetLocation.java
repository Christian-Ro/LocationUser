package com.locationproject.Service;

import com.locationproject.Model.Location;
import com.locationproject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
public class GetLocation {

    @Autowired
    public GetLocation(){

    }

    public String getLocationData() {

        String location = "Test";
            //        String key = ""; //Get google key
//        //final String baseUrl = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + key;
        final String baseUrl2 = "http://ip-api.com/json/";

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl2)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", baseUrl2))
                .build();

        Location locations = webClient.get().retrieve().bodyToMono(Location.class).block();
        //TODO make object out of the result location response
        //For now, just get the location

        System.out.println("Result: "+ locations.getCity());


        return locations.getCity();
    }
}
