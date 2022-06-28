package com.air.airtest.controller.user;

import com.air.airtest.controller.user.dto.AliPay;
import com.air.airtest.entity.Order;
import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.service.OrderService;
import com.air.airtest.service.RoomService;
import com.air.airtest.service.RoomTypeService;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/alipay")
public class AliPayController {

    @Resource
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/pay")
    public String pay() {
        AlipayTradePagePayResponse response;
        RoomOrderInfo roomOrderInfo = new RoomOrderInfo();
        roomOrderInfo.setOrderno(String.valueOf(Math.random()));
        try {
            //  发起API调用（以创建当面付收款二维码为例）
            response = Factory.Payment.Page()
                    .pay("开房", roomOrderInfo.getOrderno(), "200", "http://localhost:8080/hotel");
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return response.getBody();
    }


    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");

            // 支付宝验签
            if (Factory.Payment.Common().verifyNotify(params)) {
                // 验签通过
                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
                // 更新订单为已支付
                Order order = orderService.selectByTradeno(tradeNo);
                if (order != null) {
                    log.info("orderId{}", order.getOrderId());
                    order.setOrderStatus(1);
                    orderService.update(order);
                }
                roomTypeService.updateRest(order.getRoomTypeId(), -1);//房间类型数量-1
                roomService.booKingRoom((order.getRoomTypeId()));
            }
        }
        return "success";
    }

}
