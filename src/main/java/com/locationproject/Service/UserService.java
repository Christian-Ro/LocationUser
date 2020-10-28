package com.locationproject.Service;

import com.locationproject.DAO.UserDAO;
import com.locationproject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GetLocation getLocation;

    public User saveUser(User user) throws URISyntaxException {
        user.setLocation(getLocation.getLocationData());
        return userDAO.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return userDAO.saveAll(users);
    }

    public List<User> getUsers(){
        return userDAO.findAll();
    }

    public User getUserById(int id){
        return userDAO.findById(id).get();
    }

    public String deleteUserById(int id){
        userDAO.deleteById(id);
        return "User deleted!";
    }

    //TODO check returning of more than one user
    public User getUserByName(String name){
        return userDAO.findByUserName(name);
    }
}
