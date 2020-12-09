package com.lucian.vhr_server.service;

import com.lucian.vhr_server.entity.Department;

import java.util.List;

public interface DeptService {
    /**
     * 获取部门信息
     * @return 部门列表
     */
    List<Department> getAllDept();

    /**
     * 添加部门
     * @param department 部门
     */
    void addDept(Department department);

    /**
     * 删除部门
     * @param department 部门
     */
    void deleteDept(Department department);
}
