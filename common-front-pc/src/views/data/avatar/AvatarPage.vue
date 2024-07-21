<script setup lang="ts">

import ZoeyCropper from "@/components/cropper/ZoeyCropper.vue";
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyDialog from "@/components/dialog/ZoeyDialog.vue";
import {ref} from "vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";

const show = ref(false)
const isShowDialog = (value: boolean) => {
  show.value = !value
};
</script>

<template>
  <div class="cut-root">
    <zoey-title type="h1" hr>截图</zoey-title>
    <zoey-title type="h2">自由截图组件</zoey-title>
    <div>
      <zoey-title type="h4">使用方法</zoey-title>
      <zoey-button @click="show = true" type="primary">点击弹出截图组件</zoey-button>
      <zoey-dialog :show="show"
                   height="60vh"
                   width="40vw"
                   @update:modelValue="isShowDialog(show)">
        <template #title>
          <zoey-title type="h3" hr>截图</zoey-title>
        </template>
        <template #content>
          <zoey-cropper/>
        </template>
        
        <template #footer>
          <zoey-button @click="show = false" type="primary">确定</zoey-button>
          <zoey-button @click="show = false" type="default">取消</zoey-button>
        </template>
      </zoey-dialog>
    
    </div>
  </div>
</template>

<style scoped lang="scss">
.cut-root {
  width: 83vw;
  margin: 5rem auto;
}
</style>