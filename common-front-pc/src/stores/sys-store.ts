import {defineStore} from 'pinia'

// useStore 可以是 useUser、useCart 之类的任何东西
// 第一个参数是应用程序中 store 的唯一 id
export const SysStore = defineStore('sys', {
    // other options...
    // 推荐使用 完整类型推断的箭头函数
    state: () => {
        return {
            staticBaseUrl: import.meta.env.VITE_BASE_URL + import.meta.env.VITE_BASE_URL,
            baseUrl: import.meta.env.VITE_BASE_URL,
        }
    },
    actions: {},
    getters: {},
    // 持久化
    // persist: true,
})