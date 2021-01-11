package com.terri.hd.eventspro.service.impl;

import com.terri.hd.eventspro.controller.FBEventController;
import com.terri.hd.eventspro.mapper.UserMapper;
import com.terri.hd.eventspro.pojo.User;
import com.terri.hd.eventspro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/11 下午4:12
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(FBEventController.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int selectByOpenid(String openid) {

        User user = userMapper.selectByOpenid(openid);
        if (null == user) {
            return 0;
        } else {
            return 1;
        }
    }
}
