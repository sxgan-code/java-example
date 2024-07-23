<script setup lang="ts">
const props = defineProps({
  height: {type: String, default: '1.4rem', required: false},
  bgColor: {type: String, default: '#595a5d', required: false},
  textColor: {type: String, default: '#0DD47F', required: false},
})
</script>

<template>
  <span class="z-code"><slot></slot></span>
</template>

<style scoped lang="scss">
.z-code {
  height: v-bind(height);
  border-radius: 0.3rem;
  background: v-bind(bgColor);
  font-size: 1.4rem;
  margin: 0 1rem;
  padding: 0.4rem 1rem;
  color: v-bind(textColor);
  line-height: v-bind(height);
}
</style>