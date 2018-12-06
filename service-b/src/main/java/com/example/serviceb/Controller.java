package com.example.serviceb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log
@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("b")
    public String b(){
        return restTemplate.getForObject("http://service-a/a4", String.class);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("b2")
    public String b2(){
        /**
         * 测试熔断器
         */
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String forObject = restTemplate.getForObject("http://service-a/a3", String.class);
        return forObject;
    }
    public String fallback(){
        return "fallback-b2";
    }
}
