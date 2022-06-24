package com.air.airtest.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("handel")
@Data
public class Handel {
    private String hotelstaffno;
    private String orderno;
    private String roomno;
    private Date handeldate;
}
