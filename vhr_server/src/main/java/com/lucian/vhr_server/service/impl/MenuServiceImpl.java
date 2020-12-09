package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.MenuDao;
import com.lucian.vhr_server.dao.MenuRoleDao;
import com.lucian.vhr_server.entity.Hr;
import com.lucian.vhr_server.entity.Menu;
import com.lucian.vhr_server.entity.MenuRole;
import com.lucian.vhr_server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@CacheConfig(cacheNames = "menu")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Autowired
    MenuRoleDao menuRoleDao;

    @Override
    public List<Menu> getMenusByHrId() {
         Hr hr= (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuDao.getMenusByHrId(hr.getId());
    }

    @Override
    @Cacheable
    public List<Menu> getAllMenuWithRole() {
        return menuDao.getAllMenuWithRole();
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Override
    public List<Integer> getMidsByRid(Integer rId) {
        return menuDao.getMidsByRid(rId);
    }

    @Override
    @Transactional
    public Boolean updateMenuRoles(Integer rId, Integer[] mIds) {
        menuRoleDao.deleteByRoleId(rId);
        int result = 0;
        int mIdsLength = 0;
        List<MenuRole> menuRoles = new ArrayList<>();
        if(mIds != null){
            Arrays.stream(mIds).forEach(mId -> {
                MenuRole menuRole = new MenuRole();
                menuRole.setRid(rId);
                menuRole.setMid(mId);
                menuRoles.add(menuRole);
            });
            mIdsLength = mIds.length;
            result = menuRoleDao.insertBatch(menuRoles);
        }
        return result == mIdsLength;
    }
}
