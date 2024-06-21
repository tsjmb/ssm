package com.controller;

import com.domain.User;
import com.service.UserService;
import com.utils.Code;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request){
        Integer code;
        String msg;
        System.out.println(user);
        User user1 = userService.findByUsername(user.getUsername());
        if(user1==null){
            code= Code.GET_ERR;
            msg="没有这个用户";
//            System.out.println("没有这个用户");
        }else{
            if(user1.getPassword().equals(user.getPassword()) && user1.getIdentification()==user.getIdentification()){
                code=Code.GET_OK;
                msg="登录成功";
//                System.out.println("登录成功");
                request.getSession().setAttribute("user", user);
            }else if(user1.getIdentification()!=user.getIdentification()){
                code= Code.GET_ERR;
                msg="没有这个用户";
            }else{
                code=Code.GET_ERR;
                msg="密码错误";
//                System.out.println("密码错误");
            }
        }
        return new Result(code,user1,msg);
    }

//    @GetMapping("/{username}")
//    public Result getUserInfo(@PathVariable String username){
//        User user = userService.findByUsername(username);
//        return new Result(Code.GET_OK,user);
//    }

    @GetMapping("/info/{id}")
    public Result getUserInfoById(@PathVariable int id){
        User user = userService.findByUserId(id);
        return new Result(Code.GET_OK,user);
    }

    @PutMapping
    public Result updateEmployeeInfo(@RequestBody User user){
        boolean flag = userService.updateUser(user);
        return new Result(Code.UPDATE_OK,flag);
    }
}
