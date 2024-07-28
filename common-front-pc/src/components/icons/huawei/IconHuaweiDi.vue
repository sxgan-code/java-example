<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24" height="24"
       version="1.1" viewBox="0 0 24 24">
    <defs>
      <path id="uxs-a"
            d="M18.5,5.5 C21.5375661,5.5 24,7.96243388 24,11 C24,12.2594786 23.5766547,13.4200797 22.8644996,14.3472678 L22.762042,14.474203 C21.7279701,15.9982377 19.9809721,17 18,17 L6,17 C4.02736438,17 2.28673775,16.0066514 1.25104744,14.4928815 C0.469389169,13.5427742 0,12.3262029 0,11 C0,7.96243388 2.46243388,5.5 5.5,5.5 L18.5,5.5 Z M18.5787177,7.0007591 L5.5,7 C3.290861,7 1.5,8.790861 1.5,11 C1.5,13.1828397 3.24847526,14.9573012 5.42128233,14.9992409 L5.5,15 L18.5,15 C20.709139,15 22.5,13.209139 22.5,11 C22.5,8.81716027 20.7515247,7.04269883 18.5787177,7.0007591 Z"/>
    </defs>
    <g fill="none" fill-rule="evenodd" stroke="none" stroke-width="1">
      <mask id="uxs-b" fill="#fff">
        <use xlink:href="#uxs-a"/>
      </mask>
      <g fill="#000" fill-opacity=".9" mask="url(#uxs-b)">
        <rect width="24" height="24" x="0" y="0"/>
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