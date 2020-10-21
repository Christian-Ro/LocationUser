package com.locationproject.Service;

import com.locationproject.DAO.UserDAO;
import com.locationproject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GetLocation getLocation;

    public User saveUser(User user) {

        return userDAO.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return userDAO.saveAll(users);
    }

    public List<User> getUsers(){
        return userDAO.findAll();
    }

    public User getUserById(int id){
        return userDAO.getOne(id);
    }
    //TODO implement delete user by id
}
