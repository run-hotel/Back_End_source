package com.air.airtest.controller;
import java.util.List;

import com.air.airtest.common.Result;
import com.air.airtest.entity.RoomOrderInfo;

import com.air.airtest.service.OrderService;
import com.air.airtest.service.RoomTypeService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("/roomorder")
public class OrderController {
    //分页查询  -->所有订单和模糊查询
 
    @Autowired
    OrderService orderService;
    @GetMapping("/allorder")
    public Result<?> selectallorder(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<RoomOrderInfo> wrapper = Wrappers.<RoomOrderInfo>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(RoomOrderInfo::getOrderno,search);
        }
        Page<RoomOrderInfo> roomOrderPage = orderService.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(roomOrderPage);
    }

    @GetMapping("/roomforpeople")
    public Result<?> selectroomforpeople(@RequestParam(defaultValue = "") String Roomno){
        List<Hotelvo> roomforpeople = orderService.selectRoomForPeople(Roomno);
        return Result.success(roomforpeople);
    }
    @Autowired
    RoomTypeService roomTypeService;

    @PostMapping("/xiadan")//
    public Result<?> xiadan(@RequestBody RoomOrderInfo roomOrderInfo){
        //System.out.println(roomOrderInfo);
        // System.out.println(roomOrderInfo);
        orderService.addOrder(roomOrderInfo);
        //根据房间名,找到房间编号
        String a = roomTypeService.selectRoomTypeNoforRoomType(roomOrderInfo.getRoomtypename());
        System.out.println("________"+a);
        //根据房间类型，将相应房间数量减一
        int b = roomTypeService.updateRoomNumForReduce(a);
        System.out.print("%%%"+b+"$$$$");

        return Result.success();
    }

    @GetMapping("/selectorder")
    public Result<?> selectOrder(@RequestParam(defaultValue = "") String customerphone){
        System.out.println("____>"+customerphone);
        List<RoomOrderInfo> roomOrderInfo = orderService.selectOrder(customerphone);
        System.out.println("____>"+roomOrderInfo);
        return Result.success(roomOrderInfo);
    }

    //统计销售详情
    @GetMapping("/salesVolumes")
    public Result<?> salesVolumes(){
        List<Hotelvo> salelist =  orderService.salesVolumes();
        // for(Hotelvo room : salelist){
        //     System.out.println(room);
        // }
        return Result.success(salelist);
    }

}
