package com.air.airtest.service;

import com.air.airtest.entity.Handel;
import com.air.airtest.vo.Hotelvo;

import java.util.List;

public interface HandelService {
    int insertHandel(Handel handel);
    String selectHandelRoomNo(String orderno);
    List<Hotelvo> selectHandelOrder(String hotelstaffno);
}
