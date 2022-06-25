package com.air.airtest.service.impl;

import com.air.airtest.entity.User;
import com.air.airtest.mapper.UserMapper;
import com.air.airtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaodaodao
 * @description
 * @create 2022-06-25
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper umapper;
    @Override
    public User selectUser(int id) {
        return umapper.selectUser(id);
    }

}
