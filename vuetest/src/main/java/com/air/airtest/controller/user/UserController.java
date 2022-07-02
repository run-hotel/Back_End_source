package com.air.airtest.controller.user;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.air.airtest.entity.User;
import com.air.airtest.response.AjaxResult;
import com.air.airtest.response.MsgType;
import com.air.airtest.response.ResponseTool;
import com.air.airtest.service.UserService;
import com.air.airtest.utils.MD5Utils;
import com.air.airtest.utils.SendmailUtil;
import com.air.airtest.utils.VerifyCodeUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.KeyPair;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 私钥和公钥
     */
    private static String privateKey;
    private static String publicKey;

    private static String encryptByPublic;
    private static String decryptByPrivate;
    private static String encryptByPrivate;
    private static String decryptByPublic;

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

    @Test
    public void Test() {
        String text = "HelloWorld";
        // 初始化对象
        // 第一个参数为加密算法，不传默认为 RSA/ECB/PKCS1Padding
        // 第二个参数为私钥（Base64字符串）
        // 第三个参数为公钥（Base64字符串）
        RSA rsa = new RSA(AsymmetricAlgorithm.RSA_ECB_PKCS1.getValue(), privateKey, publicKey);

        // 公钥加密，私钥解密
        encryptByPublic = rsa.encryptBase64(text, KeyType.PublicKey);
        System.out.println("公钥加密：" + encryptByPublic);
        decryptByPrivate = rsa.decryptStr(encryptByPublic, KeyType.PrivateKey);
        System.out.println("私钥解密：" + decryptByPrivate);

        // 私钥加密，公钥解密
        encryptByPrivate = rsa.encryptBase64(text, KeyType.PrivateKey);
        System.out.println("私钥加密：" + encryptByPrivate);
        decryptByPublic = rsa.decryptStr(encryptByPrivate, KeyType.PublicKey);
        System.out.println("公钥解密：" + decryptByPublic);

    }

    @Autowired
    private UserService userService;

    /**
     * 更新课户信息
     *
     * @param userId
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public AjaxResult userUpdate(Integer userId, String name, String gender, String phone,
                                 String email, String address, String idcard, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!session.getAttribute("userId").equals(userId)) {
            return ResponseTool.failed(MsgType.PERMISSION_DENIED);
        }
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setIdcard(idcard);
        if (userService.updateUser(user) == 1)
            return ResponseTool.success("修改成功");
        return ResponseTool.success("修改失败，请检查或稍后再试");
    }
    /**
     * 更改密码
     *
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updatePassword")
    public AjaxResult updatePassword(String username, String oldPassword, String newPassword) {
        User user = userService.selectByUsernameAndPassword(username, oldPassword);
        if (user == null) {
            return ResponseTool.failed("密码不对");
        }
        user.setPassword(newPassword);
        if (userService.updateUser(user) == 1)
            return ResponseTool.success("修改成功");
        return ResponseTool.failed("修改失败");
    }

    /**
     * 获取个人资料
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/profile")
    public AjaxResult getProfile(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.selectByUsername(username);
        if (user == null) return ResponseTool.failed("未知错误");
        user.setPassword(null);
        StringBuilder sb = new StringBuilder(user.getIdcard());
        sb.replace(5, 12, "********");
        user.setIdcard(sb.toString());
        return ResponseTool.success(user);
    }


    @RequestMapping("/checkUserOremail")
    public AjaxResult checkUsernameAndEmail(HttpSession session, String username, String email) {
        User user = userService.selectByUsername(username);
        if (user == null)
            return ResponseTool.failed("用户不存在");
        if (user.getEmail().equals(email)) {
            try {
                String verifyCode = null;
                // 如果验证码等于空的话就通过邮箱发送
                verifyCode = VerifyCodeUtil.generateVerifyCode(6);
                String emailTitle = "【嘉丽酒店管理系统】邮箱验证";
                String emailContent = "您正在【嘉丽酒店管理系统】进行邮箱验证，您的验证码为：" + verifyCode + "，请于5分钟内完成验证！";
                SendmailUtil.sendEmail(email, emailTitle, emailContent);
                session.setMaxInactiveInterval(60);
                System.out.println(session.getId());
                session.setAttribute("code", verifyCode);
                return ResponseTool.success("请到邮箱获取验证码");
                // 如果不等于空的话就直接进行验证
            } catch (Exception e) {
               /* model.addAttribute("info", errorInfo);
                return "findPass";*/
            }
        }
        //返回邮箱或者用户名不存在
        return ResponseTool.failed("邮箱输入错误");
    }
    @RequestMapping("/checkCode")
    public AjaxResult checkCode(HttpSession session, String code, String username) {
        if (userService.selectByUsername(username) == null)
            return ResponseTool.failed("用户未登录");
        String vertifyCode = (String) session.getAttribute("code");
        if (code.equals(vertifyCode))
            return ResponseTool.success();
        return ResponseTool.failed("验证码错误");
    }
    /**
     * x修改密码
     *
     * @param session
     * @param password
     * @param
     * @return
     */
    @RequestMapping(value = "/resetPass", method = RequestMethod.POST)
    public AjaxResult resetPass(HttpSession session, String password, String username) {
        User user = userService.selectByUsername(username);
        if (user == null)
            return ResponseTool.failed("用户名不存在");
        //密码
        user.setPassword(MD5Utils.MD5Encode(password));
        userService.updateUser(user);
        session.removeAttribute("code");
        return ResponseTool.success();
    }
    /**
     * 注销
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public AjaxResult logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("userId");
            session.removeAttribute("username");
            return ResponseTool.success("注销成功");
        }
        return ResponseTool.failed("未登录");
    }


}
