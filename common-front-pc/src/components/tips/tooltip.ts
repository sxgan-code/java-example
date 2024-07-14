import {type Ref} from 'vue'

export default {
    install(app: any) {
        tooltip(app)
    }
}

export enum BackgroundType {
    black = 'black',
    white = 'white'
}

export interface TooltipType {
    text: string;
    bg: BackgroundType;
}

/**
 * 自定义指令：用于给元素添加悬浮提示<br/>
 * 必要前提：安装VUE，导入此文件，并在main文件中app.use(tooltip)<br/>
 * 使用示例：&lt;img v-tip="{text:'点击刷新',bg:BackgroundType.black}" width="100" height="30"&gt;
 * @param app
 */
const tooltip = (app: any) => {
    app.directive('tip', {
        mounted(el: HTMLElement, binding: Ref<TooltipType>) {
            const tooltipText = binding.value.text; // 提示文本
            const bg = binding.value.bg; // 提示文本
            el.addEventListener('mouseenter', (e) => {
                const tooltip = document.createElement('div');
                tooltip.setAttribute('class', 'tooltip-div')
                tooltip.innerText = tooltipText;
                tooltip.style.position = 'absolute';
                tooltip.style.zIndex = '999';
                if (bg === 'black') {
                    tooltip.style.background = 'rgba(0, 0, 0, 0.95)';
                    tooltip.style.color = 'white';
                } else {
                    tooltip.style.background = 'rgba(255, 255, 255, 0.95)';
                    tooltip.style.color = 'black';
                }
                tooltip.style.fontFamily = 'HarmonyOS Scan'
                tooltip.style.fontSize = '10px'
                tooltip.style.fontWeight = 'bold'
                tooltip.style.borderRadius = '4px';
                tooltip.style.padding = '5px';
                tooltip.style.display = 'block';
                // 获取鼠标位置
                tooltip.style.top = `${e.clientY + 20}px`;
                tooltip.style.left = `${e.clientX - 10}px`;
                document.body.appendChild(tooltip);
            });

            el.addEventListener('mouseleave', () => {
                const tooltip = document.getElementsByClassName('tooltip-div')
                for (let i = 0; i < tooltip.length; i++) {
                    tooltip.item(i)?.remove()
                }
            });
            el.addEventListener('click', (e) => {
                const tooltip = document.getElementsByClassName('tooltip-div')
                for (let i = 0; i < tooltip.length; i++) {
                    tooltip.item(i)?.remove()
                }
            })
        }
    })
}