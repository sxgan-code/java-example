<script setup lang="ts">

import type {PropType} from "vue";

const props = defineProps({
  type: {
    type: String as PropType<'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'p'>,
    default: 'h1'
  },
  hr: Boolean, // 是否显示分割线
})

</script>

<template>
  <div class="zoey-title-root">
    <span :class="'size-'+props.type+' title-common'"><slot></slot></span>
  </div>
  <hr v-if="hr">
</template>

<style scoped lang="scss">
.zoey-title-root {
  width: 100%;
}

.title-common {
  font-weight: 700;
  color: #606266;
}

hr {
  color: #606266;
  border: 0;
  height: 1px;
  background-image: linear-gradient(to right, rgba(#FFCCCC, 0.4), rgba(#FF99CC, 0.7), rgba(#CCCCFF, 0.4));
  margin: 1rem auto 2rem;
  width: 98%;
}

.size-h1 {
  font-size: 3rem;
  line-height: 5rem;
}

.size-h2 {
  font-size: 2.6rem;
  line-height: 6rem;
}

.size-h3 {
  font-size: 2.2rem;
  line-height: 6rem;
}

.size-h4 {
  font-size: 1.8rem;
  line-height: 6rem;
  color: #cccccc;
}

.size-h5 {
  font-size: 1.4rem;
  line-height: 6rem;
}

.size-h6 {
  font-size: 1.2rem;
  line-height: 6rem;
}

.size-p {
  font-size: 1.8rem;
  line-height: 6rem;
}

</style>