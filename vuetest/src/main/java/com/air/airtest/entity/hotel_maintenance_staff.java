package com.air.airtest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hotel_maintenance_staff")
@Data
public class hotel_maintenance_staff {
  private String hotel_maintenance_staffNo;
  private String hotel_maintenance_staffPassword;
  private String hotel_maintenance_staffName;
  private String hotel_maintenance_staffSex;
  private String hotel_maintenance_staffPhone;
}
