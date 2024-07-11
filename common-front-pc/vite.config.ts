import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import * as path from "node:path";

// https://vitejs.dev/config/
export default defineConfig({
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
        host: '127.0.0.1',
        port: 9999,
    }
})
