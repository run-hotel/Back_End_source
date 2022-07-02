package com.air.airtest.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.air.airtest.entity.User;
import com.air.airtest.mapper.UserMapper;
import com.air.airtest.service.UserService;
import com.air.airtest.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.KeyPair;
import java.util.List;

/**
 * @author zhaodaodao
 * @description
 * @create 2022-06-25
 */

@Service
public class UserServiceImpl implements UserService {

    /**
     * 私钥和公钥
     */
    private static String privateKey;
    private static String publicKey;

    private static String encryptByPublic;
    private static String decryptByPrivate;
    private static String encryptByPrivate;
    private static String decryptByPublic;
    RSA rsa = new RSA(AsymmetricAlgorithm.RSA_ECB_PKCS1.getValue(), privateKey, publicKey);

    /**
     * 生成公私钥
     */
    @BeforeAll
    public static void genKey() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        privateKey = Base64.encode(pair.getPrivate().getEncoded());
        System.out.println("私钥\t" + privateKey);
        publicKey = Base64.encode(pair.getPublic().getEncoded());
        System.out.println("公钥\t" + publicKey);
    }

    @Autowired
    UserMapper umapper;
    @Override
    public User selectUser(int id) {
        return umapper.selectUser(id);
    }


    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int addUser(User user) {
        user.setPassword(MD5Utils.MD5Encode(user.getPassword()));
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertUser(User user) {
        System.out.println(user);
        user.setPassword(MD5Utils.MD5Encode(user.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteByPrimaryKey(Integer.valueOf(MD5Utils.MD5Encode(String.valueOf(userId))));
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        String pass = MD5Utils.MD5Encode(password);
        return userMapper.selectByUsernameAndPassword(username,pass);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public PageInfo<User> selectAllUser(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllByPage(search);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public boolean insertBatchUser(List<User> list) {
        return userMapper.insertBatch(list);
    }

    @Override
    public int checkusernameAndemail(String username, String email, HttpSession session) {

        return 0;
    }

    @Override
    public void resetPassword(String username, String password) {

    }
}
