package com.air.airtest.service.impl;

import java.util.List;

import com.air.airtest.entity.RoomType;
import com.air.airtest.mapper.RoomTypeMapper;
import com.air.airtest.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoomTypeSeriveImpl implements RoomTypeService{
    @Autowired
    RoomTypeMapper typeMapper;

    @Override
    public int updateRoomNumForReduce(String roomtypeno) {
        
        return typeMapper.updateRoomNumForReduce(roomtypeno);
    }

    @Override
    public int updateRoomNumForAdd(String roomtypeno) {
        
        return typeMapper.updateRoomNumForAdd(roomtypeno);
    }

    @Override
    public int updateRoomPrice(float roomPrice, String roomtypeno) {
        
        return typeMapper.updateRoomPrice(roomPrice, roomtypeno);
    }

    @Override
    public List<RoomType> selectRoomType() {
        
        return typeMapper.selectRoomType();
    }

    @Override
    public String selectRoomTypeNoforRoomType(String roomtypename) {
        // TODO Auto-generated method stub
        return typeMapper.selectRoomTypeNoforRoomType(roomtypename);
    }
    
}
