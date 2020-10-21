package com.locationproject.Controller;

import com.locationproject.Model.User;
import com.locationproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUser(@RequestBody List<User> users){
        return userService.saveUsers(users);
    }

    @GetMapping("/Users")
    public List<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
