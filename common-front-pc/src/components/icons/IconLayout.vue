<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721480409384" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="24485" width="200" height="200">
    <path d="M102.569562 249.588475l275.269367 0 0 606.820576-275.269367 0 0-606.820576Z" :fill="fill"
          p-id="24486"></path>
    <path d="M405.468197 249.588475l512.676405 0 0 275.269367-512.676405 0 0-275.269367Z" :fill="fill"
          p-id="24487"></path>
    <path d="M405.468197 551.463804l242.523569 0 0 304.945247-242.523569 0 0-304.945247Z" :fill="fill"
          p-id="24488"></path>
    <path d="M675.621033 551.463804l242.523569 0 0 304.945247-242.523569 0 0-304.945247Z" :fill="fill"
          p-id="24489"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>