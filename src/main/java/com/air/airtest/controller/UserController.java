package com.air.airtest.controller;

import javax.annotation.Resource;

import com.air.airtest.common.Result;
import com.air.airtest.entity.User;
import com.air.airtest.mapper.UserMapper;
import com.air.airtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping
    public Result<?> save(@RequestBody User user){
        userMapper.insertUser(user);
        return Result.success();
    }

    @Autowired
    UserService userService;
    
    @GetMapping("/getInfo/{id1}")
    public User queryUserInfo(@PathVariable("id1") Integer id){
        //String result = null;
        if(id!=null&&userService!=null){
            //result = userService.selectUser(id).toString();
            User relt =  userService.selectUser(id);
            System.out.println(relt);
            return relt;
        }else{
           return null;
        }
        
    }
}
