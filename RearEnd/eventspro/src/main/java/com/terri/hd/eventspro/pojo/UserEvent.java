package com.terri.hd.eventspro.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Author: Gaoquan Li
* @Date: 2021/1/10 下午2:35
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private String eventUuid;

    private String eventName;

    private String eventCate;

    private String eventCity;

    private String eventLocation;

    private String eventAddress;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String eventDetail;

    private String eventImg;

    private String publisherEmail;

    private String publisherOpenId;
}