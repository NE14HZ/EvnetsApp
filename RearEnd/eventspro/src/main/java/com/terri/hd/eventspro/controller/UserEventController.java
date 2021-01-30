package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.pojo.UserEvent;
import com.terri.hd.eventspro.pojo.UserEventCol;
import com.terri.hd.eventspro.service.impl.UserEventColServiceImpl;
import com.terri.hd.eventspro.service.impl.UserEventServiceImpl;
import com.terri.hd.eventspro.utils.DateUtil;
import com.terri.hd.eventspro.utils.UUIDUtil;
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

    @Autowired
    private UserEventColServiceImpl userEventColService;

    private static final Logger logger = LoggerFactory.getLogger(UserEventController.class);

    @PostMapping("/api/user/addUserEvent")
    public String addUserEvent(@RequestBody Map<String,Object> event) {

        DateUtil dateUtil = new DateUtil();

        LocalDateTime startTime = dateUtil.getDate((String) event.get("startTime"));
        LocalDateTime endTime = dateUtil.getDate((String) event.get("endTime"));

        UserEvent userEvent = new UserEvent();
        userEvent.setEventUuid(new UUIDUtil().getUuid());
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

    @GetMapping("/api/user/queryEventByEventId/{eventUuid}")
    public UserEvent getEventByEventId(@PathVariable String eventUuid) {
        return userEventService.selectByPrimaryKey(eventUuid);
    }

    @PostMapping("/api/user/collectEvent")
    public String collectEvent(@RequestBody Map<String,Object> event) {

        UserEventCol userEventCol = new UserEventCol();

        userEventCol.setUuid(new UUIDUtil().getUuid());
        userEventCol.setUserOpenid((String) event.get("userOpenid"));
        userEventCol.setEventId((String) event.get("eventId"));
        userEventCol.setEventName((String) event.get("eventName"));
        userEventCol.setEventCate((String) event.get("eventCate"));
        userEventCol.setEventCity((String) event.get("eventCity"));
        userEventCol.setEventLocation((String) event.get("eventLocation"));
        userEventCol.setEventAddress((String) event.get("eventAddress"));
        userEventCol.setEventImg((String) event.get("eventImg"));

        userEventColService.insert(userEventCol);

        return "ok";
    }

    @GetMapping("/api/user/getEventId/{openid}")
    public String[] queryEventId(@PathVariable String openid) {

        String[] eventId = userEventColService.selectEventByOpenId(openid);

        if (eventId != null) {
            return eventId;
        } else {
            logger.error("未找到eventId");
            return new String[0];
        }

    }

    @GetMapping("/api/user/queryAllColEvent/{openid}")
    public List<UserEventCol> queryAllColEvent(@PathVariable String openid) {

        List<UserEventCol> collected = userEventColService.selectAllCollected(openid);

        if (collected == null) {
            logger.warn("没有用户收藏的活动");
        }

        return collected;
    }

    @DeleteMapping("/api/user/deleteColEvent/{eventId}/{openid}")
    public Integer deleteColEvent(@PathVariable String eventId,@PathVariable String openid) {

        if (eventId == null || openid == null) {
            logger.error("删除收藏活动请求参数异常！");
            return 0;
        } else {
            int i = userEventColService.deleteByEventIdAndOpenid(eventId, openid);
            if (i != 0) {
                logger.info("删除收藏活动成功");
            } else {
                logger.warn("删除收藏活动失败");
            }
            return i;
        }
    }
}
