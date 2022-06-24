package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("hotelstaff")
@Data
public class HotelStaff {
    private String hotelstaffno;
    private String hotelstaffpassword;
    private String hotelstaffname;
    private String hotelstaffsex;
    private String hotelstaffphone;
    
}
