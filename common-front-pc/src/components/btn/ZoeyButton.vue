<script setup lang="ts">

import {onMounted, type PropType, ref} from "vue";

const props = defineProps({
  type: {
    type: String as PropType<'primary' | 'error' | 'success' | 'warn' | 'info' | 'default'>,
    default: 'primary',
    required: true
  },
  size: {
    type: String as PropType<'small' | 'default' | 'large'>,
    default: 'default',
    required: false
  },
  logo: {type: Boolean, default: false, required: false},
  bgColor: {type: String, default: '#FFFFFF', required: false},
  h: {type: String, default: '3rem', required: false}
})
const classVal = ref<string>('')
onMounted(() => {
  if (props.logo) {
    classVal.value = 'icon-button icon-type-' + props.type + ' btn-icon-' + props.size
  } else {
    classVal.value = 'zoey-button btn-size-' + props.size + ' btn-' + props.type
  }
})
</script>

<template>
  <button :class="classVal">
    <slot></slot>
  </button>
</template>

<style scoped lang="scss">
/* 文字按钮样式 */
.zoey-button {
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.3s;
  padding: 0 1.5rem;
  border-radius: 0.4rem;
  display: flex;
  align-items: center
}

.btn-primary {
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

.btn-success {
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

.btn-error {
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

.btn-warn {
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

.btn-info {
  background-color: #909399;
  color: #FFFFFF;
  
  &:hover {
    background-color: #B1B3B8;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.btn-default {
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
.btn-size-small {
  height: 2.2rem;
  font-size: 1.2rem;
}

.btn-size-default {
  height: 3.2rem;
  font-size: 1.4rem;
}

.btn-size-large {
  height: 4rem;
  font-size: 1.4rem;
}

/* 以下为图标样式*/
.icon-button {
  display: flex;
  align-items: center;
  border: none;
  justify-content: space-around;
}

/*logo样式*/
.icon-type-primary {
  background-color: #5B8FF9;
  
  &:hover {
    background-color: #3375B9;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.icon-type-success {
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

.icon-type-error {
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

.icon-type-warn {
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

.icon-type-info {
  background-color: #909399;
  color: #FFFFFF;
  
  &:hover {
    background-color: #B1B3B8;
  }
  
  &:disabled {
    cursor: not-allowed;
    opacity: 0.6;
  }
}

.icon-type-default {
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

/*图标按钮大小*/
.btn-icon-small {
  width: 2.2rem;
  height: 2.2rem;
  border-radius: 1.1rem;
}

.btn-icon-default {
  width: 3.2rem;
  height: 3.2rem;
  border-radius: 1.8rem;
}

.btn-icon-large {
  width: 4rem;
  height: 4rem;
  border-radius: 2rem;
}
</style>