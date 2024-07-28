<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" version="1.1" viewBox="0 0 24 24">
    <defs>
      <filter id="uxs-a">
        <feColorMatrix in="SourceGraphic" type="matrix"
                       values="0 0 0 0 0.000000 0 0 0 0 0.000000 0 0 0 0 0.000000 0 0 0 1.000000 0"/>
      </filter>
    </defs>
    <g fill="#000" fill-rule="evenodd" stroke="none" stroke-width="1.5" filter="url(#uxs-a)" opacity=".86">
      <rect width="16.5" height="16.5" x="3.75" y="3.75" fill="none" stroke="#FFF" rx="1.5"/>
      <rect width="4.527" height="4.527" x="12.75" y="6.779" fill="none" stroke="#FFF" rx="1.5"/>
      <rect width="4.527" height="4.527" x="6.736" y="12.806" fill="none" stroke="#FFF" rx="1.5"/>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>