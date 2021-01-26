package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.UserEventCol;
import org.apache.ibatis.annotations.Param;

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
     * @param opnId user's openid
     * @return event's id
     */
    String[] selectEventByOpenId(String opnId);
}
