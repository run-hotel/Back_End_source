package com.air.airtest.controller;


import java.util.List;

import com.air.airtest.common.Result;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.service.RoomService;
import com.air.airtest.service.RoomTypeService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.StrUtil;


@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomTypeService roomTypeService;
    //分页查询  所有房间信息和模糊查询
    @GetMapping("/allroom")
    public Result<?> selectallroom(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<RoomInfo> wrapper = Wrappers.<RoomInfo>lambdaQuery();
        System.out.println("---->....."+search);
        if(StrUtil.isNotBlank(search)){
            wrapper.like(RoomInfo::getRoomno,search);
        }
        Page<RoomInfo> roomPage = roomService.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(roomPage);
    }
    //每一次注入都需要加@Autowired
    
    //修改房间的状态  将房间可用数量减一
    //search --> 订单号  ， status --> 所选状态   
    @GetMapping("/updateRoomStatus")
    public Result<?> updateRoomStatus(@RequestParam(defaultValue = "") String search,@RequestParam(defaultValue = "") String status) {
         //System.out.println("%%%"+search+"$$$$");
         //System.out.print("%%%"+status+"$$$$");
         //更改房间状态
        if(status.equals("维修")){
            roomService.updateStatusForRepair(search);
            //根据房间号 来查找房间类型
            String tyno = roomService.selectRoomTypeNo(search);
            //System.out.print("%%%"+tyno+"$$$$");
            //根据房间类型，将相应房间数量减一
            roomTypeService.updateRoomNumForReduce(tyno);
            //int a =    System.out.print("%%%"+a+"$$$$");
        }else{
            roomService.updateStatusForLive(search);
            //根据房间号 来查找房间类型
            String tyno = roomService.selectRoomTypeNo(search);
            //System.out.print("%%%"+tyno+"$$$$");
            //根据房间类型，将相应房间数量加一
            roomTypeService.updateRoomNumForAdd(tyno);
        } 
        return Result.success();
    }
    //查询剩余房间
    @GetMapping("/selectRemainingRooms")
    public Result<?> selectRemainingRooms(@RequestParam(defaultValue = "豪华房") String roomtypename){
        System.out.println(roomtypename);
        //根据房间名,找到房间类型编号
        String roomtypeno = roomTypeService.selectRoomTypeNoforRoomType(roomtypename);
        System.out.println("________"+roomtypeno);
        //根据房间类型编号找到剩余房间
        List<Hotelvo> roomlist =  roomService.selectRemainingRooms(roomtypeno);
        for(Hotelvo room : roomlist){
            System.out.println(room);
        }
        return Result.success(roomlist);
    }
}
