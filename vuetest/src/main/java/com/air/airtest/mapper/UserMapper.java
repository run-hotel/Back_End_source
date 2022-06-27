package com.air.airtest.mapper;

import com.air.airtest.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

// public interface UserMapper extends BaseMapper<User>{
    
// }
@Mapper
@Component
public interface UserMapper{
    //添加一个用户
    int insertUser(User user);
    String updateUser(User user);
    User selectUser(int id);
    User queryByUsername(String username);

    List<User> selectAllByPage(String search);
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer getUserCount();

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User selectByUsername(String username);

    List<User> selectAll();

    List<User> selectAllUser();

    boolean insertBatch(List<User> list);
}