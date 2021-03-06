package com.air.airtest.controller;

import cn.hutool.core.util.StrUtil;
import com.air.airtest.config.Result;
import com.air.airtest.entity.Room;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.service.OrderService;
import com.air.airtest.service.RoomService;
import com.air.airtest.service.RoomTypeService;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private RoomService roomService;

    @PostMapping("/xiadan")//
    public Result<?> xiadan(@RequestBody RoomOrderInfo roomOrderInfo){
        //System.out.println(roomOrderInfo);
        // System.out.println(roomOrderInfo);
        roomOrderInfo.setOrderstatus(0);
        orderService.addOrder(roomOrderInfo);
        Room tmp = new Room();
        System.out.println("我在这" + roomOrderInfo.getOrderno() + " " + roomOrderInfo.getRoomtypename() + roomOrderInfo.getCustomerphone());
        tmp.setRoomId(Integer.parseInt(roomOrderInfo.getOrderno()));
        tmp.setRoomType("单人房");
        tmp.setTypeId(1);
        tmp.setRoomStatus(2);
        tmp.setRoomPrice(200.0);
        tmp.setRoomDiscount(25.0);
        tmp.setCreateTime(roomOrderInfo.getInttime());
        tmp.setUpdateTime(roomOrderInfo.getOuttime());
        tmp.setRoomNumber(roomOrderInfo.getOrderno());
        roomService.insert(tmp);
        //根据房间名,找到房间编号
        String a = roomTypeService.selectRoomTypeNoforRoomType(roomOrderInfo.getRoomtypename());
        System.out.println("________"+a);
        //根据房间类型，将相应房间数量减一
        int b = roomTypeService.updateRoomNumForReduce(Integer.valueOf(a));
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
