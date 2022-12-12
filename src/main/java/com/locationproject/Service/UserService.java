package com.locationproject.Service;

import com.locationproject.Repository.UserRepository;
import com.locationproject.Model.User;
import com.locationproject.Util.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserTransformer userTransformer;

    @Autowired
    public UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }
    public User saveUser(User user) {

        User transformUser = userTransformer.transformUser(user);

        User savedUser = userRepository.save(transformUser);

        return savedUser;
    }

    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    public String deleteUserById(int id){
        userRepository.deleteById(id);
        return "User deleted!";
    }

    //TODO check returning of more than one user
    public User getUserByName(String name){
        return userRepository.findByUserName(name);
    }
}
