package com.terri.hd.eventspro.service.impl;

import com.terri.hd.eventspro.entity.Event;
import com.terri.hd.eventspro.mapper.EventMapper;
import com.terri.hd.eventspro.service.EventService;
import com.terri.hd.eventspro.entity.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ligaoquan
 */
@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventMapper eventMapper;

    @Override
    public List<Event> findAll() {

        List<Event> list = null;
        list = eventMapper.findAll();
        return list;
    }

    @Override
    public List<Event> findByCate(String category) {

        List<Event> list;
        list = eventMapper.findByCate(category);
        return list;
    }

    @Override
    public List<Event> findByCity(String city) {

        List<Event> list;
        list = eventMapper.findByCity(city);
        return list;
    }
}
