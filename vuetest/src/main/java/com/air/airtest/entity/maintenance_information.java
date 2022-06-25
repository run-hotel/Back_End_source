package com.air.airtest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("maintenance_information")
@Data
public class maintenance_information {
  private String RoomNo;
  private String hotel_maintenance_staffNo;
  private String Repair_content;
  private int Maintenance_costs;
}
