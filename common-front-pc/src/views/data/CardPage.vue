<script setup lang="ts">

import ZoeyCard from "@/components/data/ZoeyCard.vue";
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
</script>

<template>
  <div class="card-root">
    <zoey-title type="h1" hr>Card 卡片</zoey-title>
    <zoey-title type="h3">卡片的基础用法如下：</zoey-title>
    <div class="card-root-box">
      <zoey-card>这是一个卡片1</zoey-card>
      <zoey-card>这是一个卡片2</zoey-card>
      <zoey-card>这是一个卡片3</zoey-card>
      <zoey-card>这是一个卡片4</zoey-card>
    </div>
  </div>
</template>

<style scoped lang="scss">
.card-root {
  width: 83vw;
  margin: 5rem auto;
  
  &-box {
    display: flex;
  }
}
</style>