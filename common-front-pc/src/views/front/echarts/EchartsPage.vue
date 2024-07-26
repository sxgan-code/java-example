<script setup lang="ts">
import * as echarts from 'echarts';
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import {onMounted, ref} from "vue";
import ZoeyCard from "@/components/data/ZoeyCard.vue";
import {
  histogramData,
  multiColumnHistogramData,
  nightingaleData,
  pieData,
  polylineData,
  regionAreaData,
  ringData,
  scatterPointData,
  stackedPolylineData
} from "@/views/front/echarts/echarts-data.ts";

const pieRef = ref(null)
const histogramRef = ref(null)
const multiColumnHistogramRef = ref(null)
const polylineRef = ref(null)
const ringRef = ref(null)
const nightingaleRef = ref(null)
const scatterPointRef = ref(null)
const regionAreaRef = ref(null)
const stackedPolylineRef = ref(null)

onMounted(() => {
  const eChartsType = echarts.init(pieRef.value, null, {
    width: 400,
    height: 200
  });
  eChartsType.setOption(pieData)
  const histogramType = echarts.init(histogramRef.value, null, {
    width: 400,
    height: 250
  });
  histogramType.setOption(histogramData)
  
  const multiColumnHistogramType = echarts.init(multiColumnHistogramRef.value, null, {
    width: 400,
    height: 250
  });
  multiColumnHistogramType.setOption(multiColumnHistogramData)
  
  const polylineType = echarts.init(polylineRef.value, null, {
    width: 400,
    height: 250
  });
  polylineType.setOption(polylineData)
  
  const ringType = echarts.init(ringRef.value, null, {
    width: 400,
    height: 250
  });
  ringType.setOption(ringData)
  
  const nightingaleType = echarts.init(nightingaleRef.value, null, {
    width: 400,
    height: 200
  });
  nightingaleType.setOption(nightingaleData)
  
  const scatterPointType = echarts.init(scatterPointRef.value, null, {
    width: 400,
    height: 200
  });
  scatterPointType.setOption(scatterPointData)
  
  const regionAreaType = echarts.init(regionAreaRef.value, null, {
    width: 400,
    height: 200
  });
  regionAreaType.setOption(regionAreaData)
  
  const stackedPolylineType = echarts.init(stackedPolylineRef.value, null, {
    width: 400,
    height: 200
  });
  stackedPolylineType.setOption(stackedPolylineData)
})


</script>

<template>
  <div class="overview-root">
    <zoey-title type="h1" hr>Echarts 图表预览</zoey-title>
    <zoey-title type="h3">Echarts全案例预览</zoey-title>
    <div class="overview-root-box">
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">饼图：</span>
        <div ref="pieRef"></div>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">柱状图：</span>
        <div ref="histogramRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">多列柱状图：</span>
        <div ref="multiColumnHistogramRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">折线图：</span>
        <div ref="polylineRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">圆环图：</span>
        <div ref="ringRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">南丁格尔图：</span>
        <div ref="nightingaleRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">散点图：</span>
        <div ref="scatterPointRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">区域面积图：</span>
        <div ref="regionAreaRef"/>
      </zoey-card>
      <zoey-card width="35vw" height="20rem" class="item">
        <span style="float: left">堆叠折线图：</span>
        <div ref="stackedPolylineRef"/>
      </zoey-card>
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
    
    .item {
      display: flex;
    }
  }
}
</style>