package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录!");
    }

    @GetMapping("/employee/advanced/hello")
    public String hello(){
        return "hello";
    }
}
