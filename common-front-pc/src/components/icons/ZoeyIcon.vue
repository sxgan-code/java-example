<script setup lang="ts">
import {computed} from 'vue'

const props = defineProps({
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
  name: {type: String, default: '', required: true},
  prefix: {type: String, default: 'icon', required: false},
  color: {type: String, default: '#000', required: false},
})

const symbolId = computed(() => `#${props.prefix}-${props.name}`)
</script>

<template>
  <svg aria-hidden="true">
    <use :xlink:href="symbolId" :fill="color"/>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>