package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
@TableName("roomorder")
@Data
public class RoomOrderInfo {
    private String hotelstaffno;
    private String orderno;
    private String customerphone;
    private Date inttime;
    private Date outtime;
    private String roomtypename;
    private int orderstatus;
}