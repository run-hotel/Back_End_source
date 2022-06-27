package com.air.airtest.enums;

public enum RoomStatus {
    UNAVAILABLE(0,"不可用"),
    AVAILABLE(1,"空闲"),
    ORDERED(2,"被预订"),
    IN_USE(3,"已入住")
    ;
    private Integer code;
    private String status;

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    RoomStatus(Integer code,String status) {
        this.code = code;
        this.status = status;
    }

    public static void main(String[] args) {
        System.out.println(RoomStatus.ORDERED.getCode());
    }
}
