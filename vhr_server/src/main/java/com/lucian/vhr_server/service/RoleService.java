package com.lucian.vhr_server.service;

import com.lucian.vhr_server.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取所有的角色
     * @return 角色信息集合
     */
    List<Role> getAllRole();

    /**
     * 添加角色
     * @param role 角色
     * @return 影响行数
     */
    int addRole(Role role);

    /**
     * 修改角色
     * @param role 角色
     * @return 影响行数
     */
    int updateRole(Role role);

    /**
     * 删除角色
     * @param rId
     * @return
     */
    int deleteRole(Integer rId);
}
