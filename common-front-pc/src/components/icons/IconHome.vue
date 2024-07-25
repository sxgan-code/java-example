<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721897402339" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="2452" width="200" height="200">
    <path
        d="M1017.3952 622.848l-452.0448-499.6096A71.2704 71.2704 0 0 0 512 99.1744c-20.3264 0-39.2704 8.5504-53.3504 24.064L6.6048 622.848a25.6 25.6 0 0 0 37.9392 34.304l109.0048-120.4736V947.2c0 42.3424 34.4576 76.8 76.8 76.8h563.2c42.3424 0 76.8-34.4576 76.8-76.8v-410.5216l109.0048 120.4736a25.5488 25.5488 0 1 0 37.9392-34.3552zM614.4 972.8H409.6v-230.4a25.6 25.6 0 0 1 25.6-25.6h153.6a25.6 25.6 0 0 1 25.6 25.6V972.8z m204.8-25.6a25.6 25.6 0 0 1-25.6 25.6H665.6v-230.4c0-42.3424-34.4576-76.8-76.8-76.8h-153.6c-42.3424 0-76.8 34.4576-76.8 76.8V972.8H230.4a25.6 25.6 0 0 1-25.6-25.6V480.1024l291.84-322.56c4.1984-4.6592 9.6768-7.2192 15.36-7.2192s11.1616 2.56 15.36 7.2192l291.84 322.56V947.2z"
        :fill="fill" p-id="2453"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>