package com.air.airtest.service;

import java.util.List;

import com.air.airtest.entity.RoomInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface RoomService extends BaseMapper<RoomInfo>{
    List<RoomInfo> selectRoomInfo();
    int updateRoomStatus(String roomno);
    int updateStatusForRepair(String roomno);
    int updateStatusForLive(String roomno);
    String selectRoomTypeNo(String roomno);
    List<Hotelvo> selectRemainingRooms(String roomtypename);
}
