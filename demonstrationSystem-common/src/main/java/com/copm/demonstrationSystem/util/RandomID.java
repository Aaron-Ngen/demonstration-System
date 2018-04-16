package com.copm.demonstrationSystem.util;

import com.sun.deploy.util.StringUtils;

import java.util.UUID;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 23:42 2018/4/15
 */
public class RandomID {

    public static String randomString(){
        return UUID.randomUUID().toString();
    }
}
