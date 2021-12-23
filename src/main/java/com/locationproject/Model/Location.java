package com.locationproject.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String zip;
    private String lat;
    private String lon;
    private String timezone;
    private String isp;
    private String org;
    private String as;
    private String query;
}
