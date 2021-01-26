package com.terri.hd.eventspro.utils;

import java.util.UUID;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/10 下午8:47
 */
public class UUIDUtil {

    String uuid = null;

    public String getUuid() {

        String string = UUID.randomUUID().toString();

        //String uuid = string.substring(0, 7);
        String[] split = string.split("-");

        uuid = split[4];

        return uuid;
    }
}
