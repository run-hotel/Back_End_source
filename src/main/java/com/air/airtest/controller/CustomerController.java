package com.air.airtest.controller;

import javax.annotation.Resource;

import com.air.airtest.common.Result;
import com.air.airtest.entity.Customer;
import com.air.airtest.mapper.CustomerMapper;
import com.air.airtest.service.CustomerService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @Resource
    CustomerMapper customerMapper;

    @GetMapping("/selectcustomer")
    public Result<?> selectcustomer(@RequestParam(defaultValue = "") String customerphone){
        //System.out.println("____>"+customerphone);
        Customer as = customerService.getInfo(customerphone);
        //System.out.println("____>"+as);
        return Result.success(as);
    }
       // 注册
       @PostMapping("/register")
       public Result<?> register(@RequestBody Customer customer) // throws IOException{
       {
           Customer res = customerMapper.selectOne(
                   Wrappers.<Customer>lambdaQuery().eq(Customer::getCustomerphone, customer.getCustomerphone()));
           if (res != null) {
               return Result.error("-1", "用户名重复");
           }
           if (customer.getCustomerpassword() == null) {
               customer.setCustomerpassword("123456");
           }
           customerMapper.insert(customer);
           return Result.success();
       }
  
       
      // 酒店游客登录
      @PostMapping("/login")
      public Result<?> login(@RequestBody Customer customer) {
          Customer res = customerMapper
                  .selectOne(Wrappers.<Customer>lambdaQuery().eq(Customer::getCustomerphone, customer.getCustomerphone())
                          .eq(Customer::getCustomerpassword, customer.getCustomerpassword()));
          if (res == null) {
              return Result.error("-1", "用户名或密码错误");
          }
          return Result.success();
      }

      //更新用户信息
      @GetMapping("/updatecustomer")
      public Result<?> updatecustomer(@RequestParam(defaultValue = "") String customersex,@RequestParam(defaultValue = "") String customername,
                                      @RequestParam(defaultValue = "") String customerid,@RequestParam(defaultValue = "") String customerphone)
      {
          System.out.println("&&&&"+customersex);
          System.out.println("&&&&"+customername);
          System.out.println("&&&&"+customerid);
          System.out.println("&&&&"+customerphone);
        int a = customerService.updateCustomerInfo(customersex, customername, customerid, customerphone);
        System.out.println(a);
        return Result.success(a);
     }

}
