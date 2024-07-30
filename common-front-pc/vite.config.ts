import {fileURLToPath, URL} from 'node:url'

import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import * as path from "node:path";
import {createSvgIconsPlugin} from "vite-plugin-svg-icons";

// https://vitejs.dev/config/
export default defineConfig(({command, mode}) => {
    const ENV_DIR = path.resolve(__dirname, "./env")
    // 启动时根据 command 和 mode 加载 env 内容，全局生效
    const env = loadEnv(mode, ENV_DIR, "")
    const isServe = command === "serve";
    const isBuild = command === "build";
    // 启动时打印 key 的内容
    console.log("当前环境变量VITE_APP_NAME:" + env.VITE_APP_NAME)
    console.log("当前环境变量VITE_ENV_URL:" + env.VITE_ENV_URL)
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
            createSvgIconsPlugin({
                // 指定需要缓存的图标文件夹
                iconDirs: [path.resolve(process.cwd(), 'src/assets/images/svg')],
                // 指定symbolId格式
                symbolId: 'icon-[dir]-[name]',

                /**
                 * 自定义插入位置
                 * @default: body-last
                 */
                inject: 'body-last',

                /**
                 * custom dom id
                 * @default: __svg__icons__dom__
                 */
                customDomId: '__svg__icons__dom__',
                // 移除填充
                svgoOptions: {
                    plugins: [{
                        name: 'removeAttrs',
                        params: {
                            attrs: 'fill'
                        }
                    }]
                }
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
                '/local': {
                    target: 'http://localhost:9999/src/assets/images',
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/local/, ''),
                },
                '/dev': {
                    target: env.VUE_APP_PROXY_URL,
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/dev/, ''),
                },
                '/oss': {
                    target: 'https://zoey-open-image.oss-cn-beijing.aliyuncs.com/',
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/oss/, ''),
                },
                '/gitee': {
                    target: 'https://gitee.com/sxgan/zoey-open-images/raw/master/',
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/gitee/, ''),
                },
                '/picgo': {
                    target: 'https://img.picgo.net/',
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/picgo/, ''),
                },
                '/github': {
                    target: 'https://raw.githubusercontent.com/sxgan-code/zoey-open-images/main',
                    changeOrigin: true, // 表示开启代理, 允许跨域请求数据
                    secure: false,  // 如果是https接口，需要配置这个参数
                    rewrite: (path) => path.replace(/^\/github/, ''),
                },
            }
        }
    }

})
