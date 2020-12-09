package com.lucian.vhr_server.controller;

import com.lucian.vhr_server.entity.Position;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public RespBean getPositions(){
        return RespBean.ok(null, positionService.getPositions());
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        Integer integer = positionService.addPosition(position);
        if (integer == 1){
            return RespBean.ok("添加成功!");
        } else {
            return RespBean.error("添加失败!");
        }
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        Integer integer = positionService.updatePosition(position);
        if (integer == 1){
            return RespBean.ok("更新成功!");
        } else {
            return RespBean.error("更新失败!");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        Integer integer = positionService.deletePosition(id);
        if (integer == 1){
            return RespBean.ok("删除成功!");
        } else {
            return RespBean.error("删除失败!");
        }
    }

    @DeleteMapping("/")
    public RespBean deletePositions(Integer[] ids){
        if (positionService.deletePositionsByIds(ids) == ids.length){
            return RespBean.ok("已经删除" + ids.length + "数据!");
        }
        return RespBean.error("删除失败!");
    }
}
