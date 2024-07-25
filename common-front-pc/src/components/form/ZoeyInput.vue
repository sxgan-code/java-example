<script setup lang="ts">

import {type PropType} from "vue";

let props = defineProps({
  type: {
    type: String as PropType<'text' | 'password' | 'textarea' | 'button' | 'hidden' | 'checkbox' | 'radio' | 'file' | 'date' | 'month' | 'email'>,
    default: "file",
    required: true
  },//类型
  label: {type: String, default: "", required: false},
  value: {type: String, default: "", required: false},
  labelWidth: {type: String, default: "12rem", required: false},
  tips: {type: String, default: "选择您的头像图片进行上传", required: false},//提示
  accept: {type: String, default: "image/png, image/jpeg, image/gif, image/jpg", required: false},//文件限制类型
  width: {type: String, default: '25rem', required: false},//宽度
  height: {type: String, default: '2.6rem', required: false},//高度
  bgColor: {type: String, default: "#5B8FF9", required: false},//背景颜色
  bgActiveColor: {type: String, default: "#3aa9fb", required: false},//背景活动颜色
  textColor: {type: String, default: "#FFFFFF", required: false},//字体颜色
})

const emit = defineEmits<{
  (event: "inputChange", e: any): void,
  (event: "btnClick"): void,
}>()
</script>

<template>
  <div :class="'input-'+type+'-box'">
    <span :class="'input-'+type+'-label'"><slot>{{ label }}</slot></span>
    <input v-if="type!='textarea'" :class="'input-'+type" :type="type" :title="tips" :accept="accept" :value="value"
           @change="emit('inputChange',$event)"
           @click="emit('btnClick')">
    <textarea v-if="type=='textarea'" :class="'input-'+type"/>
  </div>

</template>

<style scoped lang="scss">
/* 文本输入框*/
.input-text-box {
  margin: 0.8rem 1rem;
  display: flex;
  flex-direction: row;
  float: left;
  
  .input-text-label {
    font-family: "HarmonyOS Sans", sans-serif;
    font-weight: bold;
    font-size: 1.4rem;
    text-align: right;
    width: v-bind(labelWidth);
    margin-right: 1rem;
    color: #606266;
    line-height: v-bind(height);
  }
  
  .input-text {
    border: 0.15rem solid #C0C4CC;
    border-radius: 0.3rem;
    width: v-bind(width);
    height: v-bind(height);
    padding: 0 1rem;
    color: #68696D;
    
    &:focus {
      border: 0.15rem solid #409EFF;
    }
  }
}

/* 密码输入框*/
.input-password-box {
  margin: 0.8rem 1rem;
  display: flex;
  flex-direction: row;
  float: left;
  
  .input-password-label {
    font-family: "HarmonyOS Sans", sans-serif;
    font-weight: bold;
    font-size: 1.4rem;
    text-align: right;
    width: v-bind(labelWidth);
    margin-right: 1rem;
    color: #606266;
    line-height: v-bind(height);
  }
  
  .input-password {
    border: 0.15rem solid #C0C4CC;
    border-radius: 0.3rem;
    width: v-bind(width);
    height: v-bind(height);
    padding: 0 1rem;
    color: #68696D;
    
    &:focus {
      border: 0.15rem solid #409EFF;
    }
  }
}

/* 按钮输入框*/
.input-button-box {
  margin: 0.8rem 1rem;
  display: flex;
  flex-direction: row;
  float: left;
  
  .input-button-label {
    font-family: "HarmonyOS Sans", sans-serif;
    font-weight: bold;
    font-size: 1.4rem;
    text-align: right;
    width: v-bind(labelWidth);
    margin-right: 1rem;
    color: #606266;
    line-height: v-bind(height);
  }
  
  .input-button {
    border-radius: 0.3rem;
    width: max-content;
    height: v-bind(height);
    padding: 0 1rem;
    background-color: #ECF5FF;
    border: 0.15rem solid #5B8FF9;
    color: #5B8FF9;
    
    &:hover {
      color: #FFFFFF;
      background-color: #5B8FF9;
    }
    
    &:focus {
      border: 0.15rem solid #409EFF;
    }
  }
}

/* 文件类型改为按钮 */
.input-file-box {
  margin: 0.8rem 1rem;
  transition: all 0.3s;
  float: left;
  width: max-content;
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

/* textarea输入框*/
.input-textarea-box {
  margin: 0.8rem 1rem;
  display: flex;
  flex-direction: row;
  float: left;
  
  .input-textarea-label {
    font-family: "HarmonyOS Sans", sans-serif;
    font-weight: bold;
    font-size: 1.4rem;
    text-align: right;
    width: v-bind(labelWidth);
    margin-right: 1rem;
    color: #606266;
  }
  
  .input-textarea {
    border-radius: 0.3rem;
    width: v-bind(width);
    height: v-bind(height);
    min-width: v-bind(width);
    min-height: v-bind(height);
    padding: 1rem;
    background-color: #FFFFFF;
    border: 0.15rem solid #5B8FF9;
    font-size: 1.6rem;
    color: #68696D;
    
    &:focus {
      border: 0.15rem solid #409EFF;
    }
  }
}

</style>