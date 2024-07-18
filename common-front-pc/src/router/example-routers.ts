import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
    {
        path: '/example',
        name: 'example',
        component: () => import("@/views/MainPage.vue"),
        children: []

    },
]
export default mainRouters