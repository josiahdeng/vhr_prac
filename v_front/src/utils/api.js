import axios from "axios";
import {Message} from 'element-ui';
import router from "../router"

const instance = axios.create();

instance.interceptors.response.use(response => {
    if (response.status && response.status === 200 && response.data.status === 500) {
        Message.error({message: response.data.msg});
        return;
    }

    if (response.data.msg){
        Message.success({message: response.data.msg});
    }
    return response.data;
}, error => {
    if (error.response.status === 500) {
        Message.error({message: "服务器被吃了！"});
    } else if (error.response.status === 403) {
        Message.error({message: "权限不足！请联系管理员。"});
    } else if (error.response.status === 401) {
        Message.error({message: "请登录！"});
        router.replace("/")
    } else if (error.response === 404){
        Message.error({message: "页面被吃了！"})
    } else {
        if (error.response.data.msg) {
            Message.error({message: error.response.data.msg});
        } else {
            Message.error({message: "未知错误！"});
        }
    }
});

export const postKeyValue = (url, params) => {
    return instance.post(url, params,{
        transformRequest: [function (data) {
            let ret = '';
            for (let i in data) {
                ret += encodeURIComponent(i) + '=' + encodeURIComponent(data[i]) + '&'
            }
            return ret;
        }],
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    });
}

export const postRequest = (url, params) => {
    return instance.post(url, params);
}

export const putRequest = (url, params) => {
    return instance.put(url, params);
}

export const getRequest = (url) => {
    return instance.get(url);
}

export const delRequest = (url) => {
    return instance.delete(url);
}

