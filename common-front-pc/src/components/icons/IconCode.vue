<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})
</script>

<template>
  <svg t="1721311658549" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="7019" width="200" height="200">
    <path
        d="M246.72 327.296c-12.032-12.032-31.424-12.032-43.456 0L9.024 521.344c-12.032 11.968-12.032 31.36 0 43.392l194.304 194.048c12.032 11.968 31.424 11.968 43.456 0 12.032-12.032 12.032-31.36 0-43.392L74.112 543.04l172.608-172.416C258.752 358.656 258.752 339.264 246.72 327.296zM954.368 521.344l-194.304-194.048c-12.032-12.032-31.488-12.032-43.456 0-12.032 11.968-12.032 31.36 0 43.328l172.608 172.416-172.608 172.352c-12.032 12.032-12.032 31.36 0 43.392 11.968 11.968 31.424 11.968 43.456 0l194.304-194.048C966.4 552.768 966.4 533.312 954.368 521.344zM689.664 132.608c-15.296-8.96-34.88-3.648-43.712 11.84l-384 766.848c-8.896 15.424-3.648 35.2 11.712 44.032 15.296 8.96 34.88 3.648 43.776-11.84l383.936-766.848C710.272 161.28 705.024 141.504 689.664 132.608z"
        p-id="7020"></path>
  </svg>
</template>

<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>