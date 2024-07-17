<script setup lang="ts">
import {onMounted, ref} from "vue";
import IconLogo from "@/components/icons/IconLogo.vue";
import {Expand, Fold, Grid, Location, Open} from "@element-plus/icons-vue";
import {useRouter} from 'vue-router';
import {goToHref, HrefTypeEnum} from "@/utils/common-utils.ts";

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
        <IconLogo class="logo"/>
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
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <Grid/>
              </el-icon>
              <span>自定义组件</span>
            </template>
            <el-sub-menu class="" index="1-1">
              <template #title class="two-title">
                <span>组件总览</span></template>
            </el-sub-menu>
            <el-sub-menu class="two-title" index="1-2">
              <template #title><span>Basic 基础组件</span></template>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/main/btn')" index="1-2-1">
                <el-icon>
                  <Open/>
                </el-icon>
                Button 按钮
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/main/btn')" index="1-2-1">
                Button 按钮
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/main/btn')" index="1-2-1">
                Button 按钮
              </el-menu-item>
              <el-menu-item class="two-title" @click="goToHref(HrefTypeEnum.LOCAL_HREF,'/main/btn')" index="1-2-1">
                Button 按钮
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
        <div class=""></div>
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">
          <el-radio-button v-if="isCollapse" :value="false">
            <el-icon>
              <Expand/>
            </el-icon>
          </el-radio-button>
          <el-radio-button v-if="!isCollapse" :value="true">
            <el-icon>
              <Fold/>
            </el-icon>
          </el-radio-button>
        </el-radio-group>
        <router-view/>
      </div>
    </div>
  </div>
</template>

<style scoped>
.main-root {
  display: flex;
  flex-direction: column;
  width: 100vw;
  font-family: "造字工坊纤细", sans-serif;
  
  .main-head {
    height: 7rem;
    line-height: 7rem;
    width: 100%;
    background: var(--softness-group-4);
    
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
        color: var(--geek-blue-color-5);
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
      //background: lavender;
      .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 14vw;
        
        .two-title, .three-title {
          background: var(--grey-color-6);
        }
        
        .two-title:hover, .three-title:hover {
          background: var(--dark-color-9);
        }
      }
    }
    
    .content-right {
      //background: lawngreen;
      width: 100vw;
    }
  }
}
</style>