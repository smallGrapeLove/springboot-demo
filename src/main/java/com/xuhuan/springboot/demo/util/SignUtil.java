package com.xuhuan.springboot.demo.util;

import org.apache.commons.collections4.MapUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author huan.xu
 * @ClassName SignUtil
 * @date 2021/1/8 9:48
 * @Description 鉴权工具类
 */
public class SignUtil {

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String md5(String str) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code.insert(0, "0");
        }
        return md5code.toString();
    }

    /**
     * 排序
     *
     * @param params 参数
     * @return 按照字典序升序TreeMap
     */
    public static TreeMap<String, Object> paramSort(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        TreeMap<String, Object> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        treeMap.putAll(params);
        return treeMap;
    }

    /**
     * 鉴权
     *
     * @param params    参数
     * @param clientKey 系统配置中的clientKey
     * @return
     */
    public static boolean check(Map<String, Object> params, String clientKey) {
        String signStr = MapUtils.getString(params, "sign", "");
        TreeMap<String, Object> sortMap = paramSort(params);
        String sign = sign(sortMap, clientKey);
        System.out.println("参数 sign => " + signStr);
        System.out.println("加密 sign => " + sign);
        return signStr.equals(sign);
    }

    /**
     * 加密 添加（替换）clientId、去sign
     *
     * @param params    参数
     * @param clientKey 密钥
     * @return md5(key1 = value1$key2 = value2...keyN = valueNClientKey)
     */
    public static String sign(TreeMap<String, Object> params, String clientKey) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        params.remove("sign");
        StringBuilder sb = new StringBuilder();
        params.forEach((key, val) -> {
            if ("investVerifyNodeList".equalsIgnoreCase(key) || "attachment".equalsIgnoreCase(key)) {
                try {
                    val = URLEncoder.encode(val.toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            sb.append(key).append("=").append(val).append("&");
        });
        String substring = sb.substring(0, sb.length() - 1);
        String md5BeforeStr = substring + clientKey;
        System.out.println("MD5前 str => " + md5BeforeStr);
        String encodeStr = "";
        try {
            encodeStr = URLEncoder.encode(md5BeforeStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("MD5前 encode str => " + encodeStr);
        String md5Str = md5(encodeStr);
        System.out.println("MD5后 str => " + md5Str);
        return md5Str;
    }
}
