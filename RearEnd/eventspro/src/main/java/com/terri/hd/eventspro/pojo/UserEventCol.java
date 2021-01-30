package com.terri.hd.eventspro.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Author: Gaoquan Li
* @Date: 2021/1/25 下午11:22
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventCol {
    private String uuid;

    private String userOpenid;

    private String eventId;

    private String eventName;

    private String eventCate;

    private String eventCity;

    private String eventLocation;

    private String eventAddress;

    private String eventImg;

}