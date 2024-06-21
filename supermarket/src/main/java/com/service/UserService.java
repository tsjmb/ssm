package com.service;

import com.domain.User;

public interface UserService {
    User findByUsername(String username);
//    boolean addUser(User user);

    User findByUserId(int id);

    boolean updateUser(User user);
}
