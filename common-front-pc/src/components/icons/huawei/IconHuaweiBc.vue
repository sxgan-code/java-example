<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="20px" height="20px"
       viewBox="0 0 20 20" version="1.1">
    <title>Devices/Battery/ic_device_battery_earphone_left</title>
    <defs>
      <path
          d="M10,1.25 C14.8324916,1.25 18.75,5.16750844 18.75,10 C18.75,14.8324916 14.8324916,18.75 10,18.75 C5.16750844,18.75 1.25,14.8324916 1.25,10 C1.25,5.16750844 5.16750844,1.25 10,1.25 Z M9.112,5.33028571 L8.032,5.33028571 L8.032,14.1502857 L13.564,14.1502857 L13.564,13.1662857 L9.112,13.1662857 L9.112,5.33028571 Z"
          id="path-1"/>
    </defs>
    <g id="Devices/Battery/ic_device_battery_earphone_left" stroke="none" stroke-width="1" fill="none"
       fill-rule="evenodd">
      <mask id="mask-2" fill="white">
        <use xlink:href="#path-1"/>
      </mask>
      <use id="形状" fill="#000000" xlink:href="#path-1"/>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>