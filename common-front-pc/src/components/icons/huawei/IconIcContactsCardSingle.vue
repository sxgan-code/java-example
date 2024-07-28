<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
       viewBox="0 0 24 24" version="1.1">
    <title>ic_contacts_card_single</title>
    <defs>
      <path
          d="M15.014,1 L21,6.985 L21,19 C21,21.209139 19.209139,23 17,23 L7,23 C4.790861,23 3,21.209139 3,19 L3,5 C3,2.790861 4.790861,1 7,1 L15.014,1 Z"
          id="path-1"/>
    </defs>
    <g id="ic_contacts_card_single" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
      <mask id="mask-2" fill="white">
        <use xlink:href="#path-1"/>
      </mask>
      <use id="Combined-Shape" fill="#000000" fill-rule="nonzero" xlink:href="#path-1"/>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>