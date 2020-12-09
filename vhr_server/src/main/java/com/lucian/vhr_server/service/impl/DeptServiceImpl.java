package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.DepartmentDao;
import com.lucian.vhr_server.entity.Department;
import com.lucian.vhr_server.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDept() {
        return departmentDao.getAllDeptWithChildren(-1);
    }

    @Override
    public void addDept(Department department) {
        department.setEnabled(true);
        departmentDao.addDept(department);
    }

    @Override
    public void deleteDept(Department department) {
        departmentDao.deleteDept(department);
    }
}
