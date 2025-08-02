package com.sankuai.sm3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author WXY
 * @Description test
 * @Date 2025-08-02 11:24
 * @Version 1.0
 */
@Controller
public class baseController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
