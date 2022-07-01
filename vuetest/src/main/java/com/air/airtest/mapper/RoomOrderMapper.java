package com.air.airtest.mapper;

import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
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
