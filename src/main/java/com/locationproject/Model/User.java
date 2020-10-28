package com.locationproject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class User {

    @Id
    @GeneratedValue
    private int userID; //Auto generated value TODO change it to a uuid
    private String userName;
    private String location;

    //Constructor TODO change it to a build patter
    public User(){

    }

    //Getters and setters
    public int getUserID(){
        return userID;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
