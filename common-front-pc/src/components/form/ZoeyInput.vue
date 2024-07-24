<script setup lang="ts">

import type {PropType} from "vue";

let props = defineProps({
  type: {
    type: String as PropType<'text' | 'password' | 'button' | 'hidden' | 'checkbox' | 'radio' | 'file' | 'date' | 'month' | 'email'>,
    default: "file",
    required: true
  },//类型
  label: {type: String, default: "", required: false},
  tips: {type: String, default: "选择您的头像图片进行上传"},//提示
  accept: {type: String, default: "image/png, image/jpeg, image/gif, image/jpg"},//文件限制类型
  width: {type: String, default: '20rem'},//宽度
  height: {type: String, default: '3rem'},//高度
  bgColor: {type: String, default: "#5B8FF9"},//背景颜色
  bgActiveColor: {type: String, default: "#3aa9fb"},//背景活动颜色
  textColor: {type: String, default: "#FFFFFF"},//字体颜色
})

const emit = defineEmits<{ (event: "inputChange", e: any): void }>()
</script>

<template>
  <div :class="'input-'+type+'-box'">
    <span :class="'input-'+type+'-label'"><slot>{{ label }}</slot></span>
    <input :class="'input-'+type" :type="type" :title="tips" :accept="accept"
           @change="emit('inputChange',$event)">
  </div>
</template>

<style scoped lang="scss">
.input-text-box {
  //float: left;
  margin: 0.8rem 1rem;
  display: flex;
  flex-direction: row;
  float: left;
  
  .input-text-label {
    font-family: "HarmonyOS Sans", sans-serif;
    font-size: 1.8rem;
    margin: 0 1rem 0 2rem;
    color: #6D6F73;
    line-height: v-bind(height);
  }
  
  .input-text {
    width: v-bind(width);
    height: v-bind(height);
  }
}

/* 文件类型改为按钮 */
.input-file-box {
  transition: all 0.3s;
  float: left;
  width: max-content;
  margin: 1rem;
  padding: 0 1.5rem;
  border-radius: 0.4rem;
  font-family: "HarmonyOS Sans", sans-serif;
  position: relative;
  line-height: 3rem;
  background-color: v-bind(bgColor);
  color: v-bind(textColor);
  cursor: pointer;
  font-size: 1.4rem;
  
  &:hover {
    background-color: v-bind(bgActiveColor);
  }
  
  .input-file {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    opacity: 0;
    filter: alpha(opacity=0);
  }
}


</style>