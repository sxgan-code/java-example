<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
import ZoeyDialog from "@/components/dialog/ZoeyDialog.vue";
import {ref} from "vue";

const show = ref(false);

const dialogShow = () => {
  show.value = !show.value;
}

</script>

<template>
  <div class="dialog">
    <zoey-title type="h1" hr>Dialog 对话框</zoey-title>
    <zoey-title type="h3">该组件通过按钮弹出对话框，用法如下：</zoey-title>
    <div class="dialog-box">
      <zoey-button @click="dialogShow" type="primary">click to open the Dialog</zoey-button>
      <zoey-dialog :show="show" @update:modelValue="dialogShow">
        <template #title>
          <zoey-title type="h3" hr>Dialog Title</zoey-title>
        </template>
        <template #content>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
          <h1>This is Dialog Content</h1>
        </template>
      </zoey-dialog>
    </div>
  </div>
</template>

<style scoped lang="scss">
.dialog {
  width: 83vw;
  margin: 5rem auto;
  
  .dialog-box {
    width: 83vw;
  }
}
</style>