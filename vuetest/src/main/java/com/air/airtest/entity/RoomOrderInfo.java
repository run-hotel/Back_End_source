package com.air.airtest.entity;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("roomorder")
@Data
public class RoomOrderInfo {
    private String orderno;
    private String customerphone;
    private Date inttime;
    private Date outtime;
    private String roomtypename;
    private int orderstatus;
}
