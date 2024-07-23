<script setup lang="ts">
const props = defineProps({
  height: {type: String, default: '1.4rem', required: false},
  bgColor: {type: String, default: '#F0F9EB', required: false},
  textColor: {type: String, default: '#5B8FF9', required: false},
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
  margin: 0 0.3rem;
  padding: 0.4rem 1rem;
  color: v-bind(textColor);
  line-height: v-bind(height);
}
</style>