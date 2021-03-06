package com.air.airtest.controller;


import javax.annotation.Resource;

import com.air.airtest.config.Result;
import com.air.airtest.controller.common.RegisterController;
import com.air.airtest.entity.Customer;
import com.air.airtest.mapper.CustomerMapper;
import com.air.airtest.service.CustomerService;
import com.air.airtest.utils.CryptUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @Resource
  CustomerMapper customerMapper;

  @Autowired
  RegisterController tmp;

  @GetMapping("/selectcustomer")
  public Result<?> selectcustomer(@RequestParam(defaultValue = "") String customerphone) {
    //System.out.println("____>"+customerphone);
    Customer as = customerService.getInfo(customerphone);
    //System.out.println("____>"+as);
    return Result.success(as);
  }
  // 注册
  public static String GetRandomCharAndNumber(int len) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i <len; i++) {
      int intRand = (int) (Math.random() * 10);
      char base = '0';
      char c = (char) (base + intRand % 10);
      sb.append(c);
    }
    return sb.toString();
  }
  //length用户要求产生字符串的长度
  public static String getRandomString(int length){
    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < length; i++){
      int number = random.nextInt(str.length());
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }
  @PostMapping("/register")
  public Result<?> register(@RequestBody Customer customer) // throws IOException{
  {
    Customer res = customerMapper.selectOne(
            Wrappers.<Customer>lambdaQuery().eq(Customer::getCustomerphone, customer.getCustomerphone()));
    if (res != null) {
      return Result.error("-1", "用户名重复");
    }
    if (customer.getCustomerpassword() == null) {
      // md5加密加盐后存入密码 即数据库中的密码解密后为123456
      customer.setCustomerpassword(CryptUtil.md5("123456"));
    } else {
      customer.setCustomerpassword(CryptUtil.md5(customer.getCustomerpassword()));
    }
    String str1 = GetRandomCharAndNumber(8 );
    String str2 = GetRandomCharAndNumber(8 );
    customer.setCustomerid(str2);
    String name = getRandomString(7);
    tmp.userRegister(str2, customer.getCustomerpassword(),
            name, "男",
            customer.getCustomerphone(),"",
            "南昌市", str2);
    customerMapper.insert(customer);

    return Result.success();
  }


  // 酒店游客登录
  @PostMapping("/login")
  public Result<?> login(@RequestBody Customer customer) {
    // 获取密码前要解密
    System.out.println("123123正在登录中");
    System.out.println(customer.getCustomerphone());
    System.out.println(customer.getCustomerpassword());
    Customer tmp = new Customer();
    Customer res = customerMapper
            .selectOne(Wrappers.<Customer>lambdaQuery().eq(Customer::getCustomerphone, customer.getCustomerphone())
                    .eq(Customer::getCustomerpassword, CryptUtil.md5(customer.getCustomerpassword())));
//                  .selectOne(Wrappers.<Customer>lambdaQuery().eq(Customer::getCustomerphone, customer.getCustomerphone())
//                          .eq(Customer::getCustomerpassword, customer.getCustomerpassword()));
    if (res == null) {
      return Result.error("-1", "用户名或密码错误");
    }
    return Result.success();
  }

  //更新用户信息(包括修改密码) 主键的联系方式不能修改
  @GetMapping("/updatecustomer")
  public Result<?> updatecustomer(@RequestParam(defaultValue = "") String customersex,@RequestParam(defaultValue = "") String customername,
                                  @RequestParam(defaultValue = "") String customerid,@RequestParam(defaultValue = "") String customerage,
                                  @RequestParam(defaultValue = "") String customerpassword)
  {
    System.out.println("&&&&"+customersex);
    System.out.println("&&&&"+customername);
    System.out.println("&&&&"+customerid);
    System.out.println("&&&&"+customerage);
    // 密码加密
    System.out.println("&&&&"+CryptUtil.md5(customerpassword));
    int a = customerService.updateCustomerInfo(customersex, customername, customerid, customerage, customerpassword);
    System.out.println(a);
    return Result.success(a);
  }

}
