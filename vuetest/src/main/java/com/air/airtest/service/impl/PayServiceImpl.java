package com.air.airtest.service.impl;

import com.alipay.api.AlipayApiException;
import com.air.airtest.entity.AlipayBean;
import com.air.airtest.service.PayService;
import com.air.airtest.utils.Alipay;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private Alipay alipay;


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}