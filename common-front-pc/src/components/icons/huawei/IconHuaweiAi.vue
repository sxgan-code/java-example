<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" width="28" height="60" version="1.1" viewBox="0 0 28 60">
    <g fill="#000" fill-rule="nonzero" stroke="none" stroke-width="1" transform="rotate(-90 27.5 25.5)">
      <polygon points="9.1 5.9 24.6 5.9 24.6 .2 45.7 11.6 30.3 11.6 30.3 17.1"/>
      <polygon points="0 16.4 10.1 16.4 10.1 12.7 23.9 20.1 13.7 20.1 13.7 23.8"/>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>