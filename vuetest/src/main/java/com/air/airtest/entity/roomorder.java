package com.air.airtest.entity;



import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@TableName("roomorder")
@Data
public class roomorder {
  private String HotelstaffNo;
  private String OrderNo;
  private String CustomerPhone;
  private Date inttime;
  private Date outtime;
  private String RoomTypeName;
  private int OrderStatus;
}
