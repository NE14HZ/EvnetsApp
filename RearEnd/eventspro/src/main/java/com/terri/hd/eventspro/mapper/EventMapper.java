package com.terri.hd.eventspro.mapper;

import com.terri.hd.eventspro.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Event record);

    /**
     * 查询所有活动
     * @return List<Activity>
     */
    List<Event> findAll();

    /**
     * 根据类别查询活动
     * @param category
     * @return List<Activity>
     */
    List<Event> findByCate(@Param("category") String category);

    /**
     * 根据城市查询活动
     * @param city
     * @return List<Activity>
     */
    List<Event> findByCity(@Param("city") String city);


}