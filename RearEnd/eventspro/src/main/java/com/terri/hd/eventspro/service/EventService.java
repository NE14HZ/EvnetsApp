package com.terri.hd.eventspro.service;

import com.terri.hd.eventspro.entity.Event;

import java.util.List;

public interface EventService {

    /**
     * 查询所有活动
     * @return List<Activity>
     */
    List<Event> findAll();

    /**
     * 根据类别查询活动
     * @return List<Activity>
     */
    List<Event> findByCate(String category);

    /**
     * 根据城市查询活动
     * @param city
     * @return List<Activity>
     */
    List<Event> findByCity(String city);
}
