import {createRouter, createWebHashHistory, type Router} from "vue-router";
import mainRouters from "@/router/main-routers";
import componentRouters from "@/router/component-routers.ts";
import exampleRouters from "@/router/example-routers.ts";

const router: Router = createRouter({
    // Electron中路由方式必须使用Hash方式
    history: createWebHashHistory(),
    routes: [
        ...mainRouters,
        ...componentRouters,
        ...exampleRouters
    ],
    /* 禁用鼠标侧键回退功能 */
    // scrollBehavior: () => {
    //     history.pushState(null, '', document.URL)
    // }
})

export default router