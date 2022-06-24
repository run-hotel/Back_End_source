package com.air.airtest.service.impl;

import java.util.List;

import com.air.airtest.entity.Handel;
import com.air.airtest.mapper.HandelOrderMapper;
import com.air.airtest.service.HandelService;
import com.air.airtest.vo.Hotelvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandelOrderServiceImpl implements HandelService{

    @Autowired 
    HandelOrderMapper hMapper;
    @Override
    public int insertHandel(Handel handel) {
        
        return hMapper.insertHandel(handel);
    }

    @Override
    public String selectHandelRoomNo(String orderno) {
        
        return hMapper.selectHandelRoomNo(orderno);
    }

    @Override
    public List<Hotelvo> selectHandelOrder(String hotelstaffno) {
        
        return hMapper.selectHandelOrder(hotelstaffno);
    }
    
}
