package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/11 下午4:10
 */
public interface UserService {

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * select by openid
     * @param openid openid
     * @return object by openid
     */
    int selectByOpenid(@Param("openid") String openid);
}
