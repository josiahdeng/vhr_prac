package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.JobLevel;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/basic/job_level")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public RespBean getJobLevels(){
        return RespBean.ok(null, jobLevelService.getAllJobLevels());
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel) == 1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel) == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id){
        if (jobLevelService.deleteJobLevel(id) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevels(Integer[] ids){
        if (jobLevelService.deleteJobLevels(ids) == ids.length){
            return RespBean.ok("删除成功" + ids.length + "条数据。");
        }
        return RespBean.error("删除失败");
    }
}
