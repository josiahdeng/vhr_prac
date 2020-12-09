package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.Menu;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menus")
    public RespBean getMenusByHrId(){
        return RespBean.ok(null, menuService.getMenusByHrId());
    }
}
