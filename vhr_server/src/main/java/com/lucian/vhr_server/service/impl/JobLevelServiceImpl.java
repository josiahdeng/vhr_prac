package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.JobLevelDao;
import com.lucian.vhr_server.entity.JobLevel;
import com.lucian.vhr_server.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    JobLevelDao jobLevelDao;

    @Override
    public List<JobLevel> getAllJobLevels() {
        return jobLevelDao.getAllJobLevels();
    }

    @Override
    public int addJobLevel(JobLevel jobLevel) {
        jobLevel.setEnabled(true);
        jobLevel.setCreateDate(new Date());
        return jobLevelDao.insert(jobLevel);
    }

    @Override
    public int updateJobLevel(JobLevel jobLevel) {
        JobLevel level = jobLevelDao.queryById(jobLevel.getId());
        if (level == null){
            return 0;
        }
        level.setName(jobLevel.getName());
        level.setTitleLevel(jobLevel.getTitleLevel());
        level.setCreateDate(new Date());
        level.setEnabled(jobLevel.getEnabled());
        return jobLevelDao.update(level);
    }

    public int deleteJobLevel(Integer id) {
        JobLevel jobLevel = jobLevelDao.queryById(id);
        if (jobLevel == null){
            return 0;
        }
        return jobLevelDao.deleteById(jobLevel.getId());
    }

    public int deleteJobLevels(Integer [] ids){
        return jobLevelDao.deleteByIds(ids);
    }
}
