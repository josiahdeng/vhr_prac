package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.entity.Role;
import com.lucian.vhr_server.service.MenuService;
import com.lucian.vhr_server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public RespBean getAllRole () {
        return RespBean.ok(null, roleService.getAllRole());
    }

    @GetMapping("/menus")
    public RespBean getAllMenu (){
        return RespBean.ok(null, menuService.getAllMenu());
    }

    @GetMapping("/mids/{r_id}")
    public RespBean getMidsByRid(@PathVariable("r_id") Integer rId){
        return RespBean.ok(null, menuService.getMidsByRid(rId));
    }

    @PutMapping("/mids")
    public RespBean updateSelectedMenus(Integer rId, Integer[] mIds){
        if (menuService.updateMenuRoles(rId, mIds)){
            return RespBean.ok("更新成功！！");
        }
        return RespBean.error("更新失败！！");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        System.out.println(role);
        if (roleService.addRole(role) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/role")
    public RespBean updateRole(@RequestBody Role role){
        if (roleService.updateRole(role) == 1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @DeleteMapping("/role/{rId}")
    public RespBean deleteRole(@PathVariable("rId") Integer rId){
        if (roleService.deleteRole(rId) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
