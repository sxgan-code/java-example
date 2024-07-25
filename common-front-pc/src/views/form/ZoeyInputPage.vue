<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyInput from "@/components/form/ZoeyInput.vue";
</script>

<template>
  <div class="input-root">
    <zoey-title type="h1" hr>表单组件之input输入框</zoey-title>
    <zoey-title type="h2">以下为input组件示例</zoey-title>
    <div class="form-box">
      <div class="form-box-w">
        <zoey-input type="text" label="Activity name"/>
        <zoey-input type="password" label="Activity password"/>
        <zoey-input type="button" label="Instant delivery" value="按钮"/>
        <zoey-input type="textarea" label="Activity form" width="50rem" height="8rem"/>
        <zoey-input type="file">上传文件</zoey-input>
      </div>
    
    
    </div>
  
  </div>


</template>

<style scoped lang="scss">
.input-root {
  width: 83vw;
  margin: 5rem auto;
  
  .form-box {
    margin: auto;
    border: 0.1rem solid #ccc;
    
    .form-box-w {
      width: fit-content;
      padding: 1rem;
      display: flex;
      flex-direction: column;
      gap: 1rem;
    }
  }
}
</style>