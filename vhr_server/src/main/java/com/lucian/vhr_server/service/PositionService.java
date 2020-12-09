package com.lucian.vhr_server.service;

import com.lucian.vhr_server.entity.Position;
import com.lucian.vhr_server.entity.RespBean;

import java.util.List;

public interface PositionService {
    /**
     * 查询所有所有职位
     * @return 职位列表
     */
    public List<Position> getPositions();

    /**
     * 添加职位
     * @param position 职位
     * @return 影响行数
     */
    public Integer addPosition(Position position);

    /**
     * 更新职位
     * @param position 职位
     * @return 影响行数
     */
    Integer updatePosition(Position position);

    /**
     * 删除职位
     * @param id 主键
     * @return 影响行数
     */
    Integer deletePosition(Integer id);

    /**
     * 批量删除职位
     * @param ids 职位id集合
     * @return 影响行数
     */
    Integer deletePositionsByIds(Integer[] ids);
}
