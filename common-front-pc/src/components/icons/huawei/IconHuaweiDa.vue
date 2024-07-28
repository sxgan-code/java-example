<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="32px" height="32px"
       viewBox="0 0 32 32" version="1.1">
    <title>ic_desktop_squeeze</title>
    <defs>
      <rect id="path-1" x="0" y="0" width="32" height="32"/>
      <linearGradient x1="-1.11022302e-14%" y1="50%" x2="100%" y2="50%" id="linearGradient-3">
        <stop stop-color="#000000" offset="0%"/>
        <stop stop-color="#000000" stop-opacity="0.1" offset="100%"/>
      </linearGradient>
    </defs>
    <g id="ic_desktop_squeeze" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
      <mask id="mask-2" fill="white">
        <use xlink:href="#path-1"/>
      </mask>
      <g id="蒙版"/>
      <g id="推压" mask="url(#mask-2)">
        <g transform="translate(3.000000, 3.000000)">
          <path
              d="M21.0039179,0 L26,0 L26,26 L21.0039179,26 C18.7947789,26 17.0039179,24.209139 17.0039179,22 L17.0039179,4 C17.0039179,1.790861 18.7947789,0 21.0039179,0 Z"
              id="Mask" fill="url(#linearGradient-3)"/>
          <path
              d="M4,0 L11,0 C13.209139,0 15,1.790861 15,4 L15,22 C15,24.209139 13.209139,26 11,26 L4,26 C1.790861,26 0,24.209139 0,22 L0,4 C0,1.790861 1.790861,0 4,0 Z"
              id="Rectangle" fill="#000000"/>
        </g>
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