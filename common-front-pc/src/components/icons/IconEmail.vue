<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721713415869" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="24122" width="200" height="200">
    <path
        d="M904 176H120c-30.9 0-56 25.1-56 56v560c0 30.9 25.1 56 56 56h784c30.9 0 56-25.1 56-56V232c0-30.9-25.1-56-56-56z m0 56v81.6L522.9 476.8c-6.9 2.9-14.9 3-21.9-0.1L120 313.6V232h784zM120 792V374.5l358.9 153.8c10.6 4.5 21.9 6.8 33.1 6.8 11.3 0 22.6-2.3 33.1-6.8L904 374.5V792H120z"
        p-id="24123" :fill="fill"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>