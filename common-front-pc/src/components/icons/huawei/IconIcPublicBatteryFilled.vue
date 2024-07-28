<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
       viewBox="0 0 24 24" version="1.1">
    <title>Public/ic_public_battery_filled</title>
    <defs>
      <path
          d="M18,5.75 C19.6568542,5.75 21,7.09314575 21,8.75 L21,15.25 C21,16.9068542 19.6568542,18.25 18,18.25 L4,18.25 C2.34314575,18.25 1,16.9068542 1,15.25 L1,8.75 C1,7.09314575 2.34314575,5.75 4,5.75 L18,5.75 Z M23,9 C23.5522847,9 24,9.44771525 24,10 L24,14 C24,14.5522847 23.5522847,15 23,15 C22.4477153,15 22,14.5522847 22,14 L22,10 C22,9.44771525 22.4477153,9 23,9 Z"
          id="path-1"/>
    </defs>
    <g id="Public/ic_public_battery_filled" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
      <mask id="mask-2" fill="white">
        <use xlink:href="#path-1"/>
      </mask>
      <use id="Combined-Shape" fill="#000000" xlink:href="#path-1"/>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>