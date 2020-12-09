package com.lucian.vhr_server.service;

import com.lucian.vhr_server.entity.Menu;
import com.lucian.vhr_server.entity.RespBean;

import java.util.List;

public interface MenuService {
    List<Menu> getMenusByHrId();

    /**
     * 获取所有menu带权限控制
     * @return menu集合
     */
    List<Menu> getAllMenuWithRole();

    /**
     * 获取所有菜单
     * @return menu集合
     */
    List<Menu> getAllMenu();

    /**
     * 根据r_id获取被选中的权限
     * @param rId
     * @return 被选中的权限id集合
     */
    List<Integer> getMidsByRid(Integer rId);

    /**
     * 更新角色菜单权限
     * @param rId
     * @param mIds
     * @return
     */
    Boolean updateMenuRoles(Integer rId, Integer[] mIds);
}
