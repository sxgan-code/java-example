<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
</script>

<template>
  <div class="title">
    <zoey-title type="h1">Button 按钮</zoey-title>
    <zoey-title type="p">常用的操作按钮。</zoey-title>
    <zoey-title type="h2">基础用法</zoey-title>
    <div class="btn-list">
      <zoey-title type="h4">按钮大小</zoey-title>
      <zoey-button class="btn-item" type="primary" size="small">按钮</zoey-button>
      <zoey-button class="btn-item" type="primary">按钮</zoey-button>
      <zoey-button class="btn-item" type="primary" size="large">按钮</zoey-button>
    </div>
    <div class="btn-list">
      <zoey-title type="h4">按钮类型-普通</zoey-title>
      <zoey-button class="btn-item" type="primary">primary</zoey-button>
      <zoey-button class="btn-item" type="success">success</zoey-button>
      <zoey-button class="btn-item" type="warn">warn</zoey-button>
      <zoey-button class="btn-item" type="error">error</zoey-button>
      <zoey-button class="btn-item" type="default">default</zoey-button>
      <zoey-button class="btn-item" type="default" disabled>disabled default</zoey-button>
    </div>
  </div>
</template>

<style scoped lang="scss">
.title {
  width: 75vw;
  margin: 0 auto;
}

.btn-list {
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  padding: 2rem;
  margin: 0 auto;
  //background: lightcyan;
  .btn-item {
    margin: 2rem 1rem;
  }
}
</style>