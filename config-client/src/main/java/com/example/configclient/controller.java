package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class controller {

    @Value("${foo}")
    private String foo;
    @GetMapping("get")
    public String test(){
        return foo;
    }
}
