package com.air.airtest.utils;

import com.air.airtest.common.AlipayConfig;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.air.airtest.model.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付宝支付接口
 * @author zhaodaodao
 */
@Component
public class Alipay {

    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    public String pay(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        String serverUrl = alipayConfig.getGatewayUrl();
        String appId = alipayConfig.getAppId();
        String privateKey = alipayConfig.getPrivateKey();
        String format = "json";
        String charset = alipayConfig.getCharset();
        String alipayPublicKey = alipayConfig.getPublicKey();
        String signType = alipayConfig.getSignType();
        String returnUrl = alipayConfig.getReturnUrl();
        String notifyUrl = alipayConfig.getNotifyUrl();
        //System.out.println(appId);
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        return result;
    }
}