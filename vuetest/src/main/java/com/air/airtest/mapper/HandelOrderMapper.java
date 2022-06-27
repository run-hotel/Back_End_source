package com.air.airtest.mapper;

import com.air.airtest.entity.Handel;
import com.air.airtest.vo.Hotelvo;

import java.util.List;

public interface HandelOrderMapper {
    int insertHandel(Handel handel);
    String selectHandelRoomNo(String orderno);
    List<Hotelvo> selectHandelOrder(String hotelstaffno);
}
