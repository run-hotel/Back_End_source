package com.air.airtest.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;


import com.air.airtest.entity.RoomInfo;
import com.air.airtest.mapper.RoomMapper;
import com.air.airtest.service.RoomService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insert(RoomInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(RoomInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateById(RoomInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(RoomInfo entity, Wrapper<RoomInfo> updateWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RoomInfo selectById(Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomInfo> selectBatchIds(Collection<? extends Serializable> idList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomInfo> selectByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long selectCount(Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomInfo> selectList(Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <P extends IPage<RoomInfo>> P selectPage(P page, Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return roomMapper.selectPage(page, queryWrapper);
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<RoomInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Hotelvo> selectRemainingRooms(String roomtypename) {
        // TODO Auto-generated method stub
        return roomMapper.selectRemainingRooms(roomtypename);
    }
}
