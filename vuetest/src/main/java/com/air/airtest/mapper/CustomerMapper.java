package com.air.airtest.mapper;

import com.air.airtest.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends BaseMapper<Customer>{
    Customer getInfo(@Param("customerphone")String customerphone);
    //int updateCustomerInfo();
    int updateCustomerInfo(@Param("customersex")String customersex,
    @Param("customername")String customername,
    @Param("customerid")String customerid,
    @Param("customerage")String customerage,
    @Param("customerpassword")String customerpassword);
    
}
