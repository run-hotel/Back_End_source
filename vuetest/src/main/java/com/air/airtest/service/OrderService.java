package com.air.airtest.service;

import java.util.List;

import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface OrderService extends BaseMapper<RoomOrderInfo>{
    List<RoomOrderInfo> selectRoomOrderInfo();
    int updateOrderStatus(String id);
    int updateOrderStatusForCancel(String id);
    RoomOrderInfo selectRoomOrderone(String id);
    List<Hotelvo> selectRoomForPeople(String Roomno);
    List<RoomOrderInfo> selectOrder(String customerphone);
    int addOrder(RoomOrderInfo roomOrderInfo);
    List<Hotelvo> salesVolumes();
}
