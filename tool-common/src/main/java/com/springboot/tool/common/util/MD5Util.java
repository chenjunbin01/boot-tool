package com.springboot.tool.common.util;

import org.springframework.util.DigestUtils;

/**
 * @Author chenjunbin
 * @Date 2019/7/26
 * @Description
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

}
