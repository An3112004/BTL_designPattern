package com.example.service;

import com.example.dao.user.UserDAO;
import com.example.model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }

}
