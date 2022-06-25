package com.air.airtest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hotel_finance_staff")
@Data
public class hotel_finance_staff {
  private String hotel_finance_staffNo;
  private String hotel_finance_staffPassword;
  private String hotel_finance_staffName;
  private String hotel_finance_staffSex;
  private String hotel_finance_staffPhone;
}

