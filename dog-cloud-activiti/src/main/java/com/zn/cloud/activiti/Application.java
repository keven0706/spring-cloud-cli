package com.zn.cloud.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/24.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
public class Application
{
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
