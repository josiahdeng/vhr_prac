package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.Department;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/basic/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/")
    public RespBean getAllDept(){
        return RespBean.ok(null, deptService.getAllDept());
    }

    @PostMapping("/")
    public RespBean add(@RequestBody Department department){
        deptService.addDept(department);
        if (department.getResult() == 1){
            return RespBean.ok("添加成功！", department);
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean delete(@PathVariable("id") Integer id){
        Department department = new Department();
        department.setId(id);
        deptService.deleteDept(department);
        if (department.getResult() == -2){
            return RespBean.error("有子部门，删除失败！");
        } else if(department.getResult() == -1) {
            return RespBean.error("有关联员工，删除失败！");
        } else if(department.getResult() == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
