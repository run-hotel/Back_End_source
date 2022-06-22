package com.air.airtest.utils;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件读取
 * appId：APPID,沙箱应用提供的
 * privateKey: 商户私钥,点击公钥证书查看
 * returnUrl : 支付完成后跳转的页面，例如我填的是：http://localhost:8090/ (后面要改！！！！！
 * @author zhaodaodao
 * @version 1.0
 * @date 2022-06-22
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
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyqAN9WzWigim0/3fBK97RFZ7Juu31+DfXMVHTHSTP+4WPvr80zTiIQmT9xTFVGBgD8BBX0XELxqLQxsYQm/MgEgccHTnCKPP7Ci979YuwZyjOysdTc6BNO/6RqPZruih6wSYDJNuJUgY/hwuWi+owUDbHL7NvZ8r/TaIJvEzzhJVrTMsIBQBe66LRE7gE2avwEV8Qck9e4yexsDUD7ja1+2T1ltfHAP2u/SBOD+7PkkPgVkINPDHt4bXZ9DIhPhosiw8IidEEniXj/Ku1wtgETll/btJljhhXq98JHBlw94+yx+BQ+9s2S2CjXkxfdZDB9s+jFy80e6UIV76xxfB0QIDAQAB";

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    private String notifyUrl = "https://www.duan33f.top";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径.
     * 支付完成后返回的地址
     */
    private String returnUrl = "http://localhost:8088/";

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