import {getRequest} from "@/utils/api";

export const initMenu = (router, store) => {
    if (store.state.routes.length > 0){
        return;
    }
    getRequest("/system/config/menus").then(data => {
        if(data){
            let fmtRoutes = formatRoutes(data.obj);
            router.addRoutes(fmtRoutes);
            store.commit('initRoutes', fmtRoutes);
        }
    })
}

export const formatRoutes = routes => {
    let fmRoutes = [];
    routes.forEach(router => {
        let {
            path,
            name,
            component,
            iconCls,
            children,
            meta
        } = router;
        if (children && children instanceof Array) children = formatRoutes(children);
        let fmRoute = {
            path: path,
            name: name,
            component(resolve){
                if (component.startsWith("Home")) {
                    require(['../views/' + component + '.vue'], resolve);
                } else if (component.startsWith("Emp")) {
                    require(['../views/emp/' + component + '.vue'], resolve);
                } else if (component.startsWith("Per")) {
                    require(['../views/per/' + component + '.vue'], resolve);
                } else if (component.startsWith("Sal")) {
                    require(['../views/sal/' + component + '.vue'], resolve);
                } else if (component.startsWith("Sta")) {
                    require(['../views/sta/' + component + '.vue'], resolve);
                } else if (component.startsWith("Sys")) {
                    require(['../views/sys/' + component + '.vue'], resolve);
                }
            },
            iconCls: iconCls,
            meta: meta,
            children: children
        };
        fmRoutes.push(fmRoute);
    })
    return fmRoutes;
}
