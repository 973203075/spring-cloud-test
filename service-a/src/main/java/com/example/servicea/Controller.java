package com.example.servicea;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log
@RestController
public class Controller {

    @Autowired
    ConsumerService consumerService;
    @GetMapping("a1")
    public String a1(){
        String consumer = consumerService.consumer();
        return consumer;
    }
    @GetMapping("a2")
    public String a2(){
        String consumer2 = consumerService.consumer2();
        consumerService.consumer3();
        return consumer2;
    }

    @GetMapping("a3")
    public String a3(){
        return  consumerService.consumer3();
    }
    @GetMapping("a4")
    public String a4(){
        return  "a4";
    }

    @Service
    class ConsumerService{

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer(){
            return restTemplate.getForObject("http://service-b/b", String.class);
        }

        public String fallback(){
            return "fallback-a";
        }
        @HystrixCommand(fallbackMethod = "fallback2")
        public String consumer2() {
            return restTemplate.getForObject("http://service-b/b2", String.class);
        }
        @HystrixCommand(fallbackMethod = "fallback2")
        public String consumer3() {
            return restTemplate.getForObject("http://service-c/c2", String.class);
        }
        public String fallback2(){
            return "fallback-a2";
        }
    }
}
