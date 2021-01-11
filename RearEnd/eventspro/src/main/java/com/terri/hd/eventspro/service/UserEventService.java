package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.UserEvent;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/10 下午9:19
 */
public interface UserEventService {

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserEvent record);
}
