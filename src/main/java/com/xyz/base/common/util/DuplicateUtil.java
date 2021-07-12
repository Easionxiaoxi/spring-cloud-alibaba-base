package com.xyz.base.common.util;

import com.alibaba.fastjson.JSON;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 防重工具类
 */
public class DuplicateUtil {

    /**
     * 获取参数摘要标识
     *
     * @param jsonParam json格式入参
     * @param excludeKeys 排除的字段
     * @return 参数摘要标识
     */
    public static String getDigestTag(String jsonParam, String... excludeKeys) {
        // json参数转treeMap
        TreeMap paramMap = JSON.parseObject(jsonParam, TreeMap.class);
        // 参数过滤
        if (null != excludeKeys) {
            List<String> excludeKeyList = Arrays.asList(excludeKeys);
            if (!excludeKeyList.isEmpty()) {
                for (String excludeKey : excludeKeyList) {
                    paramMap.remove(excludeKey);
                }
            }
        }
        // 转为string
        String param = JSON.toJSONString(paramMap);
        return MD5(param);
    }

    /**
     * MD5计算摘要
     *
     * @param digestSrc 明文
     * @return 密文
     */
    private static String MD5(String digestSrc) {
        String md5Msg = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] mdBytes = messageDigest.digest(digestSrc.getBytes());
            md5Msg = DatatypeConverter.printHexBinary(mdBytes);
        } catch (Exception ignored) {
        }
        return md5Msg;
    }
}
