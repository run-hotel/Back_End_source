package com.air.airtest.utils;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

@Slf4j
public class MD5Utils {

    private static final String hexDigIts[] =
            {"0", "1", "2", "3", "4", "5", "6",
                    "7", "8", "9", "a", "b", "c",
                    "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param origin      字符
     * @param charsetname 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");//获取md5加密对象
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf8")));
        } catch (Exception e) {
            log.error("{}",e.getMessage());
            e.printStackTrace();
        }
        return resultString;
    }


    public static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }


    public static void main(String[] args) {
//        String pass1 = MD5Utils.MD5Encode("123123");//4297f44b13955235245b2497399d7a93
//        String pass2 = MD5Utils.MD5Encode("123456");//e10adc3949ba59abbe56e057f20f883e
//
//        System.out.println(pass1);
//        System.out.println(pass2);

        String orderNo = IdUtil.getSnowflake().nextIdStr();
        System.out.println(orderNo);
    }
}