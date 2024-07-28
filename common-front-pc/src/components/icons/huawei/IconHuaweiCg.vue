<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
       viewBox="0 0 24 24" version="1.1">
    <title>ic_power_off</title>
    <g id="ic_power_off" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
      <g id="icon">
        <polygon id="Fill-1" points="0 24 24 24 24 0 0 0"/>
        <line x1="12" y1="2.8" x2="12" y2="11.2" id="Stroke-8" stroke="#000000" stroke-width="1.6"
              stroke-linecap="round"/>
        <path
            d="M7.40058,4.03354 C4.65118,5.62434 2.79998,8.59514 2.79998,11.99994 C2.79998,17.08094 6.91898,21.19994 11.99998,21.19994 C17.08098,21.19994 21.19998,17.08094 21.19998,11.99994 C21.19998,8.59514 19.34878,5.62434 16.59938,4.03354"
            id="Stroke-10" stroke="#000000" stroke-width="1.6" stroke-linecap="round"/>
      </g>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>