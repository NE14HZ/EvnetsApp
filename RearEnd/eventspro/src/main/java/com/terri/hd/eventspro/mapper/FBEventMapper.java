package com.terri.hd.eventspro.mapper;

import com.terri.hd.eventspro.pojo.FBEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FBEventMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FBEvent record);

    /**
     * 根据id获取活动信息
     * @param id
     * @return
     */
    FBEvent queryByPrimaryKey(Integer id);

    int updateByPrimaryKey(FBEvent record);

    /**
     * 查询所有活动
     * @return List<Activity>
     */
    List<FBEvent> queryAll();

    /**
     * 根据类别查询活动
     * @param category
     * @return List<Activity>
     */
    List<FBEvent> findByCate(@Param("category") String category);

    /**
     * 根据城市查询活动
     * @param city
     * @return List<Activity>
     */
    List<FBEvent> findByCity(@Param("city") String city);


}