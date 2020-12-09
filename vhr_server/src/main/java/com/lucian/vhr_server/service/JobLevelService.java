package com.lucian.vhr_server.service;

import com.lucian.vhr_server.entity.JobLevel;

import java.util.List;

public interface JobLevelService {

    /**
     * 获取所有的职称
     * @return 职称列表
     */
    public List<JobLevel> getAllJobLevels();

    /**
     * 添加职称
     * @param jobLevel 职称
     * @return 影响行数
     */
    public int addJobLevel(JobLevel jobLevel);

    /**
     * 修改职称
     * @param jobLevel 职称
     * @return 影响行数
     */
    public int updateJobLevel(JobLevel jobLevel);

    /**
     * 删除职称
     * @param id 职称id
     * @return 影响行数
     */
    public int deleteJobLevel(Integer id);

    /**
     * 删除多条职称
     * @param ids 职称数组
     * @return 影响行数
     */
    public int deleteJobLevels(Integer [] ids);
}
