<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
</script>

<template>
  <div class="flex-root">
    <zoey-title type="h1">Flex 布局</zoey-title>
    <div class="flex-parent-box">
      <div class="child-item" v-for="i in 20">{{ i }}</div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.flex-root {
  width: 75vw;
  margin: 0 auto;
  
  .flex-parent-box {
    width: 100%;
    display: flex;
    flex-direction: column;
    background: lightblue;
    
    .child-item {
      width: 10rem;
      height: 10rem;
      border: 0.1rem solid #cccccc;
      background: lavender;
    }
  }
}
</style>