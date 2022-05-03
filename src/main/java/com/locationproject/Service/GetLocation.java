package com.locationproject.Service;

import com.locationproject.Model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
public class GetLocation {

    @Autowired
    @Qualifier("locationWebClient")
    private WebClient webClient;

    @Autowired
    public GetLocation() {
    }

    public String getLocationData() {

        Location locations = webClient.get().retrieve().bodyToMono(Location.class).block();
        //TODO make object out of the result location response
        //For now, just get the location

        System.out.println("Result: " + locations.getCity());


        return locations.getCity();
    }
}
