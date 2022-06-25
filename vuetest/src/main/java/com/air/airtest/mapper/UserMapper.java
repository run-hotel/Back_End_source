package com.air.airtest.mapper;

import com.air.airtest.entity.User;
// import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

// public interface UserMapper extends BaseMapper<User>{
    
// }
@Mapper
public interface UserMapper{
    //添加一个用户
    int insertUser(User user);
    String updateUser(User user);
    User selectUser(int id);
    User queryByUsername(String username);
}