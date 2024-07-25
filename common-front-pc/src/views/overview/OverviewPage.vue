<script setup lang="ts">
import * as echarts from 'echarts';
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import {onMounted, ref} from "vue";
import ZoeyCard from "@/components/data/ZoeyCard.vue";

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
      <zoey-card>
        <div ref="itemOneRef" class="overview-root-box-item"></div>
      </zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
      <zoey-card></zoey-card>
    
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
    
  }
}
</style>