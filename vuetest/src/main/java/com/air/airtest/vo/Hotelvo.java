package com.air.airtest.vo;

import lombok.Data;

import java.sql.Date;
@Data
public class Hotelvo {
    private String hotelstaffno;
    private String orderno;
    private String roomno;
    private String Customerphone;
    private Date inttime;
    private Date outtime;
    private String Roomtypename;
    private int Orderstatus;
    private int Salesvolumes;

}
