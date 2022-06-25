package com.air.airtest.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 信息加密类
 * 支持MD5加密
 * @author zhaodaodao
 * @date 2022-06-25
 */
public class CryptUtil {
    /**
     * 用来加盐的字符
     */
    private static final char[] CHARSET = {'H', 'E', 'X', 'R', 'T', 'C', 'Y', 'Q', 'h', 'e', 'x', 'r', 't', 'c', 'y', 'q'};

    /**
     * 获取MD5加密后的信息
     * @param rawString 初始字符串
     * @return 加密加盐后的值
     */
    public static String md5(String rawString){
        try {
            //一个原始的字符串
            rawString = addSalt(rawString);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //获取到加密的字符
            return new BigInteger(1, md5.digest(rawString.getBytes(StandardCharsets.UTF_8))).toString(16);
        }catch (Exception e){
            return null;
        }
    }


    /**
     * 加盐后的数据
     * @param rawString 初始字符串
     * @return 对数据加盐
     */
    public static String addSalt(String rawString){
        StringBuilder sbd = new StringBuilder();
        int len = rawString.length();
        //根据数组大小选择相关的东西进行加盐
        int index = 0;
        for (int i = 0; i < len; ++i){
            char ch = rawString.charAt(i);
            // 先加上基本的信息
            sbd.append(ch);
            // 通过ascii码进行计算得到原字符串中的某个值
            ch = rawString.charAt(ch%len);
            sbd.append(ch);
            // 通过再得到的值，从默认加盐字符串中寻找值
            sbd.append(CHARSET[ch%CHARSET.length]);
        }
        return sbd.toString();
    }

}