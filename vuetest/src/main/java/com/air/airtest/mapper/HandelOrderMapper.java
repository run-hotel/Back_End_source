package com.air.airtest.mapper;

import java.util.List;

import com.air.airtest.entity.Handel;
import com.air.airtest.vo.Hotelvo;

public interface HandelOrderMapper {
    int insertHandel(Handel handel);
    String selectHandelRoomNo(String orderno);
    List<Hotelvo> selectHandelOrder(String hotelstaffno);
}
