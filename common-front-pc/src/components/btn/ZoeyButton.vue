<script setup lang="ts">

import type {PropType} from "vue";

const props = defineProps({
  type: {
    type: String as PropType<'primary' | 'error' | 'success' | 'warn' | 'info' | 'default'>,
    default: 'primary',
    required: true
  },
  size: {
    type: String as PropType<'small' | 'medium' | 'large'>,
    default: 'medium',
    required: false
  }
})
</script>

<template>
  <button :class="'zoey-button but-'+props.size+' but-'+props.type">
    <slot></slot>
  </button>
</template>

<style scoped lang="scss">
.zoey-button {
  line-height: 2rem;
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.3s;
  padding: 1rem 1.6rem;
  border-radius: 0.4rem;
}

.but-primary {
  background-color: #5B8FF9;
  color: #FFFFFF;
  
  &:hover {
    background-color: #3375B9;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.but-success {
  background-color: #73d13d;
  color: #FFFFFF;
  
  &:hover {
    background-color: #389e0d;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.but-error {
  background-color: #ff7875;
  color: #FFFFFF;
  
  &:hover {
    background-color: #f5222d;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.but-warn {
  background-color: #E6A23C;
  color: #FFFFFF;
  
  &:hover {
    background-color: #A77730;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.but-default {
  background-color: #FFF;
  border: 0.1rem solid #cccccc;
  color: #333333;
  
  &:hover {
    background-color: #ECF5FF;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

/*按钮大小*/
.but-small {
  font-size: 1.2rem;
}

.but-medium {
  font-size: 1.4rem;
}

.but-large {
  font-size: 1.8rem;
}
</style>