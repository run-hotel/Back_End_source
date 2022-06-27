package com.air.airtest.mapper;

import com.air.airtest.entity.Room;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface RoomMapper  extends BaseMapper<RoomInfo>{
    List<RoomInfo> selectRoomInfo();
    int updateRoomStatus(String roomno);
    int updateStatusForRepair(String roomno);
    int updateStatusForLive(String roomno);
    String selectRoomTypeNo(String roomno);
    List<Hotelvo> selectRemainingRooms(String roomtypename);

    Integer getCount();
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    Room selectByNumber(String roomNumber);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectByType(Integer typeId);

    List<Room> selectByStatus(Integer roomStatus);

    List<Room> selectAll(String search);

    Room randomSelectByTypeAndStatus(@Param("typeId") Integer typeId, @Param("roomStatus") Integer roomStatus);

    int deleteBatch(List<Integer> ids);

    List<Map<String, Integer>> selectGroupByType();
}