package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.entity.Event;
import com.terri.hd.eventspro.pojo.CustomResult;
import com.terri.hd.eventspro.service.impl.EventServiceImpl;
import com.terri.hd.eventspro.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ligaoquan
 */
@RestController
public class IndexController {

    public static final String APPID = "wx0fc4e5c335c19b49";
    public static final String APP_SECRET = "bb777fdf775bab2d534b448c3743902b";

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private EventServiceImpl eventService;

    @RequestMapping("/index")
    public String hello(){
        return "Hello World";
    }

    /**
     * 微信登陆接口
     * @param code
     * @return
     */
    @GetMapping("/api/login")
    public CustomResult login(String code) {
        //后台调用 auth.code2Session(发送以下get请求)，使用 code 换取 openid 和 session_key 等信息
        //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        System.out.println(code);
        String urlHeader = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> urlParams = new HashMap<String, String>(8);
        urlParams.put("appid", APPID);
        urlParams.put("secret", APP_SECRET);
        urlParams.put("js_code", code);
        urlParams.put("grant_type", "authorization_code");
        String httpResult = null;
        try {
            httpResult = HttpUtils.getResponse(urlHeader, urlParams);
        } catch (IOException e) {
            logger.info("获取连接相应异常", e);
        }
        return new CustomResult(httpResult);
    }

    @RequestMapping("/getAll")
    public List<Event> getAll(){

        List<Event> list;
        list = eventService.findAll();

        return list;
    }

    @RequestMapping("/getByCate")
    public List<Event> getByCate(String category){

        List<Event> list;
        list = eventService.findByCate(category);

        return list;
    }

    /**
     * 根据城市名查询相关活动信息
     * @param city
     * @return
     */
    @RequestMapping("/getByCity")
    public List<Event> getByCity(@RequestParam String city){

        List<Event> list;
        list = eventService.findByCity(city);

        return list;
    }
}
