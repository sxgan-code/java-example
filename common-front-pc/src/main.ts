import '@/assets/common.scss'

import {createApp} from 'vue'
import {createPinia} from 'pinia'

import App from './App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'
//注册移入小浮框提示
import tooltip from '@/components/tips/tooltip'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.use(tooltip)
app.mount('#app')

