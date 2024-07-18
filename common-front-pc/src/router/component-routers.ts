import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
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
                path: 'basic/btn',
                name: 'btn',
                component: () => import("@/views/basic/btn/ButtonPage.vue"),
            },
            {
                path: 'basic/layout',
                name: 'layout',
                component: () => import("@/views/basic/layout/FlexLayoutPage.vue"),
            }
        ]

    },
]
export default mainRouters