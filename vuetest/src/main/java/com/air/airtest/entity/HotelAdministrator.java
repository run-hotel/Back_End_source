package com.air.airtest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hoteladministrator")
@Data
public class HotelAdministrator {
  private String hoteladministratorNo;
  private String hoteladministratorPassword;
}
