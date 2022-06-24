package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("customer")
@Data
public class Customer {
    private String customerphone;
    private String customerpassword;
    private String customername;
    private String customerid;
    private String customersex;
}
