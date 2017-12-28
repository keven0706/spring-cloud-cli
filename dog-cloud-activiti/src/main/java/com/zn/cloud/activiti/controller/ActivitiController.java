package com.zn.cloud.activiti.controller;

import com.zn.cloud.activiti.service.ActivityConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/24.
 */
@RestController
public class ActivitiController
{
    @Autowired
    ActivityConsumerService activityConsumerService;

    @RequestMapping(value = "/complete/{approve}/{taskId}" , method = RequestMethod.GET)
    public String complete(@PathVariable Boolean approve,@PathVariable String taskId){
        System.out.println(approve + taskId);
        activityConsumerService.complete(approve,taskId);
        return "ok";
    }
}
