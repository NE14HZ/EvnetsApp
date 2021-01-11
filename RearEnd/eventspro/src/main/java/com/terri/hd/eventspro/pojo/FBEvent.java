package com.terri.hd.eventspro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ligaoquan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FBEvent {

    private String id;

    private String eventName;

    private String eventCate;

    private String eventCity;

    private String eventLocation;

    private String eventAddress;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String eventDetail;

    private String eventImg;

    private String originalLink;


}