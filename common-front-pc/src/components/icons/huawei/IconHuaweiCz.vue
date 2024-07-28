<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px"
       viewBox="0 0 24 24" version="1.1">
    <title>Artboard</title>
    <g id="Artboard" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" opacity="0.86">
      <g id="Group" transform="translate(2.500000, 11.500000)" fill="#000000" fill-rule="nonzero">
        <g id="Path">
          <polygon points="19 0 19 1 0 1 0 0"/>
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