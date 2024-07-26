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
            }, {
                path: 'editor',
                name: 'editor',
                component: () => import("@/views/front/editor/WangEditorPage.vue"),
            }
        ]

    },
]
export default mainRouters