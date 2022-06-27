package com.air.airtest.mapper;

import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface RoomOrderMapper extends BaseMapper<RoomOrderInfo>{
    List<RoomOrderInfo> selectRoomOrderInfo();
    int updateOrderStatus(String id);
    int updateOrderStatusForCancel(String id);
    RoomOrderInfo selectRoomOrderone(String id);
    List<Hotelvo> selectRoomForPeople(String Roomno);
    int addOrder(RoomOrderInfo roomOrderInfo);
    List<RoomOrderInfo> selectOrder(String customerphone);
    List<Hotelvo> salesVolumes();
}
