<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721712577982" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="18386" width="200" height="200">
    <path
        d="M754.688 249.344L443.904 563.2l56.832 56.832L814.08 307.2z m-367.616 427.52h84.992l-84.992-84.992z m85.504 56.832H330.24v-141.824L716.8 209.408a55.808 55.808 0 0 1 78.848 0l59.392 59.392a55.808 55.808 0 0 1 0 79.36z m341.504 142.336H244.736A56.832 56.832 0 0 1 187.904 819.2V250.368a56.832 56.832 0 0 1 56.832-56.832h364.544l-57.344 56.832h-307.2V819.2h568.832v-307.2L870.4 455.168V819.2a56.832 56.832 0 0 1-56.832 56.832z"
        :fill="fill" p-id="18387"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>