package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.UserEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * select by user's openId
     * @param openId user's openId
     * @return all event user published
     */
    List<UserEvent> selectByOpenId(String openId);

    /**
     * select all events published by users
     * @return all events published by users
     */
    List<UserEvent> selectAllEvent();

    /**
     * select by primary key
     * @param eventUuid primary key
     * @return object by primary key
     */
    UserEvent selectByPrimaryKey(String eventUuid);

    /**
     * delete by primary key
     * @param eventUuid primaryKey
     * @return deleteCount
     */
    int deleteByUUID(String eventUuid);
}
