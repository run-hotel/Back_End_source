package com.air.airtest.mapper;

import com.air.airtest.entity.HotelStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelStaffMapper extends BaseMapper<HotelStaff> {
    //HotelStaff selectHotelStaff(String hotelstaffno);
}
