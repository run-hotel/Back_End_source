package com.air.airtest.common;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件读取
 * @author zhaodaodao
 */
@Configuration
@Data
@Component
public class AlipayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private String appId = "2021000121603311";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCQcPBDz4FE1b9kRXwpO+cDfcXXgGAsK2+U4RMeYPEjcX5CUDnz08BoKxd/uF952BpwzXCRCDsGRdMW/kjz88JBw5CcAuxTzgbGRmeTXr3p5c/GrGkjHrbJ5xSYDlj7ZRuALb3/5hVdJPyukcfxVb0fvjK7wHdaNnHeYvLVUgMeLgN5wORYwzyIWTjNzR0riES6eZ24JDwxrK6ARlTuMuVKXbQjyRS5kW6WePZrxYFcfdkFpHaColhfW36dRISgDYNZO7rC4NqBn+2u3XXG/mTkHwOdN6O1BZYTPF2m9kmTtHCmK/xrrnJQDQ1KSHb0ez0HEReWrUvUsLWtLjLbfpFAgMBAAECggEAGe1DHkJVicHiC2fQ4NRysoZeozzFwJJULiHhd3+EabhuYuWsRwQxTEtQlh8No4s9IACQ7UPAjSJwLJ3d67yxqkfJzG498UVcfKll9O3sap9wnViHuymQwC1SPOBg6IhuFhx8Ty9K+qTbljrsgT4KdAl6VUN/ITj8UBZV5SaVviwmwzYG6rjfHtnYTzy5wOBqnj0B+6t8JsTPKAFwXstOyhV11H9DWVz/yQavgmI5uHYHd5qJ0s9kq4gXFtUjk9i2EZRAGEsKaMfkJOppn23PMttHel9ABnmJSlCaizpzqZcBF6W339HyG8eq+lIaY9ki+FD59wYlXBlKnVuV0g0AYQKBgQD0zt1OA+uDVxhQ2sSstfb+KkthoB5SdIJdm8FwVTqmMu0dy4AqbtvgJjVHo8OQqca7oCdsatyIcv8ZFe0MY9WWrKMkYOjvxmGd+UPazXjBiF5NF/83VhYl792It5L2hpE/bUnSvJ/Y/u9OndHT7JjUsfCRo3Bt7LIYpOjJsr4uGQKBgQDLI0UAMPWnhlg2Re/LRqgMnf+1bo3NcrobFjZInEgSjbCv8cxH3pYzpex1x+IYBmvBSwCEt9CCnd6SvIuyptf9OrNIwMXd9C21QnhhTFMnonbOILq2TWNdMsqjm4EltADOwDoCtkcpNI/5hb/Ed8wq6u1DVtjw4rqxFSNhC1EbDQKBgQCwyEmrssz51YUrri9kgSrRs/0njJcY+CXEL1vrIMDvj8sHPxNYkSGapjzHdQ0ehFuM1kRh2HFU36YzmU/LKLTuz9AnzwunStznVT+Y29Qd/boLdg7JCROJZcPWnKo1+EsfQG6VDb1o2AA8B1+k6DAdODn/EcV4u/qILV4leTw40QKBgF4z5PPJwKIHszC4DhP+mEABpWvF8Qytf5DAJDxX/TRdcOqm/0z09ELPV3DnWPo7QA1LctoZRCDOhUEXHtGifdd5OVsrypa7fdbpFFpKwuVGekHs+6k/Ci1WOJLWsnWBnD5E9qH7VdTOA1Z7qAq8Y3ojqBPqWoCbJGiqnNWMIfihAoGAPbHvFx9wRjfhCSIJuLm5rXAfeGQ5MsbuOyP5XWVImNZ9QGqEbaJNOjyXmItLpXkohwD0CNofNMDouFlsyoqsT2bAvfyZJtVtOb3pN/CFJC3NPoG/OoFlwms9lvch+BkAPJlzK0Ofccy/wh4VKCocl8voTB4RVcM50Tssxozt6pY=";

    /**
     * 支付宝公钥,
     */
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwkHDwQ8+BRNW/ZEV8KTvnA33F14BgLCtvlOETHmDxI3F+QlA589PAaCsXf7hfedgacM1wkQg7BkXTFv5I8/PCQcOQnALsU84GxkZnk1696eXPxqxpIx62yecUmA5Y+2UbgC29/+YVXST8rpHH8VW9H74yu8B3WjZx3mLy1VIDHi4DecDkWMM8iFk4zc0dK4hEunmduCQ8MayugEZU7jLlSl20I8kUuZFulnj2a8WBXH3ZBaR2gqJYX1t+nUSEoA2DWTu6wuDagZ/trt11xv5k5B8DnTejtQWWEzxdpvZJk7Rwpiv8a65yUA0NSkh29Hs9BxEXlq1L1LC1rS4y236RQIDAQAB";

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    private String notifyUrl = "https://localhost:8090/"; // 要remake的

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径.
     * 支付完成后返回的地址
     */
    private String returnUrl = "http://localhost:8090/order"; // 要remake的

    /**
     * 签名方式
     */
    private String signType = "RSA2";

    /**
     * 字符编码格式
     */
    private String charset = "utf-8";

    /**
     * 支付宝网关
     */
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝网关
     */
    private String logPath = "D:\\";
}