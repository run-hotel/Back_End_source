package com.air.airtest.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.mapper.RoomOrderMapper;
import com.air.airtest.service.OrderService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    RoomOrderMapper roomOrderMapper;
    //BaseMapper的
    @Override
    public int insert(RoomOrderInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int deleteById(Serializable id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(RoomOrderInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateById(RoomOrderInfo entity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(RoomOrderInfo entity, Wrapper<RoomOrderInfo> updateWrapper) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RoomOrderInfo selectById(Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomOrderInfo> selectBatchIds(Collection<? extends Serializable> idList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomOrderInfo> selectByMap(Map<String, Object> columnMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long selectCount(Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoomOrderInfo> selectList(Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <P extends IPage<RoomOrderInfo>> P selectPage(P page, Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return roomOrderMapper.selectPage(page, queryWrapper);
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<RoomOrderInfo> queryWrapper) {
        // TODO Auto-generated method stub
        return null;
    }

    //自己的

    @Override
    public List<RoomOrderInfo> selectRoomOrderInfo() {
        // TODO Auto-generated method stub
        return roomOrderMapper.selectRoomOrderInfo();
    }

    @Override
    public int updateOrderStatus(String id) {
        // TODO Auto-generated method stub
        return roomOrderMapper.updateOrderStatus(id);
    }

    @Override
    public int updateOrderStatusForCancel(String id) {
        // TODO Auto-generated method stub
        return roomOrderMapper.updateOrderStatusForCancel(id);
    }

    @Override
    public RoomOrderInfo selectRoomOrderone(String id) {
        // TODO Auto-generated method stub
        return roomOrderMapper.selectRoomOrderone(id);
    }

    @Override
    public List<Hotelvo> selectRoomForPeople(String Roomno) {
        // TODO Auto-generated method stub
        return roomOrderMapper.selectRoomForPeople(Roomno);
    }
    @Override
    public List<RoomOrderInfo> selectOrder(String customerphone) {
        // TODO Auto-generated method stub
        return roomOrderMapper.selectOrder(customerphone);
    }
    @Override
    public int addOrder(RoomOrderInfo roomOrderInfo) {
        // TODO Auto-generated method stub
        return roomOrderMapper.addOrder(roomOrderInfo);
    }
    @Override
    public List<Hotelvo> salesVolumes() {
        // TODO Auto-generated method stub
        return roomOrderMapper.salesVolumes();
    }
    
}
