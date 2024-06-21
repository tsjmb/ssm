package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findByUsername(String username) {
        return userDao.selectByName(username);
    }

//    @Override
//    public boolean addUser(User user) {
//        boolean flag;
//        Integer row = userDao.insertUser(user);
//        System.out.println(row);
//        flag=row>0?true:false;
//        return flag;
//    }

    @Override
    public User findByUserId(int id) {
        User user = userDao.selectById(id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        userDao.updateById(user);
        return true;
    }
}
