<script setup lang="ts">
import * as echarts from 'echarts';
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import {onMounted, ref} from "vue";

const itemOneRef = ref(null)
const itemOneData = {
  series: [
    {
      type: 'pie',
      data: [
        {
          value: 1,
          name: 'Java案例'
        },
        {
          value: 6,
          name: '组件'
        },
        {
          value: 1,
          name: 'CSS案例'
        }
      ]
    }
  ]
};
onMounted(() => {
  const eChartsType = echarts.init(itemOneRef.value, null, {
    width: 400,
    height: 200
  });
  eChartsType.setOption(itemOneData)
})
</script>

<template>
  <div class="overview-root">
    <zoey-title type="h1" hr>Overview 预览</zoey-title>
    <zoey-title type="h3">该系统案例统计</zoey-title>
    <div class="overview-root-box">
      <div ref="itemOneRef" class="overview-root-box-item"></div>
      <div class="overview-root-box-item"></div>
      <div class="overview-root-box-item"></div>
      <div class="overview-root-box-item"></div>
      <div class="overview-root-box-item"></div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.overview-root {
  width: 83vw;
  margin: 5rem auto;
  
  &-box {
    width: 83vw;
    display: flex;
    flex-wrap: wrap;
    
    &-item {
      width: 50rem;
      height: 20rem;
      margin: 2rem;
      display: flex;
      justify-content: center;
      box-shadow: 0.2rem 0.2rem 0.8rem #cccccc, -0.2rem -0.2rem 0.8rem #cccccc;
      
      &:hover {
        box-shadow: 0.4rem 0.4rem 0.8rem #cccccc, -0.4rem -0.4rem 0.8rem #cccccc;
      }
    }
  }
}
</style>