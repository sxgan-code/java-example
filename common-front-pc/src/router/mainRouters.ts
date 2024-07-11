import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
    {
        path: '/',
        name: 'signin',
        redirect: '/signin',
    },
    {
        path: '/signin',
        name: 'signin',
        component: () => import("@/views/SigninPage.vue"),
    },
    {
        path: '/main',
        name: 'main',
        component: () => import("@/views/MainPage.vue"),
        // children: [
        //     {
        //         path: 'overview',
        //         name: 'overview',
        //         component: () => import("@/components/OverView.vue"),
        //     }
        // ]

    },
]
export default mainRouters

