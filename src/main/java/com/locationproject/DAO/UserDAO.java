package com.locationproject.DAO;

import com.locationproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUserName(String name);
}
