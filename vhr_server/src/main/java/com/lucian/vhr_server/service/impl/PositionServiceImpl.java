package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.PositionDao;
import com.lucian.vhr_server.entity.Position;
import com.lucian.vhr_server.entity.RespBean;
import com.lucian.vhr_server.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionDao positionDao;

    @Override
    public List<Position> getPositions() {
        return positionDao.getPositions();
    }

    @Override
    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionDao.insert(position);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionDao.update(position);
    }


    @Override
    public Integer deletePosition(Integer id) {
        Position position = positionDao.queryById(id);
        if (position == null) return 0;
        return positionDao.deleteById(id);
    }

    @Override
    public Integer deletePositionsByIds(Integer[] ids) {
        return positionDao.deleteByIds(ids);
    }
}
