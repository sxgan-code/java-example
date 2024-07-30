<script setup lang="ts">
import ZoeyIcon from "@/components/icons/ZoeyIcon.vue";
import ids from 'virtual:svg-icons-names'
import {copyToClipboard} from "@/utils/common-utils.ts";
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";

const copy = (name: string) => {
  var text = `<zoey-icon name="` + name + `"/>`;
  copyToClipboard(text)
}
</script>

<template>
  <div class="svg-root">
    <zoey-title type="h1" hr>图标</zoey-title>
    <zoey-title type="h3">点击以下图标即可复制</zoey-title>
    <div v-for="name in ids" class="icon-item" :key="name" @click="copy(name.substring(5))">
      <zoey-icon :name="name.substring(5)" color="#000"/>
      <span>{{ name.substring(5) }}</span>
    </div>
  </div>
</template>

<style scoped lang="scss">
.svg-root {
  width: 83vw;
  margin: 5rem auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  align-items: center;
  
  .icon-item {
    width: 15rem;
    height: 15rem;
    margin: 1rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    box-shadow: 0.2rem 0.2rem 0.2rem #cccccc, -0.2rem -0.2rem 0.2rem #cccccc;
    
    
    span, svg {
      overflow: hidden;
      font-family: "HarmonyOS Sans", sans-serif;
      margin: 0.4rem auto;
    }
    
    svg {
      width: 5rem;
      height: 5rem;
    }
    
    span {
      color: #9c9c9c;
      font-size: 1.4rem;
      width: 12rem;
      margin: 0 auto;
      overflow: hidden;
    }
  }
}
</style>