package com.melardev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    JmsService jsmClient;

    @RequestMapping(value = "/produce")
    public String produce(@RequestParam("message") String msg) {
        jsmClient.send(msg);
        return "Added";
    }

    @RequestMapping(value = "/receive")
    public String consume() {
        return jsmClient.receive();
    }
}
