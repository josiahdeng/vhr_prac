package com.lucian.vhr_server.config;

import com.lucian.vhr_server.entity.Menu;
import com.lucian.vhr_server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleFilter implements FilterInvocationSecurityMetadataSource {

    // ant 风格的路径匹配
    AntPathMatcher antPathMatcher = new AntPathMatcher();;

    @Autowired
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getAllMenuWithRole();
        List<ConfigAttribute> collect = menus.stream().filter(menu -> antPathMatcher.match(menu.getUrl(), requestUrl))
                //获取roles
                .map(Menu::getRoles)
                //合并roles
                .flatMap(Collection::stream)
                .distinct()
                //获取需要的权限
                .map(role -> new SecurityConfig(role.getName()))
                .collect(Collectors.toList());
        return collect.size() > 0 ? collect : SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
