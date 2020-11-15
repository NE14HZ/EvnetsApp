package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.pojo.CustomResult;
import com.terri.hd.eventspro.utils.HttpUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ligaoquan
 */
@RestController
public class LoginController {

    public static final String APPID = "wx0fc4e5c335c19b49";
    public static final String APP_SECRET = "bb777fdf775bab2d534b448c3743902b";

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);
    /**
     * 微信登陆接口
     * @param code
     * @return CustomResult
     */
    @GetMapping("/api/login")
    public CustomResult login(@Param("code") String code) {
        //后台调用 auth.code2Session(发送以下get请求)，使用 code 换取 openid 和 session_key 等信息
        //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        logger.info(code);
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
}
