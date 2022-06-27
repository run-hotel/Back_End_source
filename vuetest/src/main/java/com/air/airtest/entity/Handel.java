package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
@TableName("handel")
@Data
public class Handel {
    private String hotelstaffno;
    private String orderno;
    private String roomno;
    private Date handeldate;
}
