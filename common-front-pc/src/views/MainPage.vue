<script setup lang="ts">

import IconLogo from "@/components/icons/IconLogo.vue";
</script>

<template>
  <div class="main-root">
    <div class="main-head">
      <div class="head-logo">
        <IconLogo class="logo"/>
        <h1>JavaExample</h1>
      </div>
    </div>
    <div class="content-box">
      <div class="content-left"></div>
      <div class="content-right"></div>
    </div>
  </div>
</template>

<style scoped>
.main-root {
  display: flex;
  width: 100vw;
  
  .main-head {
    height: 7rem;
    line-height: 7rem;
    
    .head-logo {
      display: flex;
      align-items: center;
      
      .logo {
        margin-left: 3rem;
        width: 4rem;
        height: 4rem;
      }
      
      h1 {
        font-size: 3rem;
        color: var(--theme-color);
        margin-left: 2rem;
      }
    }
  }
}
</style>