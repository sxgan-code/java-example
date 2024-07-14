// src\utils\http.ts 参考于https://gitee.com/youlaiorg/vue3-element-admin/blob/master/src/utils/request.ts
import axios, {type AxiosInstance, type AxiosResponse, type InternalAxiosRequestConfig} from 'axios';
// useUserStore用于用户权限验证的全局token状态管理
// import {useUserStore} from "@/store/user-store.ts";

// const userStore = useUserStore();
// 创建 axios 实例
const service: AxiosInstance = axios.create({
    // baseURL: import.meta.env.VITE_APP_BASE_API,
    // 这里使用在线mock数据,根据实际情况配置
    baseURL: import.meta.env.VITE_ENV_URL,
    timeout: 50000,
    // headers: {'Content-Type': 'application/json;charset=utf-8'}
});

// 请求拦截器
service.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        // 通过配置每次请求头添加token来自动权限校验
        var token = localStorage.getItem('token');
        if (token != null && token != '') {
            config.headers.Authorization = token;
        }
        if (config.headers.get('Use-Timestamp')) {
            config.url = config.url + '?timestamp=' + new Date().getTime();
        }
        console.log("当前请求路径", config.url);
        // console.log(import.meta.env.VITE_BASE_URL)
        return config;
    },
    (error: any) => {
        return Promise.reject(error);
    }
);

// 响应拦截器
service.interceptors.response.use(
    (response: AxiosResponse) => {
        // console.log("http.ts response", response)
        const {status, msg} = response.data;
        // 700以上为业务错误
        if (status === 200 || status >= 700) {
            return response.data;
        }
        // 响应数据为二进制流处理(Excel导出)
        if (response.data instanceof ArrayBuffer) {
            return response;
        }

        // ElMessage.error(msg || '系统出错');
        return Promise.reject(new Error(msg || 'Error'));
    },
    (error: any) => {
        if (error.response.data) {
            const {status} = error.response.data;
            // token 过期,重新登录
            if (status === 401) {
                localStorage.clear();
                window.location.href = '/';
            }
        }
        return Promise.reject(error.message);
    }
);
// 导出 axios 实例
export default service;