package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.UserEventCol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/26 上午12:03
 */
public interface UserEventColService {

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserEventCol record);

    /**
     * select event's id by user's openid
     * @param openid user's openid
     * @return event's id
     */
    String[] selectEventByOpenId(String openid);

    /**
     * query all collected event by user's openid
     * @return all collected event
     */
    List<UserEventCol> selectAllCollected(String openid);

    /**
     * delete by primary key
     * @param eventId,openid event's id and user's openid
     * @return deleteCount
     */
    int deleteByEventIdAndOpenid(String eventId, String openid);
}
