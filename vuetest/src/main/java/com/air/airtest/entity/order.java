package com.air.airtest.entity;



import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("order")
@Data
public class order {
  private String RoomNo;
  private String RoomTypeNo;
  private int RoomStatus;
  private String RoomFloor;
}
