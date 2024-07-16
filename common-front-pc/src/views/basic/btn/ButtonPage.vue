<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
</script>

<template>
  <div class="title">
    <zoey-title type="h1">Button 按钮</zoey-title>
    <zoey-title type="p">常用的操作按钮。</zoey-title>
    <zoey-title type="h2">基础用法</zoey-title>
    <div>
      <zoey-button type="primary" size="small">
        默认按钮
      </zoey-button>
    </div>
  </div>
</template>

<style scoped lang="scss">
.title {
  width: 100%;
}
</style>