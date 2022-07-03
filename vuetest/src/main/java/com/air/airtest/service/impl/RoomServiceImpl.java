package com.air.airtest.service.impl;

import com.air.airtest.entity.Room;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.enums.RoomStatus;
import com.air.airtest.mapper.RoomMapper;
import com.air.airtest.service.RoomService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomMapper roomMapper;

   
    //重写的方法
    @Override
    public List<RoomInfo> selectRoomInfo() {
        // TODO Auto-generated method stub
        return roomMapper.selectRoomInfo();
    }

    @Override
    public int updateRoomStatus(String roomno) {
        // TODO Auto-generated method stub
        return roomMapper.updateRoomStatus(roomno);
    }
    @Override
    public int updateRoomStatus1(Integer roomno) {
        // TODO Auto-generated method stub
        System.out.println("roomno在这");
        System.out.println(roomno);
        return roomMapper.updateRoomStatus1(roomno);
    }

    @Override
    public int updateStatusForRepair(String roomno) {
        // TODO Auto-generated method stub
        return roomMapper.updateStatusForRepair(roomno);
    }

    @Override
    public int updateStatusForLive(String roomno) {
        // TODO Auto-generated method stub
        return roomMapper.updateStatusForLive(roomno);
    }

    @Override
    public String selectRoomTypeNo(String roomno) {
        // TODO Auto-generated method stub
        return roomMapper.selectRoomTypeNo(roomno);
    }

    @Override
    public List<Hotelvo> selectRemainingRooms(String roomtypename) {
        return null;
    }

    @Override
    public int insert(Room room) {
        return roomMapper.insertSelective(room);
    }

    @Override
    public int delete(int roomId) {
        return roomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    public int update(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public Room selectById(int roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    public Room selectByNumber(String roomNumber) {
        return roomMapper.selectByNumber(roomNumber);
    }

    @Override
    public List<Room> selectByStatus(int roomStatus) {
        return roomMapper.selectByStatus(roomStatus);
    }

    @Override
    public List<Room> selectByType(int typeId) {
        return roomMapper.selectByType(typeId);
    }

    @Override
    public List<Room> selectAll() {
        return roomMapper.selectAll(null);
    }

    @Override
    @Transactional
    public int orderRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId, RoomStatus.AVAILABLE.getCode());
        if (room == null) return -1;
        room.setRoomStatus(RoomStatus.ORDERED.getCode());
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    /**
     * 入住
     *
     * @param typeId
     * @return
     */
    @Override
    public int inRoom(int typeId) {

        Room room = roomMapper.randomSelectByTypeAndStatus(typeId, RoomStatus.ORDERED.getCode());
        System.out.println(room);
        if(room==null)
            return -1;
        room.setRoomStatus(RoomStatus.IN_USE.getCode());
        if (roomMapper.updateByPrimaryKeySelective(room) <= 0)
            return -1;
        else return room.getRoomId();
    }


    /**
     * 预定
     *
     * @param typeId
     * @return
     */

    @Override
    public int booKingRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId, RoomStatus.AVAILABLE.getCode());
        System.out.println(room);
        room.setRoomStatus(RoomStatus.ORDERED.getCode());
        if (roomMapper.updateByPrimaryKeySelective(room) <= 0)
            return -1;
        else return room.getRoomId();
    }

    /**
     * 退房
     *
     * @param typeId
     * @return
     */
    @Override
    public int outRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId, RoomStatus.IN_USE.getCode());
        if (room == null) return -1;
        room.setRoomStatus(RoomStatus.AVAILABLE.getCode());
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public PageInfo<Room> selectAllByPage(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Room> rooms = roomMapper.selectAll(search);
        PageInfo<Room> roomPageInfo = new PageInfo<>(rooms);
        return roomPageInfo;
    }

    @Override
    public int deleteBatchIds(List<Integer> ids) {
        return roomMapper.deleteBatch(ids);
    }

    @Override
    public List<Map<String, Integer>> selectGroupByType() {

        return roomMapper.selectGroupByType();
    }

    @Override
    public Page<RoomInfo> selectPage(Page<Object> objectPage, LambdaQueryWrapper<RoomInfo> wrapper) {
        return null;
    }
}
