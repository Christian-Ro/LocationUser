package com.locationproject.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location {

    @Id
    private UUID id;
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
