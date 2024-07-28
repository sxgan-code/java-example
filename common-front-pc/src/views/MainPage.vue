<script setup lang="ts">
import {onMounted, ref} from "vue";
import {Expand, Fold, Location} from "@element-plus/icons-vue";
import {useRouter} from 'vue-router';
import {goToHref, HrefTypeEnum} from "@/utils/common-utils.ts";
import IconQr from "@/components/icons/IconQr.vue";
import IconButton from "@/components/icons/IconButton.vue";
import IconLayout from "@/components/icons/IconLayout.vue";
import IconImgCut from "@/components/icons/IconImgCut.vue";
import IconTips from "@/components/icons/IconTips.vue";
import IconDialog from "@/components/icons/IconDialog.vue";
import IconJava from "@/components/icons/IconJava.vue";
import IconJavaLogo from "@/components/icons/IconJavaLogo.vue";
import IconComponent from "@/components/icons/IconComponent.vue";
import IconCss from "@/components/icons/IconCss.vue";
import IconHome from "@/components/icons/IconHome.vue";
import IconCard from "@/components/icons/IconCard.vue";
import IconForm from "@/components/icons/IconForm.vue";
import IconFrontEnd from "@/components/icons/IconFrontEnd.vue";
import IconEchartsPie from "@/components/icons/IconEchartsPie.vue";

const router = useRouter()
const isCollapse = ref(false)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
onMounted(() => {
  console.log('router', router.currentRoute.value.path);
})
</script>

<template>
  <div class="main-root">
    <div class="main-head">
      <div class="head-logo">
        <icon-java-logo width="4rem" height="4rem" style="margin-left: 3rem"/>
        <h1>JavaExample</h1>
      </div>
    </div>
    <div class="content-box">
      <div class="content-left">
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            @open="handleOpen"
            @close="handleClose"
            text-color="#fff"
            background-color="var(--grey-color-5)"
        >
          <el-sub-menu index="0" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/main/overview/')">
            <template #title>
              <icon-home style="margin-right: 1rem;"/>
              <span>预览</span>
            </template>
          </el-sub-menu>
          <el-sub-menu index="1">
            <template #title>
              <icon-java style="margin-right: 1rem;"/>
              <span>Java案例</span>
            </template>
            <el-sub-menu class="two-title" index="1-1">
              <template #title><span>工具类案例</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/java/utils/qr')"
                            index="1-1-1">
                <IconQr style="margin-right: 1rem;"/>
                QR 二维码生成
              </el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <icon-component style="margin-right: 1rem;"/>
              <span>自定义组件</span>
            </template>
            <el-sub-menu class="two-title" index="1-2">
              <template #title><span>Basic 基础组件</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/basic/btn')"
                            index="1-2-1">
                <icon-button style="margin-right: 1rem;"/>
                Button 按钮
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/basic/layout')"
                            index="1-2-2">
                <icon-layout style="margin-right: 1rem"/>
                layout 布局
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/basic/icons')"
                            index="1-2-3">
                <icon-layout style="margin-right: 1rem"/>
                Icons 图标
              </el-menu-item>
            </el-sub-menu>
            <el-sub-menu class="two-title" index="1-3">
              <template #title><span>Feedback 反馈组件</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/feedback/message')"
                            index="1-3-1">
                <icon-tips style="margin-right: 1rem;"/>
                Message 消息提示
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/feedback/dialog')"
                            index="1-3-2">
                <icon-dialog style="margin-right: 1rem;"/>
                Dialog 对话框
              </el-menu-item>
            </el-sub-menu>
            <el-sub-menu class="two-title" index="1-4">
              <template #title><span>Data 数据展示</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/data/avatar')"
                            index="1-4-1">
                <icon-img-cut style="margin-right: 1rem;"/>
                Copper 截取
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/data/card')"
                            index="1-4-2">
                <icon-card style="margin-right: 1rem;"/>
                Card 卡片
              </el-menu-item>
            </el-sub-menu>
            <el-sub-menu class="two-title" index="1-5">
              <template #title><span>Form 表单组件</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/form/formtable')"
                            index="1-5-1">
                <icon-form style="margin-right: 1rem;"/>
                Form 表单
              </el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <icon-css style="margin-right: 1rem;"/>
              <span>CSS案例</span>
            </template>
            <el-sub-menu class="two-title" index="3-1">
              <template #title>
                <span>布局案例</span>
              </template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/component/basic/layout')"
                            index="3-1-1">
                <icon-layout style="margin-right: 1rem;"/>
                布局1
              </el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="4">
            <template #title>
              <icon-front-end style="margin-right: 1rem;"/>
              <span>前端案例</span>
            </template>
            <el-sub-menu class="two-title" index="4-1">
              <template #title>
                <span>Echarts</span>
              </template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/front/echarts')"
                            index="4-1-1">
                <icon-echarts-pie style="margin-right: 1rem;"/>
                Echarts 图表大全
              </el-menu-item>
            </el-sub-menu>
            <el-sub-menu class="two-title" index="4-2">
              <template #title>
                <span>富文本</span>
              </template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/front/editor')"
                            index="4-2-1">
                <icon-echarts-pie style="margin-right: 1rem;"/>
                Editor 富文本
              </el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="5">
            <template #title>
              <el-icon>
                <location/>
              </el-icon>
              <span>测试菜单</span>
            </template>
            <el-menu-item-group>
              <template #title><span>分组1</span></template>
              <el-menu-item index="5-1">元素1</el-menu-item>
              <el-menu-item index="5-2">元素2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="5-3">元素3</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="5-4">
              <template #title><span>元素4</span></template>
              <el-menu-item index="5-4-1">元素4的子元素</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
        </el-menu>
      </div>
      <div class="content-right">
        <div class="menu-tabs">
          <el-radio-group class="telescopic-button" v-model="isCollapse" style="margin-bottom: 20px">
            <el-radio-button v-if="isCollapse" :value="false">
              <el-icon>
                <Expand/>
              </el-icon>
              展开
            </el-radio-button>
            <el-radio-button v-if="!isCollapse" :value="true">
              <el-icon>
                <Fold/>
              </el-icon>
              收缩
            </el-radio-button>
          </el-radio-group>
        </div>
        <div class="main-content">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.main-root {
  display: flex;
  flex-direction: column;
  width: 100vw;
  font-family: "造字工坊纤细", sans-serif;
  
  .main-head {
    height: 7rem;
    line-height: 7rem;
    width: 100%;
    //background: var(--softness-group-4);
    background: #CC99CC;
    box-shadow: 0.1rem 0.1rem 0.3rem #ccc;
    
    .head-logo {
      display: flex;
      align-items: center;
      
      .logo {
        margin-left: 3rem;
        width: 4rem;
        height: 4rem;
      }
      
      h1 {
        font-size: 3rem;
        //color: var(--geek-blue-color-5);
        color: #FFFFFF;
        margin-left: 2rem;
      }
    }
  }
  
  .content-box {
    width: 100vw;
    display: flex;
    
    .content-left {
      font-family: "造字工坊纤细", sans-serif;
      font-weight: bold;
      background: var(--grey-color-5);
      height: 100vh;
      overflow-y: auto;
      
      .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 17vw;
        overflow-x: auto;
        
        .two-title, .three-title {
          background: var(--grey-color-6);
        }
        
        .two-title:hover, .three-title:hover {
          background: var(--dark-color-9);
        }
      }
    }
    
    .content-right {
      width: 100vw;
      height: calc(100vh - 7rem);
      
      .menu-tabs {
        height: 4rem;
        box-shadow: 1rem 1rem 1rem #0000001a;
        
        .telescopic-button {
          line-height: 4rem;
          margin-left: 1rem;
        }
      }
      
      .main-content {
        height: calc(100vh - 11rem);
        overflow-y: auto;
      }
    }
  }
}
</style>