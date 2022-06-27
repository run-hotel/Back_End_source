package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("room")
@Data
public class RoomInfo {
    private String roomno;
    private String roomtypeno;
    private int roomstatus;
    private String roomfloor;
}
