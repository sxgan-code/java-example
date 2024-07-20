import type {RouteRecordRaw} from "vue-router";

const componentRouters: RouteRecordRaw[] = [
    {
        path: '/component',
        component: () => import("@/views/MainPage.vue"),
        children: [
            {
                path: '',
                redirect: '/component/overview',
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
                name: 'flex',
                component: () => import("@/views/basic/layout/FlexLayoutPage.vue"),
            },
            {
                path: 'feedback/message',
                name: 'message',
                component: () => import("@/views/feedback/message/MessagePage.vue"),
            },
            {
                path: 'data/avatar',
                name: 'avatar',
                component: () => import("@/views/data/avatar/AvatarPage.vue"),
            }
        ]

    },
]
export default componentRouters