package com.air.airtest.controller;

import com.air.airtest.config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.UUID;

@RestController
@RequestMapping("/pay")
public class PayController {
  @RequestMapping("/ailpay")
  public void show(HttpServletRequest request, HttpServletResponse response)
          throws IOException {
    AlipayClient alipayClient = new
            DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
            AlipayConfig.appId,
            AlipayConfig.privateKey,
            "json","utf-8",
            AlipayConfig.publicKey,
            "RSA2" );
    //上面这个方法是不是很眼熟？就是刚才配置完公钥后生成的那段，你可以直接复制然后加上你的私钥就好
    UUID uuid = UUID.randomUUID();
    String out_trade_no = "1111111"+uuid;//订单号
    out_trade_no = URLDecoder.decode(out_trade_no,"UTF-8");
    String total_amount = "20";//总金额
    total_amount = URLDecoder.decode(total_amount,"UTF-8");
    String subject = "小花";//商品名称
    subject = URLDecoder.decode(subject,"UTF-8");
    String body = "真棒";//商品描述
    body = URLDecoder.decode(body,"UTF-8");

    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
    alipayRequest.setReturnUrl("http://localhost:8080/photel");
    alipayRequest.setBizContent("{" +
            "    \"out_trade_no\":\""+ out_trade_no +"\"," +
            "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
            "    \"total_amount\":"+ total_amount +"," +
            "    \"subject\":\""+ subject +"\"," +
            "    \"body\":\""+ body +"\"" +
            "    }"+
            "  }");//填充业务参数
    String form="";
    try {
      form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
    } catch (AlipayApiException e) {
      e.printStackTrace();
    }
    response.setContentType("text/html;charset=utf-8");
    response.getWriter().println(form);//直接将完整的表单html输出到页面
    response.getWriter().close();
    return ;
  }
  @RequestMapping("/success")
  public ModelAndView success(String out_trade_no, Double total_amount){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("success");
    modelAndView.addObject("money",total_amount);
    modelAndView.addObject("no",out_trade_no);
    return modelAndView;
  }
  @RequestMapping("/hello")
  public void show1(){
    System.out.println("ddd");
  }
}
