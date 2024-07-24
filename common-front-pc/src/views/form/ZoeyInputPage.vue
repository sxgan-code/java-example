<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyInput from "@/components/form/ZoeyInput.vue";
</script>

<template>
  <div class="input-root">
    <zoey-title type="h1" hr>表单组件之input输入框</zoey-title>
    <zoey-title type="h2">以下为input组件示例</zoey-title>
    <div class="form-box">
      <zoey-input type="text" label="姓名："/>
      <zoey-input type="file">上传文件</zoey-input>
      <zoey-input type="file">上传文件</zoey-input>
      <zoey-input type="file">上传文件</zoey-input>
    </div>
  
  </div>


</template>

<style scoped lang="scss">
.input-root {
  width: 83vw;
  margin: 5rem auto;
  
  .form-box {
    margin: auto;
    background: lemonchiffon;
    width: 50rem;
    height: 40rem;
  }
}
</style>