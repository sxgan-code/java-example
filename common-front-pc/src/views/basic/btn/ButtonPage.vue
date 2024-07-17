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
      <zoey-button class="btn-item" type="primary" size="medium">primary medium</zoey-button>
      <zoey-button class="btn-item" type="success" size="medium">success medium</zoey-button>
      <zoey-button class="btn-item" type="warn" size="medium">warn medium</zoey-button>
      <zoey-button class="btn-item" type="error" size="medium">error medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
      <zoey-button class="btn-item" type="default" size="medium">default medium</zoey-button>
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