<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721480829334" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="29927" width="200" height="200">
    <path
        d="M715.98 634.01h80.07V308.02c0-21.61-7.94-40.35-23.83-56.24-15.89-15.89-34.63-23.83-56.24-23.83H389.99v80.07h325.99v325.99z m-407.96 81.97V64h-80.07v163.95H64v80.07h163.95v407.97c0 21.6 7.94 40.35 23.83 56.24 15.89 15.89 34.63 23.83 56.24 23.83h407.97V960h80.07V796.05H960v-80.07H308.02z"
        p-id="29928" :fill="fill"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>