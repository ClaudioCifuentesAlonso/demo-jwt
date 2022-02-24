package com.claudio.jwt.demo.service;

import com.claudio.jwt.demo.model.Role;
import com.claudio.jwt.demo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
