/// <reference types="vite/client" />

// shims-vue.d.ts
declare module '*.vue' {
    import type {DefineComponent} from 'vue';
    const component: DefineComponent<{}, {}, any>;
    export default component;
}

interface ImportMetaEnv {
    /** 应用名称 */
    readonly VITE_APP_NAME: string
    /** 当前环境 */
    readonly VUE_APP_ENV: string
    /** 首页地址*/
    readonly VUE_BASE_URL: string
    /** baseURL 用于区分环境并配置代理 */
    readonly VITE_ENV_URL: string
    /** proxy代理地址 */
    readonly VUE_APP_PROXY_URL: string
    // 更多环境变量...
}

interface ImportMeta {
    readonly env: ImportMetaEnv
}