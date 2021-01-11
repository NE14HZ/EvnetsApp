package com.terri.hd.eventspro.utils;

import java.time.LocalDateTime;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/11 下午3:28
 */
public class DateUtil {

    public LocalDateTime getDate(String time) {

        String date = time.split(" ")[0];
        String times = time.split(" ")[1];

        String[] dateString = date.split("-");
        String[] timeString = times.split(":");

        LocalDateTime dateTime = LocalDateTime.of(Integer.parseInt(dateString[0]),
                Integer.parseInt(dateString[1]),
                Integer.parseInt(dateString[2]),
                Integer.parseInt(timeString[0]),
                Integer.parseInt(timeString[1]));

        return dateTime;
    }
}
