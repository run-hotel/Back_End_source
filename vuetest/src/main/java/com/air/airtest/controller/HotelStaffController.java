package com.air.airtest.controller;

import com.air.airtest.config.Result;
import com.air.airtest.entity.HotelStaff;
import com.air.airtest.mapper.HotelStaffMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotelstaff")
public class HotelStaffController {
    //酒店员工登录
    @Resource
    HotelStaffMapper hstaffMapper;
    @PostMapping("/HSlogin")
    public Result<?> login(@RequestBody HotelStaff hs){
        HotelStaff res =  hstaffMapper.selectOne(Wrappers.<HotelStaff>lambdaQuery().eq(HotelStaff::getHotelstaffno, hs.getHotelstaffno()).eq(HotelStaff::getHotelstaffpassword, hs.getHotelstaffpassword()));
        if (res == null){
            return Result.error("-1", "用户名或密码错误");
        }
        return Result.success();
    }

}
