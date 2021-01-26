package com.terri.hd.eventspro.mapper;

import com.terri.hd.eventspro.pojo.UserEventCol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @Author: Gaoquan Li
* @Date: 2021/1/25 下午11:22
*/
@Mapper
public interface UserEventColMapper {
    /**
     * delete by primary key
     * @param uuid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserEventCol record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserEventCol record);

    /**
     * select by primary key
     * @param uuid primary key
     * @return object by primary key
     */
    UserEventCol selectByPrimaryKey(String uuid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserEventCol record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserEventCol record);

    /**
     * select event's id by user's openid
     * @param opnId user's openid
     * @return event's id
     */
    String[] selectEventByOpenId(@Param("openId") String opnId);
}