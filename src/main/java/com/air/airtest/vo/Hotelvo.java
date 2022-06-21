package com.air.airtest.vo;

import java.sql.Date;

import lombok.Data;
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
