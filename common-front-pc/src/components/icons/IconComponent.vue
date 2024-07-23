<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721712209474" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="15014" width="200" height="200">
    <path
        d="M512 117.76l330.24 213.12L512 544.64 181.76 331.52 512 117.76M512 41.6L64 331.52 512 620.8l448-289.92L512 41.6z"
        p-id="15015" :fill="fill"></path>
    <path d="M512 802.56L46.72 503.68l34.56-53.76L512 726.4l430.72-276.48 34.56 53.76L512 802.56z" p-id="15016"
          :fill="fill"></path>
    <path d="M512 985.6L46.72 686.72l34.56-54.4L512 909.44l430.72-277.12 34.56 54.4L512 985.6z" p-id="15017"
          :fill="fill"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>