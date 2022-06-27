package com.air.airtest.controller.user;

import cn.hutool.core.util.IdUtil;
import com.air.airtest.entity.Order;
import com.air.airtest.entity.User;
import com.air.airtest.enums.OrderStatus;
import com.air.airtest.response.AjaxResult;
import com.air.airtest.response.MsgType;
import com.air.airtest.response.ResponseTool;
import com.air.airtest.service.OrderService;
import com.air.airtest.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 订单接口
 */
@RestController
@RequestMapping(value = "/user/order")
public class UserOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    /**
     * 添加预订
     * 订单状态默认为未付款状态
     *
     * @param orderTypeId
     * @param orderType
     * @param userId
     * @param name
     * @param phone
     * @param roomTypeId
     * @param roomType
     * @param orderDate
     * @param orderDays
     * @param orderCost
     * @return
     */
    @RequestMapping(value = "/add")
    public AjaxResult addOrder(int orderTypeId, String orderType,
                               int userId, String name,
                               String phone, int roomTypeId,
                               String roomType,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate, Integer orderDays, Double orderCost) {

        String orderNo = IdUtil.getSnowflake().nextIdStr();
        Order order = new Order(orderTypeId, orderType, userId, name, phone, roomTypeId,
                roomType, orderDate, orderDays, OrderStatus.UNPAID.getCode(), orderCost);
        order.setPayOrderId(orderNo);
        int re = orderService.addOrder(order);
        if (re != 1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/delete")
    public AjaxResult deleteOrderByUser(int orderId) {
        Order order = new Order(orderId, OrderStatus.WAS_DELETED.getCode());
        int re = orderService.update(order);
        if (re != 1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 订单支付
     *
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/pay")
    public AjaxResult payOrder(Integer orderId, String username, String password) {
        User user = userService.selectByUsernameAndPassword(username, password);
        if (user == null)
            return ResponseTool.failed("密码错误");

        int re = orderService.payOrder(orderId);
        if (re != 1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }

    @PostMapping("/payByalipay")
    public AjaxResult payByalipay(Integer orderId) {
        Order order = orderService.selectById(orderId);
        if (order != null) {

            String payUrl = "http://localhost:8082/alipay/pay?subject=" + order.getPayOrderId() + "&traceNo=" + order.getPayOrderId() + "&totalAmount=" + order.getOrderCost();
            return ResponseTool.success(payUrl);
        }
        return ResponseTool.failed("订单不存在");
    }


    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/cancel")
    public AjaxResult cancelOrder(int orderId) {
        int re = orderService.cancelOrder(orderId);
        if (re != 1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 客户查询个人所有订单（不包括被自己删除的）
     *
     * @param userId
     * @return
     */
  /*  @RequestMapping(value = "")
    public AjaxResult getAllByUser(int userId) {

        return ResponseTool.success(orderService.UsersAllOrders(userId));
    }*/

    /**
     * 客户查询个人所有订单（分页查询）
     *
     * @param userId
     * @return
     */
    @PostMapping
    public AjaxResult getAllOrdersByUser(@RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "5") Integer pageSize,
                                         Integer userId) {

        PageInfo<Order> orderPageInfo = orderService.UsersAllOrders(userId, pageNum, pageSize);

        return ResponseTool.success(orderPageInfo);
    }

    /**
     * 根据订单号查询订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/{orderId}")
    public AjaxResult getById(@PathVariable int orderId) {
        return ResponseTool.success(orderService.selectById(orderId));
    }

}
