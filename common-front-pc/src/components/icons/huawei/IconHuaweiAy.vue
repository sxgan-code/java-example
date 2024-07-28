<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="32px" height="32px"
       viewBox="0 0 32 32" version="1.1">
    <title>ic_desktop_windmill</title>
    <defs>
      <rect id="path-1" x="0" y="0" width="32" height="32"/>
      <linearGradient x1="-1.11022302e-14%" y1="50%" x2="100%" y2="50%" id="linearGradient-3">
        <stop stop-color="#000000" offset="0%"/>
        <stop stop-color="#000000" stop-opacity="0.1" offset="100%"/>
      </linearGradient>
      <linearGradient x1="-1.11022302e-14%" y1="50%" x2="100%" y2="50%" id="linearGradient-4">
        <stop stop-color="#000000" stop-opacity="0.1" offset="0%"/>
        <stop stop-color="#000000" offset="100%"/>
      </linearGradient>
    </defs>
    <g id="ic_desktop_windmill" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
      <g id="风车">
        <mask id="mask-2" fill="white">
          <use xlink:href="#path-1"/>
        </mask>
        <g id="蒙版"/>
        <g id="编组-6备份" mask="url(#mask-2)">
          <g transform="translate(2.000000, 3.000000)" id="Rectangle">
            <rect fill="url(#linearGradient-3)"
                  transform="translate(20.000000, 13.500000) rotate(10.000000) translate(-20.000000, -13.500000) "
                  x="13.75" y="3.5" width="12.5" height="20" rx="2"/>
            <rect fill="url(#linearGradient-4)"
                  transform="translate(8.000000, 13.500000) rotate(-10.000000) translate(-8.000000, -13.500000) "
                  x="1.75" y="3.5" width="12.5" height="20" rx="2"/>
            <path
                d="M10.5,0 L17.5,0 C19.709139,0 21.5,1.790861 21.5,4 L21.5,22 C21.5,24.209139 19.709139,26 17.5,26 L10.5,26 C8.290861,26 6.5,24.209139 6.5,22 L6.5,4 C6.5,1.790861 8.290861,0 10.5,0 Z"
                fill="#000000"/>
          </g>
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