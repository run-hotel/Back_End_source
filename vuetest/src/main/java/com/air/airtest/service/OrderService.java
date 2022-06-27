package com.air.airtest.service;

import com.air.airtest.entity.Order;
import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.vo.Hotelvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService extends BaseMapper<RoomOrderInfo>{
    List<RoomOrderInfo> selectRoomOrderInfo();
    int updateOrderStatus(String id);
    int updateOrderStatusForCancel(String id);
    RoomOrderInfo selectRoomOrderone(String id);
    List<Hotelvo> selectRoomForPeople(String Roomno);
    List<RoomOrderInfo> selectOrder(String customerphone);
    int addOrder(RoomOrderInfo roomOrderInfo);
    List<Hotelvo> salesVolumes();


    int insert(Order order);

    int addOrder(Order order);

    int delete(Integer orderId);

    Order selectById(Integer orderId);

    Order selectByNameAndPhone(String name,String phone);

    int update(Order record);

    int payOrder(int orderId);

    int cancelOrder(int orderId);

    Integer getOrderCount();

    List<Order> selectByUserId(int userId);

    List<Order> AllOrders();

    List<Order> UsersAllOrders(int userId);

    PageInfo<Order> UsersAllOrders(int userId, int pageNum, int pageSize);

    int update(String tradeNo);

    Order selectByTradeno(String tradeNo);

    PageInfo<Order> AllOrders(Integer pageNum, Integer pageSize, String search);

}
