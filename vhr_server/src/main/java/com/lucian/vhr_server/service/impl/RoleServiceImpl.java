package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.MenuRoleDao;
import com.lucian.vhr_server.dao.RoleDao;
import com.lucian.vhr_server.entity.MenuRole;
import com.lucian.vhr_server.entity.Role;
import com.lucian.vhr_server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    MenuRoleDao menuRoleDao;

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Override
    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" +  role.getName());
        }
        return roleDao.insert(role);
    }

    @Override
    public int updateRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" +  role.getName());
        }
        return roleDao.update(role);
    }

    @Override
    @Transactional
    public int deleteRole(Integer rId){
        menuRoleDao.deleteByRoleId(rId);
        return roleDao.deleteById(rId);
    }
}
