package com.test.restapitest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/delay/{sec}")
    public String delay(@PathVariable String sec) throws InterruptedException {
        Thread.sleep(Integer.parseInt(sec) * 1000L);
        return "Test Start!";
    }
}