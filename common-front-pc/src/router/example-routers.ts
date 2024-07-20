import type {RouteRecordRaw} from "vue-router";

const mainRouters: RouteRecordRaw[] = [
    {
        path: '/java',
        name: 'java',
        component: () => import("@/views/MainPage.vue"),
        children: [
            {
                path: 'utils/qr',
                name: 'qr',
                component: () => import("@/views/java/utils/QrCodePage.vue"),
            }
        ]

    },
]
export default mainRouters