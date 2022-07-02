package com.air.airtest.mapper;

import com.air.airtest.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface RoomTypeMapper {
    int updateRoomNumForReduce(Integer roomtypeno);
    int updateRoomNumForAdd(String roomtypeno);
    int updateRoomPrice(@Param("roomprice") float roomPrice,@Param("roomtypeno")String roomtypeno);
    List<RoomType> selectRoomType();
    String selectRoomTypeNoforRoomType(String roomtypename);

    Integer getCount();
    int deleteByPrimaryKey(Integer typeId);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);

    List<RoomType> selectAll(String search);

    RoomType selectByRoomType(String roomType);

    List<RoomType> selectAllWithRest();

    int deleteBatch(List<Integer> ids);

    List<Map<String, Integer>> selectTypePercent();

    Integer selectSumType();
}
