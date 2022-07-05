package com.air.airtest.service;

import com.air.airtest.entity.Room;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface RoomService {
    List<RoomInfo> selectRoomInfo();
    int updateRoomStatus(String roomno);
    int updateRoomStatus1(Integer roomno);
    int updateRoomStatus2(Integer roomno);
    int updateStatusForRepair(String roomno);
    int updateStatusForLive(String roomno);
    String selectRoomTypeNo(String roomno);
    List<Hotelvo> selectRemainingRooms(String roomtypename);


    int insert(Room room);

    int delete(int roomId);

    int update(Room room);

    Room selectById(int roomId);

    Room selectByNumber(String roomNumber);

    List<Room> selectByStatus(int roomStatus);

    List<Room> selectByType(int typeId);

    List<Room> selectAll();

    int orderRoom(int typeId);

    int inRoom(int typeId);

    int booKingRoom(int typeId);

    int outRoom(int typeId);

    PageInfo<Room> selectAllByPage(Integer pageNum, Integer pageSize, String search);

    int deleteBatchIds(List<Integer> ids);

    List<Map<String, Integer>> selectGroupByType();

    Page<RoomInfo> selectPage(Page<Object> objectPage, LambdaQueryWrapper<RoomInfo> wrapper);
}
