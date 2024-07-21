<script setup lang="ts">
let props = defineProps({
  type: {type: String, default: "file"},//类型
  tips: {type: String, default: "选择您的头像图片进行上传"},//提示
  accept: {type: String, default: "image/png, image/jpeg, image/gif, image/jpg"},//文件限制类型
  width: {type: String, default: ''},//宽度
  height: {type: String, default: ''},//高度
  bgColor: {type: String, default: "#5B8FF9"},//背景颜色
  bgActiveColor: {type: String, default: "#3aa9fb"},//背景活动颜色
  textColor: {type: String, default: "#FFFFFF"},//字体颜色
})

const emit = defineEmits<{ (event: "handleFileChange", e: any): void }>()
</script>

<template>
    <span class="inputBtn">
    <span><slot></slot></span>
    <input id="myImg" name="myImg" class="inputFile" :type="type" :title="tips" :accept="accept"
           @change="emit('handleFileChange',$event)">
    </span>
</template>

<style scoped lang="scss">
.inputBtn {
  transition: all 0.3s;
  padding: 0 1.5rem;
  border-radius: 0.4rem;
  font-family: "HarmonyOS Sans", sans-serif;
  position: relative;
  line-height: 3rem;
  background-color: v-bind(bgColor);
  color: v-bind(textColor);
  cursor: pointer;
  font-size: 1.4rem;
}

.inputBtn:hover {
  background-color: v-bind(bgActiveColor);
}

.inputFile {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  filter: alpha(opacity=0);
}

</style>