package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("customer")
@Data
public class Customer {
    private String customerphone; // 联系方式
    private String customerpassword; // 密码
    private String customername; // 名字
    private String customerid; // ID
    private String customersex; // 性别
    private String customerage; // 年龄
}
