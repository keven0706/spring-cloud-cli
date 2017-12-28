package com.zn.cloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author by zhaining
 * @description 注册中心
 * @created date 2017/11/7.
 */
@SpringBootApplication
@EnableEurekaServer
public class DogRegistryApplication
{
    public static void main(String[] args){
        SpringApplication.run(DogRegistryApplication.class,args);
    }
}
