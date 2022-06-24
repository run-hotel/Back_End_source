package com.air.airtest.service;

import java.util.List;

import com.air.airtest.entity.RoomType;

import org.apache.ibatis.annotations.Param;

public interface RoomTypeService {
    int updateRoomNumForReduce(String roomtypeno);
    int updateRoomNumForAdd(String roomtypeno);
    int updateRoomPrice(@Param("roomprice") float roomPrice,@Param("roomtypeno")String roomtypeno);
    List<RoomType> selectRoomType();
    String selectRoomTypeNoforRoomType(String roomtypename);
}
