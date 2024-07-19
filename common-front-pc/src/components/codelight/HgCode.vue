<script setup lang="ts">


import {copyToClipboard} from "@/utils/common-utils.ts";
import {CopyDocument} from "@element-plus/icons-vue";
import {BackgroundTypeEnum} from "@/components/tips/tooltip.ts";
import IconCode from "@/components/icons/IconCode.vue";

const props = defineProps({
  lang: {
    type: String,
    default: 'js'
  },
  code: {
    type: String,
    default: ''
  }
})
</script>

<template>
  <div class="code-root-box">
    <div class="code-head">
      <div class="head-left">
        <div class="flag"></div>
        <div class="flag"></div>
        <div class="flag"></div>
      </div>
      <div class="head-right">
        <div class="code-copy">
          <el-icon v-tip="{text:'点击复制',bg:BackgroundTypeEnum.black}" @click="copyToClipboard(props.code);">
            <CopyDocument/>
          </el-icon>
        </div>
      </div>
    </div>
    <div class="code-box">
      <highlightjs
          autodetect="autodetect"
          :language="props.lang"
          :code="props.code"
      />
      <div class="code-lang">
        <div>
          <div class="code-icon">
            <IconCode style="width: 1.3rem;height: 1.3rem;"/>
          </div>
          <div class="code-lang-text"><span>{{ props.lang }}</span></div>
        </div>
      </div>
    </div>
  
  </div>
</template>
<style lang="scss">
.code-root-box {
  width: 98%;
  margin: 2rem auto;
  font-size: 1.6rem;
  font-family: "HarmonyOS Sans Bold", sans-serif;
  
  .code-head {
    background: #f89898;
    border-top-left-radius: 1rem;
    border-top-right-radius: 1rem;
    display: flex;
    justify-content: space-between;
    
    .head-left {
      width: 20rm;
      display: flex;
      margin-left: 1rem;
      
      .flag {
        margin: 0.4rem;
        width: 1rem;
        height: 1rem;
        background: #000;
        border-radius: 1rem;
      }
      
      .flag:nth-child(1) {
        background: #FC625D;
      }
      
      .flag:nth-child(2) {
        background: #FDBC40;
      }
      
      .flag:nth-child(3) {
        background: #35CD4B;
      }
    }
    
    .head-right {
      margin-right: 1rem;
      
      i {
        font-size: 1.3rem;
        color: cornsilk;
      }
      
      i:hover {
        color: #a0cfff;
      }
    }
  }
  
  .code-box {
    font-size: 1.4rem;
    text-align: left;
    user-select: auto;
    
    .hljs {
      border-bottom-left-radius: 1rem;
      border-bottom-right-radius: 1rem;
      padding-bottom: 2rem;
      box-shadow: 0.2rem 0.2rem 0.4rem rgba(0, 0, 0, 0.15);
      font-family: "JetBrainsMono Bold", sans-serif;
      overflow: auto;
      user-select: text;
      
      span {
        user-select: text;
        line-height: 1.4rem;
      }
      
    }
    
    .code-lang {
      max-width: 12rem;
      height: 2rem;
      margin: 0.5rem 0 0 auto;
      text-align: center;
      box-shadow: 0.2rem 0.2rem 0.4rem rgba(0, 0, 0, 0.15), -2px -2px 5px rgba(0, 0, 0, 0.15);
      border-radius: 0.5rem;
      font-family: 'JetBrainsMono Bold Italic', sans-serif;
      color: #f89898;
      
      div {
        max-width: 14rem;
        display: flex;
        
        .code-icon {
          padding: 0.5rem 0 0 2rem;
          width: 4rem;
          text-align: center;
          font-size: 1.1rem;
        }
        
        .code-lang-text {
          width: 10rem;
          font-size: 1.2rem;
          margin: 0.1rem 0;
          padding-right: 1rem;
          
          span {
            margin: 0 auto;
          }
        }
      }
      
    }
  }
  
}
</style>