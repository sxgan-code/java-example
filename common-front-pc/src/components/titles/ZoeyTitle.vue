<script setup lang="ts">

const props = defineProps<{
  type: 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6' | 'p',
}>()

</script>

<template>
  <div class="zoey-title-root">
    <span :class="'size-'+props.type+' title-common'"><slot></slot></span>
  </div>
  <hr v-if="props.type==='h1'">
</template>

<style scoped lang="scss">
.zoey-title-root {
  width: 100%;
}

.title-common {
  //font-family: 'HarmonyOS Sans', sans-serif;
  font-weight: 700;
  margin-left: 2rem;
  color: #606266;
}

hr {
  color: #606266;
  border: 0;
  height: 1px;
  background-image: linear-gradient(to right, rgba(33, 33, 33, 1), rgba(33, 33, 33, 0.1), rgba(33, 33, 33, 1));
  margin: 0 auto;
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