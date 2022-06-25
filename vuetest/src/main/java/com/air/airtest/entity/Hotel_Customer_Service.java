package com.air.airtest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hotel_customer_service")
@Data
public class Hotel_Customer_Service {
  private String hotel_customer_serviceNo;
  private String hotel_customer_servicePassword;
  private String hotel_customer_serviceName;
  private String hotel_customer_serviceSex;
  private String hotel_customer_servicePhone;
}

