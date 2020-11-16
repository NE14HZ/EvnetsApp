package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.entity.Event;
import com.terri.hd.eventspro.pojo.CustomResult;
import com.terri.hd.eventspro.service.impl.EventServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ligaoquan
 */
@RestController
public class EventsController {

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    private EventServiceImpl eventService;

    @RequestMapping("/index")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/api/getAll")
    public List<Event> getAll(){

        List<Event> list;
        list = eventService.findAll();

        return list;
    }

    @RequestMapping("/api/getByCate")
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
    @RequestMapping("/api/getByCity")
    public List<Event> getByCity(@RequestParam String city){

        List<Event> list;
        list = eventService.findByCity(city);

        return list;
    }

    @PostMapping("api/add")
    public CustomResult addEvent(@RequestBody Event event) {
        System.out.println(event);
        return new CustomResult("OK");
    }
}
