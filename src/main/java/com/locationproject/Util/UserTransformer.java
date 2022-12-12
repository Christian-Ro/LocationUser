package com.locationproject.Util;

import com.locationproject.Model.User;
import com.locationproject.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTransformer {

    private LocationService locationService;

    @Autowired
    public UserTransformer(LocationService locationService) {
        this.locationService = locationService;
    }

    public User transformUser(User user) {

        String city = locationService.getCityLocation();
        user.setLocation(city);

        return user;
    }
}
