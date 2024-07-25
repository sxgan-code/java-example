import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
    {
        path: '/front',
        name: 'front',
        component: () => import("@/views/MainPage.vue"),
        children: [
            {
                path: 'echarts',
                name: 'echarts',
                component: () => import("@/views/front/echarts/EchartsPage.vue"),
            }
        ]

    },
]
export default mainRouters