package com.service;

import com.config.SpringConfig;
import com.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUsernameTest(){
        User user = userService.findByUsername("李四");
        System.out.println(user);
    }

//    @Test
//    public void addUserTest(){
//        User user = new User();
//        user.setId(124);
//        user.setUsername("李四");
//        user.setPassword("0000");
//        boolean b = userService.addUser(user);
//        System.out.println(b);
//    }


    @Test
    public void findByUserIdTest(){
        User user = userService.findByUserId(1);
        System.out.println(user);
    }

    @Test
    public void updateUserInfoTest(){
        User user = new User();
        user.setId(3);
        user.setPassword("123456");
        user.setUsername("王五");
        user.setImg("4a150bb2-7fd9-4634-b2fe-cbb59806b2c3.jpg");
        boolean b = userService.updateUser(user);
        System.out.println(b);
    }
}
