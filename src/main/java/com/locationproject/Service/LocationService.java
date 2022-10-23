package com.locationproject.Service;

import com.locationproject.Model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LocationService {

    private WebClient webClient;

    @Autowired
    public LocationService(@Qualifier("locationWebClient") WebClient webclient) {
        this.webClient = webclient;
    }

    public String getCityLocation() {
        System.out.println("Webclient: " + webClient.get().retrieve().getClass().getName());
        Location locations = webClient.get().retrieve().bodyToMono(Location.class).block();
        //TODO make object out of the result location response
        //For now, just get the location

        System.out.println("Result: " + locations.getCity());


        return locations.getCity();
    }
}
