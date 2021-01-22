package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.pojo.FBEvent;

import java.util.List;

public interface FBEventService {

    /**
     * 根据id获取活动信息
     * @param id
     * @return
     */
    FBEvent queryByPrimaryKey(Integer id);

    /**
     * 查询所有活动
     * @return List<Activity>
     */
    List<FBEvent> queryAll();

    /**
     * 根据类别查询活动
     * @return List<Activity>
     */
    List<FBEvent> findByCate(String category);

    /**
     * 根据城市查询活动
     * @param city
     * @return List<Activity>
     */
    List<FBEvent> findByCity(String city);
}
