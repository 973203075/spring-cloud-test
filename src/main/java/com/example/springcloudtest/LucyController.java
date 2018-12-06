package com.example.springcloudtest;

import com.example.springcloudtest.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableConfigurationProperties(ConfigBean.class)
public class LucyController {

    @Autowired
    private ConfigBean configBean;

    @Value("ww")
    private String ww;

    @RequestMapping(value = "lucy")
    public String my(){
        return ww + configBean.toString();
    }
}
