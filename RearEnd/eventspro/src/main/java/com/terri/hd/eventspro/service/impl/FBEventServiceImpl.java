package com.terri.hd.eventspro.service.impl;

import com.terri.hd.eventspro.pojo.FBEvent;
import com.terri.hd.eventspro.mapper.FBEventMapper;
import com.terri.hd.eventspro.service.FBEventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ligaoquan
 */
@Service
public class FBEventServiceImpl implements FBEventService {

    @Resource
    private FBEventMapper FBEventMapper;

    @Override
    public FBEvent queryByPrimaryKey(Integer id) {
        if (id > 0) {
            return FBEventMapper.queryByPrimaryKey(id);
        } else {
            return null;
        }
    }

    @Override
    public List<FBEvent> queryAll() {

        List<FBEvent> list = null;
        list = FBEventMapper.queryAll();
        return list;
    }

    @Override
    public List<FBEvent> findByCate(String category) {

        List<FBEvent> list;
        list = FBEventMapper.findByCate(category);
        return list;
    }

    @Override
    public List<FBEvent> findByCity(String city) {

        List<FBEvent> list;
        list = FBEventMapper.findByCity(city);
        return list;
    }
}
