import {fileURLToPath, URL} from 'node:url'

import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import * as path from "node:path";

// https://vitejs.dev/config/
export default defineConfig(({command, mode}) => {
    const ENV_DIR = path.resolve(__dirname, "./env")
    // 启动时根据 command 和 mode 加载 env 内容，全局生效
    const env = loadEnv(mode, ENV_DIR, "")
    const isServe = command === "serve";
    const isBuild = command === "build";
    // 启动时打印 key 的内容
    console.log("当前环境变量VITE_APP_NAME:" + env.VITE_APP_NAME)
    console.log("当前环境变量VITE_BASE_URL:" + env.VITE_BASE_URL)
    console.log("当前环境变量VUE_APP_PROXY_URL:" + env.VUE_APP_PROXY_URL)
    return {
        envDir: ENV_DIR,
        plugins: [
            vue(),
            AutoImport({
                resolvers: [ElementPlusResolver()],
                // 配置auto-imports.d.ts文件生成路径
                dts: path.resolve(__dirname, "other/auto-imports.d.ts")
            }),
            Components({
                resolvers: [ElementPlusResolver()],
                // 配置components.d.ts文件生成路径
                dts: path.resolve(__dirname, "other/components.d.ts")
            }),
        ],
        resolve: {
            alias: {
                '@': fileURLToPath(new URL('./src', import.meta.url))
            }
        },
        server: {
            host: '0.0.0.0',
            port: 9999,
            proxy: {
                '/dev': {
                    target: env.VUE_APP_PROXY_URL,
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/dev/, ''),
                },
            }
        }
    }

})
