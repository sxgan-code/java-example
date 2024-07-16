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
    {
        path: '/main',
        name: 'main',
        component: () => import("@/views/MainPage.vue"),
        children: [
            {
                path: '',
                redirect: '/main/overview',
            },
            {
                path: 'overview',
                name: 'overview',
                component: () => import("@/views/overview/OverviewPage.vue"),
            },
            {
                path: 'btn',
                name: 'btn',
                component: () => import("@/views/basic/btn/ButtonPage.vue"),
            }
        ]

    },
]
export default mainRouters

