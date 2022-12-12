package com.locationproject.Service;

import com.locationproject.Model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class LocationService {

    private WebClient webClient;

    @Autowired
    public LocationService(@Qualifier("locationWebClient") WebClient webclient) {
        this.webClient = webclient;
    }

    public String getCityLocation() {

        Location locations = new Location();
        try{
            locations = webClient.get().retrieve().bodyToMono(Location.class).block();
        } catch (Exception e) {
            log.error("Location service error: " + e.getLocalizedMessage());
        }
        //TODO make object out of the result location response
        //For now, just get the location
        System.out.println("Result: " + locations.getCity());

        return locations.getCity();
    }
}
