package com.zn.cloud.gateway.controller;

import com.zn.cloud.gateway.config.MyHealthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/22.
 */
@RestController
public class UpController
{
    @Autowired
    MyHealthChecker myHealthChecker;

    @RequestMapping("/up")
    public String up(@RequestParam("up") Boolean up) {
        myHealthChecker.setUp(up);

        return up.toString();
    }
}
