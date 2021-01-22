package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.pojo.UserEvent;
import com.terri.hd.eventspro.service.impl.UserEventServiceImpl;
import com.terri.hd.eventspro.utils.DateUtil;
import com.terri.hd.eventspro.utils.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gaoquan Li
 * @Date: 2021/1/10 下午10:02
 */

@RestController
public class UserEventController {

    @Autowired
    private UserEventServiceImpl userEventService;

    private static final Logger logger = LoggerFactory.getLogger(UserEventController.class);

    @PostMapping("/api/user/addUserEvent")
    public String addUserEvent(@RequestBody Map<String,Object> event) {

        DateUtil dateUtil = new DateUtil();

        LocalDateTime startTime = dateUtil.getDate((String) event.get("startTime"));
        LocalDateTime endTime = dateUtil.getDate((String) event.get("endTime"));

        UserEvent userEvent = new UserEvent();
        userEvent.setEventUuid(new UuidUtil().getUuid());
        userEvent.setEventName((String) event.get("eventName"));
        userEvent.setEventCate((String) event.get("eventCate"));
        userEvent.setEventCity((String) event.get("eventCity"));
        userEvent.setEventLocation((String) event.get("eventLocation"));
        userEvent.setEventAddress((String) event.get("eventAddress"));
        userEvent.setStartTime(startTime);
        userEvent.setEndTime(endTime);
        userEvent.setEventDetail((String) event.get("eventDetail"));
        userEvent.setEventImg((String) event.get("eventImg"));
        userEvent.setPublisherEmail((String) event.get("publisherEmail"));
        userEvent.setPublisherOpenId((String) event.get("publisherOpenid"));

        userEventService.insert(userEvent);
        return "ok";
    }

    @GetMapping("/api/user/queryPb/{openId}")
    public List<UserEvent> queryAllPbEvents(@PathVariable String openId) {

        if (null != openId) {
            List<UserEvent> userEvents = userEventService.selectByOpenId(openId);
            if (null != userEvents) {
                return userEvents;
            } else {
                logger.info("该用户没有发布活动");
                return null;
            }
        } else {
            logger.error("openId为空");
            return null;
        }
    }

    @DeleteMapping("/api/user/deleteById/{uuid}")
    public int deleteById(@PathVariable String uuid) {

        int i = userEventService.deleteByUUID(uuid);
        if (0 == i) {
            logger.error("删除异常");
        }
        return i;
    }
}
