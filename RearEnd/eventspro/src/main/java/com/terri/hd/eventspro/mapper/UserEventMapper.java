package com.terri.hd.eventspro.mapper;

import com.terri.hd.eventspro.pojo.UserEvent;
import org.apache.ibatis.annotations.Mapper;

/**
* @Author: Gaoquan Li
* @Date: 2021/1/10 下午2:35
*/
@Mapper
public interface UserEventMapper {
    /**
     * delete by primary key
     * @param eventUuid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String eventUuid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserEvent record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserEvent record);

    /**
     * select by primary key
     * @param eventUuid primary key
     * @return object by primary key
     */
    UserEvent selectByPrimaryKey(String eventUuid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserEvent record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserEvent record);
}