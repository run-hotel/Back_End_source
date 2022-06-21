package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("roomtype")
@Data
public class RoomType {
    private String roomtypeno;
    private String roomtypename;
    private int roomnumber;
    private float roomprice;
}
