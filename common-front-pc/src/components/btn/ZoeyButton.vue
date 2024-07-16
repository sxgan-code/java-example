<script setup lang="ts">
const props = defineProps<{
  type: 'primary' | 'error' | 'success' | 'warn' | 'info' | 'default',
  size: 'small' | 'medium' | 'large',
}>()

</script>

<template>
  <button :class="'zoey-button but-'+props.size+' but-'+props.type">
    <slot></slot>
  </button>
</template>

<style scoped lang="scss">
.zoey-button {
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.3s;
  
}

.but-primary {
  background-color: #5B8FF9;
  color: #FFFFFF;
  
  &:hover {
    background-color: #f5f5f5;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.but-small {
  border-radius: 4px;
  padding: 8px 16px;
  font-size: 14px;
}
</style>