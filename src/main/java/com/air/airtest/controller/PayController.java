package com.air.airtest.controller;

import com.alipay.api.AlipayApiException;
import com.air.airtest.model.AlipayBean;
import com.air.airtest.service.PayService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
@CrossOrigin
public class PayController {

    @Resource
    private PayService payService;

    /**
     * 阿里支付
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("/alipay")
    public Map alipay(AlipayBean alipayBean) throws AlipayApiException {
        System.out.println(alipayBean);
        Map<String,Object> map = new HashMap<String,Object>();


        String str = payService.aliPay(alipayBean);
        System.out.println(str);
        map.put("msg",str);
        map.put("code",0);

        return map;
    }
}