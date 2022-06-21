package com.air.airtest.controller;

import java.util.List;

import com.air.airtest.common.Result;
import com.air.airtest.entity.RoomType;
import com.air.airtest.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {

    @Autowired
    RoomTypeService roomTypeService;
    //分页查询  所有房间类型信息
    @GetMapping("/allroomtype")
    public Result<?> selectType(){
        List<RoomType> rtype = roomTypeService.selectRoomType();
        return Result.success(rtype);
    }
    //修改房间价格
    @GetMapping("/updateRoomPrice")
    public Result<?> updateRoomPrice(@RequestParam(defaultValue = "") float roomPrice,@RequestParam(defaultValue = "") String roomtypeno){
        System.out.println("%%%"+roomPrice+"$$$$");
        System.out.println("%%%"+roomtypeno+"$$$$");
        roomTypeService.updateRoomPrice(roomPrice, roomtypeno);
        return Result.success();
    }
}
