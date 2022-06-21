package com.air.airtest.mapper;

import java.util.List;

import com.air.airtest.entity.RoomInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RoomMapper  extends BaseMapper<RoomInfo>{
    List<RoomInfo> selectRoomInfo();
    int updateRoomStatus(String roomno);
    int updateStatusForRepair(String roomno);
    int updateStatusForLive(String roomno);
    String selectRoomTypeNo(String roomno);
    List<Hotelvo> selectRemainingRooms(String roomtypename);
}