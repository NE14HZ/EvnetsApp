package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.pojo.FBEvent;
import com.terri.hd.eventspro.pojo.CustomResult;
import com.terri.hd.eventspro.service.impl.FBEventServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ligaoquan
 */
@RestController
public class FBEventController {

    private static final Logger logger = LoggerFactory.getLogger(FBEventController.class);

    @Autowired
    private FBEventServiceImpl eventService;

    @RequestMapping("/index")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/api/queryAll")
    public List<FBEvent> queryAll(){

        List<FBEvent> list;
        list = eventService.queryAll();

        return list;
    }

    @RequestMapping("/api/getByCate")
    public List<FBEvent> getByCate(String category){

        List<FBEvent> list;
        list = eventService.findByCate(category);

        return list;
    }

    /**
     * 根据城市名查询相关活动信息
     * @param city
     * @return
     */
    @RequestMapping("/api/getByCity")
    public List<FBEvent> getByCity(@RequestParam String city){

        List<FBEvent> list;
        list = eventService.findByCity(city);

        return list;
    }

    @PostMapping("api/add")
    public CustomResult addEvent(@RequestBody FBEvent FBEvent) {
        System.out.println(FBEvent);
        return new CustomResult("OK");
    }
}
