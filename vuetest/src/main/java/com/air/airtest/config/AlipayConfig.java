package com.air.airtest.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 配置文件读取
 * @author zhaodaodao
 */
@ConfigurationProperties(prefix = "alipay")
@Data
@Component
public class AlipayConfig {
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public  static String appId = "2021000121610278";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public  static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC8mYGLUbc6d4C2gpyS906NRE4mn9l9mSOvEuVpDjlQqcXEkTDGp4U45bum3NdzCrtVAGLtYEii5USYra1wORRd6Ev7Jz3x06HK3O464azCZP5sr/iF+8GP65UMFpNspz7I/SsAIEREpwzA66WNTST3Z6yaKuXFtBDzk5KJ/Ax0pJU1qRqh38l5QZ7tA8jYoNiTf1ZTLQpV9R62inz6wrk4p0MYtEgamnh98mlUrDHjZ2kfPKE5y5/VVK/pFnhtinvAhB8sZEzI1OP8VdaYfXPq5NGy5bII1NTyGYTTi5msKVYbvGEUP4xTOqluF0SZnYoQAGPengSKT6GjcI6ax7uXAgMBAAECggEBAI/0/BTDwwA1x2GIQMtNSgA6awzAZtqf0cUIv2N5H/aaIALycDCyHdZYROwRFcMSJfuz188o90ifh8SijQhkCU/EyHpkcbvstkqKaK05JQ0c2bdMen6KtCyOva4EbXM6FYqE9BWci397oxh+xlcc02KlF/J1W/2UfHvv4KLCaR9+UZSyWWX85t79OYa7pfLG9X8zBCfmNrrxzhVQID3WO8U7HWwzdL+87kR0LbguIfRgvvtLqJKYd+5qEVh4I8QcUVTvjisKeQD9FdLkl/GJikP0k4L7l3/MNWYEYGSKywsXWGlrXf5QWSpe+QDgE7QY5BdKKfuwcikeRj0JBhhYyAECgYEA2++C6D6YLHqyrAqo7h54zKcpQhbh5dKQtuQ9bULjH7I5sQ4kzf6c0ft4V5uk9Z4HWoFJHxmLokUJtRJR/RSiG990seMmPG/gckV70VJ9tyA/gx+42xd340Z3pXmI3QOmIEuxnvRoJWqmARD3zSfJF9q993HCddcwFfOX50Rgi4ECgYEA24aRt0dJBXRIKQcsu0sE6xk0ST0EsPlBuUwbk7hp2NeT1gvyq6v4LLR+UN8VRF1FQ9GautZY6QRuMJSkKIDS+c71yEiAkjvGMAvKXes6BF492nhnngS1eK4pWir+r5vufzb813IZXAuf+xrgOzM1ZFQON9Pu2fCngwgTl3yQsxcCgYEA0yBYyhlMe2ZNnlmdUPhvfgX51TeiIry/rtHrJbfPz92HBDBPpG+GmwyLuY3wDNhmtrrlNrWPFXawmuG7Uvc7pwYbP6iOS/YZv5h0A7zscZ7DWVxaV/dvXv2GXZMNjxyxnM8M80orr79xHBTtzEMlB4E0WxUZV4X64xez+o3pIAECgYB/bjdJ9+RoeR6mSlbqBds+CaxzUytU++vt/0MG1gcDa+iSWO8uPi5a7Q9iLI0w2R+rBZJXILQN15eLNc2xAU722e+MqqGPwYkDPOTk7fYIsRggqMIlVUBuZFL213xuPgsM58OP4NjduJXOcsR1OP2mVrDGMY02D999TYPp7NImUwKBgFY0cW5U04bqFHanCE6Rcwq4X1sV9Hq2kHYr0UsQDug470yH6F34Pdm/FqtOfuVZQK2ZwSBtpUYIffzamFv6X3fJ7XZ5FbNusCoqOQbjgZ6B8sk1Q6bAnWnd1GH2cwyq5Fx16F/mfaPEZA/hB5Iaw4fYogwQ+kNNMBz8iGfSeTb7";

    /**
     * 支付宝公钥,
     */
    public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoi3dvcBo/QwU1OGqG2W8UK8XSnWBSkSyMV449wxMADW+b1ryMYyzEYtc26o4xn4ccxHJS7jBaSfKsTXn1/zDI/3IuDE0z2vudbvTp8QmGkVTTe9aP3/y94gc7Mx9HxJ5wkon0aToHKFM0P+GwPq8ZKg8G3o+2hdv2cQnlzAmw9F050r50yy/eEDrOXYB9aEp0Ymd4K0wMlN0Hez4e4hK/0xrRRRhQKZECvOZ+NLz9pYqUDBDkGclI99OnprfMhOakClUjcXNI8ABEUqg3ylkFAs0R0Klryko1PGfhRmzACzdwFYfG2ujOkz0NEAUePr03vIPEy7P1ANVenRix99pOQIDAQAB";

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    public static String notifyUrl = "http://localhost:8090/notifyUrl"; // 要remake的

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径.
     * 支付完成后返回的地址
     */
    public static String returnUrl = "http://localhost:8090/returnUrl"; // 要remake的
    public static final String FORMAT = "JSON";
    /**
     * 签名方式
     */
    public static String signType = "RSA2";

    public static final String CHARSET = "UTF-8";
    /**
     * 字符编码格式
     */
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝网关
     */
    public static String logPath = "D:\\";

    @PostConstruct
    public void init() {
        // 设置参数(全局只需设置一次)
        Config options = getOptions();
        options.appId = this.appId;
        options.merchantPrivateKey = this.privateKey;
        options.alipayPublicKey = this.publicKey;
        options.notifyUrl = this.notifyUrl;
        Factory.setOptions(options);
        System.out.println("=======支付宝SDK初始化成功=======");
    }

    private Config getOptions() {
        Config config = new Config();
        config.protocol = "http";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";
        return config;
    }
}