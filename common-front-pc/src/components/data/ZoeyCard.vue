<script setup lang="ts">

const props = defineProps({
  width: {type: String, default: '40rem', required: false},
  height: {type: String, default: '20rem', required: false}
})
</script>

<template>
  <div class="card-box">
    <slot></slot>
  </div>
</template>

<style scoped lang="scss">
.card-box {
  width: v-bind(width);
  height: v-bind(height);
  padding: 2rem;
  margin: 1rem;
  font-family: "HarmonyOS Sans", sans-serif;
  font-size: 1.8rem;
  box-shadow: 0.2rem 0.2rem 0.8rem #cccccc, -0.2rem -0.2rem 0.8rem #cccccc;
  
  &:hover {
    box-shadow: 0.4rem 0.4rem 0.8rem #cccccc, -0.4rem -0.4rem 0.8rem #cccccc;
  }
}
</style>