<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import HgCode from "@/components/codelight/HgCode.vue";
</script>

<template>
  <div class="flex-root">
    <zoey-title type="h1">Flex 布局</zoey-title>
    
    <zoey-title type="h3">父元素设置子元素布局</zoey-title>
    <hg-code code="
.flex-parent-box-1 {
  background: lightblue;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 100rem;
  .child-item-1 {
    background: lavender;
    width: 10rem;
    height: 10rem;
    margin: 5rem 5rem;
  }
}" lang="css"/>
    <zoey-title type="h4">
      示例1：父元素宽度为100rem(根元素大小为10px,100rem =
      1000px)，子元素宽度为10rem，外边框为5rem，故子元素共有20rem，一行最多5个(需设置flex-wrap)
    </zoey-title>
    <div class="flex-parent-box-1">
      <div class="child-item-1" v-for="i in 20">{{ i }}</div>
    </div>
    
    <zoey-title type="h3">子元素设置自身布局</zoey-title>
    <hg-code code="
.flex-parent-box-2 {
  background: lightblue;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 100rem;
  margin: 0 auto;
  .first-item {
    flex: 1;
  }
  .child-item-2 {
    flex: 2;
    background: lavender;
    height: 10rem;
    border: 0.1rem solid #cccccc;
  }
}" lang="css"/>
    <zoey-title type="h4">
      示例2：子元素设置flex值，表示所占份数，所有设置为1则子元素等分父元素宽度，以下三个div比例设置为1:2:2<br>
      注意：css的顺序后面的会覆盖前面的
    </zoey-title>
    <div class="flex-parent-box-2">
      <div class="child-item-2 first-item">1</div>
      <div class="child-item-2">2</div>
      <div class="child-item-2">3</div>
    </div>
  </div>

</template>

<style scoped lang="scss">
.flex-root {
  width: 83vw;
  margin: 0 auto;
  overflow-y: auto;
  padding: 5rem 0 20rem;
  
  .flex-parent-box-1 {
    background: lightblue;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    width: 100rem;
    margin: 0 auto;
    
    .child-item-1 {
      background: lavender;
      width: 10rem;
      height: 10rem;
      margin: 5rem 5rem;
    }
  }
  
  .flex-parent-box-2 {
    background: lightblue;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    width: 100rem;
    margin: 0 auto;
    
    .child-item-2 {
      flex: 2;
      background: lavender;
      height: 10rem;
      margin: 1rem 2rem;
      border: 0.1rem solid #cccccc;
    }
    
    .first-item {
      flex: 1;
    }
    
    
  }
}
</style>