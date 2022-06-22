package com.air.airtest.service;

import com.alipay.api.AlipayApiException;
import com.air.airtest.model.AlipayBean;

/**
 * 支付服务
 * @author zhaodaodao
 * @version 1.0
 * @date 2022-06-22
 */

public interface PayService {

    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}