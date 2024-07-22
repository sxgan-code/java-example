<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import HgCode from "@/components/codelight/HgCode.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
import message, {PositionTypeEnum} from "@/components/message";


const msgCode =
    `<zoey-button class="btn" type="primary" @click="message.success('这里是成功提示消息',PositionTypeEnum.TOP)">点击顶部弹出成功提示内容</zoey-button>
<zoey-button class="btn" type="primary" @click="message.success('这里是成功提示消息',PositionTypeEnum.RIGHT_BOTTOM)">点击右下弹出成功提示内容</zoey-button>
<zoey-button class="btn" type="error" @click="message.error('这里是错误提示消息',PositionTypeEnum.TOP)">点击弹出错误提示内容</zoey-button>
<zoey-button class="btn" type="warn" @click="message.warning('这里是警告提示消息',PositionTypeEnum.TOP)">点击弹出警告提示内容</zoey-button>`
</script>

<template>
  <div class="message-root">
    <zoey-title type="h1" hr>弹框提示组件</zoey-title>
    <zoey-title type="h3">该组件提供顶部或右下角弹出框提示按钮，用法如下：</zoey-title>
    <hg-code :code="msgCode" lang="html"/>
    <zoey-title type="h4">示例：</zoey-title>
    <div class="message-root-btn">
      <zoey-button class="btn" size="large" type="primary"
                   @click="message.success('这里是成功提示消息',PositionTypeEnum.TOP)">点击顶部弹出成功提示内容
      </zoey-button>
      <zoey-button class="btn" size="large" type="primary"
                   @click="message.success('这里是成功提示消息',PositionTypeEnum.RIGHT_BOTTOM)">点击右下弹出成功提示内容
      </zoey-button>
      <zoey-button class="btn" size="large" type="error"
                   @click="message.error('这里是错误提示消息',PositionTypeEnum.TOP)">点击弹出错误提示内容
      </zoey-button>
      <zoey-button class="btn" size="large" type="warn"
                   @click="message.warning('这里是警告提示消息',PositionTypeEnum.TOP)">点击弹出警告提示内容
      </zoey-button>
      <zoey-button class="btn" size="large" type="default"
                   @click="message.note('这里是普通提示消息',PositionTypeEnum.TOP)">点击弹出普通提示内容
      </zoey-button>
    </div>
  
  </div>

</template>

<style scoped lang="scss">
.message-root {
  width: 83vw;
  margin: 5rem auto;
  
  .message-root-btn {
    display: flex;
    
    .btn {
      margin: 0 2rem;
    }
  }
  
}
</style>