package com.example.servicec;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log
@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("c")
    public String c(){
        return "c";
    }

    //@HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("c2")
    public String c2(){
        String forObject = restTemplate.getForObject("http://service-a/a1", String.class);
       log.info("============" + forObject);
        return forObject;
    }
    public String fallback(){
        return "fallback-c2";
    }
}
