package com.locationproject.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "userinfo")
public class User {

    @Id
    @GeneratedValue
    private UUID userID; //Auto generated value TODO change it to a uuid
    private String userName;
    private String location;

    public User(){

    }

}
