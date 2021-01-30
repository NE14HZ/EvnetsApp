package com.terri.hd.eventspro.service.impl;

import com.terri.hd.eventspro.mapper.UserEventColMapper;
import com.terri.hd.eventspro.pojo.UserEventCol;
import com.terri.hd.eventspro.service.UserEventColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/26 上午12:04
 */
@Service
public class UserEventColServiceImpl implements UserEventColService {

    @Autowired
    private UserEventColMapper eventColMapper;

    @Override
    public int insert(UserEventCol record) {
        return eventColMapper.insert(record);
    }

    @Override
    public String[] selectEventByOpenId(String opnId) {
        return eventColMapper.selectEventByOpenId(opnId);
    }

    @Override
    public List<UserEventCol> selectAllCollected(String openid) {
        return eventColMapper.selectAllCollected(openid);
    }

    @Override
    public int deleteByEventIdAndOpenid(String eventId, String openid) {
        return eventColMapper.deleteByEventIdAndOpenid(eventId, openid);
    }
}
