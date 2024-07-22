<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721480297248" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="23263" width="200" height="200">
    <path
        d="M755.712 307.2H268.288a243.712 243.712 0 0 0 0 487.424h487.424a243.712 243.712 0 0 0 0-487.424z m-487.424 436.224A195.072 195.072 0 1 1 460.8 548.352a195.072 195.072 0 0 1-192.512 195.072z"
        :fill="fill" p-id="23264"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>