import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
    {
        path: '/',
        name: 'root',
        redirect: '/signin',
    },
    {
        path: '/signin',
        name: 'signin',
        component: () => import("@/views/SigninPage.vue"),
    },
]
export default mainRouters

