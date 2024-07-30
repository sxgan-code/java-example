import '@/assets/css/common.scss'
import 'virtual:svg-icons-register'
import {createApp} from 'vue'
import {createPinia} from 'pinia'

import App from './App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'
//注册移入小浮框提示
import tooltip from '@/components/tips/tooltip'
/* 导入代码高亮模块 */
import 'highlight.js/styles/stackoverflow-light.css'
import 'highlight.js/lib/common';
import hljsVuePlugin from "@highlightjs/vue-plugin";

const app: any = createApp(App)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.use(tooltip)
app.use(hljsVuePlugin)
app.mount('#app')

