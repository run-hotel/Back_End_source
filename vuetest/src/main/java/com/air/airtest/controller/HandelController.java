package com.air.airtest.controller;

import com.air.airtest.config.Result;
import com.air.airtest.entity.Handel;
import com.air.airtest.service.HandelService;
import com.air.airtest.service.OrderService;
import com.air.airtest.service.RoomService;
import com.air.airtest.service.RoomTypeService;
import com.air.airtest.vo.Hotelvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/handel")
public class HandelController {
    @Autowired
    HandelService handelService;
    @Autowired
    OrderService orderService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomTypeService roomTypeService;

    //handel  内有  处理人 房间号 订单号 处理时间
    @PostMapping
    public Result<?> save(@RequestBody Handel handel){
        //插入处理订单表中
        handelService.insertHandel(handel);
        //根据订单号handel.getOrderno() ，改变房间订单状态
        System.out.println(handel.getOrderno()); //  订单号
        orderService.updateOrderStatus(handel.getOrderno());
        //根据房间号 改变房间的居住状态
        System.out.println(handel.getRoomno()); //  订单号
        roomService.updateRoomStatus(handel.getRoomno());
        // //根据房间号 来查找房间类型
        // String tyno = roomService.selectRoomTypeNo(handel.getRoomno());
        // System.out.print("%%%"+tyno+"$$$$");
        // //根据房间类型，将相应房间数量减一
        // int a = roomTypeService.updateRoomNumForReduce(tyno);
        // System.out.print("%%%"+a+"$$$$");
        
        return Result.success();
    }

    @GetMapping("/selectroomno")
    public Result<?> selectroomno(@RequestParam(defaultValue = "") String orderno){
        System.out.println("%%%"+orderno+"$$$$");
        //更改订单状态  --> 变为已完成
        orderService.updateOrderStatusForCancel(orderno);
        //根据订单号查出房间号
        String roomno = handelService.selectHandelRoomNo(orderno);
        System.out.print("%%%"+roomno+"$$$$");
        //更改房间状态
        roomService.updateStatusForLive(roomno);
        //更新房间数量
        String tyno = roomService.selectRoomTypeNo(roomno);
        System.out.print("%%%"+tyno+"$$$$");
        //根据房间类型，将相应房间数量加一
        int a = roomTypeService.updateRoomNumForAdd(tyno);
        System.out.print("%%%"+a+"$$$$");
        return Result.success();
    }

    @GetMapping("/selectMyHandel")
    public Result<?> selectMyHandel(@RequestParam(defaultValue = "") String hotelstaffno){
        System.out.println(hotelstaffno);
        List<Hotelvo> myhandel = handelService.selectHandelOrder(hotelstaffno);
        return Result.success(myhandel);
    }

}
