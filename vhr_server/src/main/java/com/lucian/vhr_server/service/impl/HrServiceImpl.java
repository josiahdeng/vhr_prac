package com.lucian.vhr_server.service.impl;

import com.lucian.vhr_server.dao.HrDao;
import com.lucian.vhr_server.entity.Hr;
import com.lucian.vhr_server.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    HrDao hrDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrDao.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("用户未找到");
        }
        return hr;
    }
}
