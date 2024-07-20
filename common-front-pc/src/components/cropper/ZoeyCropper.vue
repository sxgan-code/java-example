<script setup lang="ts">
import 'vue-cropper/dist/index.css'
import {VueCropper} from "vue-cropper";

import {ref} from 'vue';

const cropper = ref(null);
const show = ref(true);
const fixed = ref(false);
const fixedNumber = ref([75, 34]);

const option = ref({
  img: 'https://avatars2.githubusercontent.com/u/15681693?s=460&v=4',
  size: 1,
  full: false,
  outputType: 'png',
  canMove: true,
  fixedBox: false,
  original: false,
  canMoveBox: true,
  autoCrop: true,
  // 只有自动截图开启 宽度高度才生效
  autoCropWidth: 400,
  autoCropHeight: 400,
  centerBox: false,
  high: true,
  max: 99999,
})

const realTime = () => {
  console.log('实时预览')
}
const cropMoving = () => {
  console.log('移动中')
}
const imgLoad = () => {
  console.log('图片加载中')
}
</script>
<template>
  <div class="cropper">
    <vue-cropper ref="cropper"
                 img="https://avatars2.githubusercontent.com/u/15681693?s=460&v=4"
                 :output-size="option.size"
                 :output-type="option.outputType"
                 :info="true"
                 :full="option.full"
                 :fixed="fixed"
                 :fixed-number="fixedNumber"
                 :can-move="option.canMove"
                 :can-move-box="option.canMoveBox"
                 :fixed-box="option.fixedBox"
                 :original="option.original"
                 :auto-crop="option.autoCrop"
                 :auto-crop-width="option.autoCropWidth"
                 :auto-crop-height="option.autoCropHeight"
                 :center-box="option.centerBox"
                 :max-img-size="option.max"
                 :high="option.high"
                 mode="cover"
                 @real-time="realTime"
                 @img-load="imgLoad"
                 @crop-moving="cropMoving"
    ></vue-cropper>
    <button @click="show = !show">显示/隐藏</button>
  </div>

</template>

<style lang="scss" scoped>
.cropper {
  width: 40rem;
  height: 40rem;
}
</style>