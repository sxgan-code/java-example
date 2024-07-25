import {createRouter, createWebHashHistory, type Router} from "vue-router";
import componentRouters from "@/router/component-routers.ts";
import exampleRouters from "@/router/example-routers.ts";
import frontRouters from "@/router/front-routers.ts";

const router: Router = createRouter({
    // Electron中路由方式必须使用Hash方式
    history: createWebHashHistory(),
    routes: [
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
            component: () => import("@/views/MainPage.vue"),
            children: [
                {
                    path: '',
                    redirect: '/main/overview',
                },
                {
                    path: 'overview',
                    component: () => import("@/views/overview/OverviewPage.vue"),
                },

            ]

        },
        ...componentRouters,
        ...exampleRouters,
        ...frontRouters
    ],
    /* 禁用鼠标侧键回退功能 */
    // scrollBehavior: () => {
    //     history.pushState(null, '', document.URL)
    // }
})

export default router