<script setup lang="ts">

import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
import HgCode from "@/components/codelight/HgCode.vue";
import IconButton from "@/components/icons/IconButton.vue";
import IconSuccess from "@/components/icons/IconSuccess.vue";
import IconEdit from "@/components/icons/IconEdit.vue";
import IconEmail from "@/components/icons/IconEmail.vue";
import IconCollect from "@/components/icons/IconCollect.vue";
import IconDelete from "@/components/icons/IconDelete.vue";
import IconSearch from "@/components/icons/IconSearch.vue";
import Zcode from "@/components/code/zcode.vue";
/* 按钮大小模版 */
const sizeCode = `
<zoey-button class="btn-item" type="primary" size="small">按钮</zoey-button>
<zoey-button class="btn-item" type="primary">按钮</zoey-button>
<zoey-button class="btn-item" type="primary" size="large">按钮</zoey-button>`

/* 按钮类型模版 */
const btnTypeCode = `
<zoey-button class="btn-item" type="primary">primary</zoey-button>
<zoey-button class="btn-item" type="success">success</zoey-button>
<zoey-button class="btn-item" type="warn">warn</zoey-button>
<zoey-button class="btn-item" type="error">error</zoey-button>
<zoey-button class="btn-item" type="default">default</zoey-button>
<zoey-button class="btn-item" type="default" disabled>disabled default</zoey-button>`
/* 带图标类型 */
const btnIconTypeCode = `
<zoey-button class="btn-item" type="primary">
  <icon-button style="margin-right: 1rem;"></icon-button>
  开关
</zoey-button>
<zoey-button class="btn-item" type="success">
  <icon-success style="margin-right: 1rem;"></icon-success>
  success
</zoey-button>
<zoey-button logo type="success" class="btn-item">
  <icon-success fill="#FFF"></icon-success>
</zoey-button>
<zoey-button logo type="primary" class="btn-item">
  <icon-edit fill="#FFF"></icon-edit>
</zoey-button>
<zoey-button logo type="info" class="btn-item">
  <icon-email fill="#FFF"></icon-email>
</zoey-button>
<zoey-button logo type="warn" class="btn-item">
  <icon-collect fill="#FFF"></icon-collect>
</zoey-button>
<zoey-button logo type="error" class="btn-item">
  <icon-delete fill="#FFF"></icon-delete>
</zoey-button>
<zoey-button logo type="default" class="btn-item">
  <icon-search fill="#CCC"></icon-search>
</zoey-button>`
</script>

<template>
  <div class="title">
    <zoey-title type="h1" hr>Button 按钮</zoey-title>
    <zoey-title type="p">常用的操作按钮。</zoey-title>
    <zoey-title type="h2">基础用法</zoey-title>
    <zoey-title type="h4">按钮大小</zoey-title>
    <div class="btn-list">
      <zoey-button class="btn-item" type="primary" size="small">按钮</zoey-button>
      <zoey-button class="btn-item" type="primary">按钮</zoey-button>
      <zoey-button class="btn-item" type="primary" size="large">按钮</zoey-button>
    </div>
    <hg-code :code="sizeCode" lang="html"/>
    
    <zoey-title type="h4">按钮类型-普通</zoey-title>
    <div class="btn-list">
      <zoey-button class="btn-item" type="primary">primary</zoey-button>
      <zoey-button class="btn-item" type="success">success</zoey-button>
      <zoey-button class="btn-item" type="warn">warn</zoey-button>
      <zoey-button class="btn-item" type="error">error</zoey-button>
      <zoey-button class="btn-item" type="info">info</zoey-button>
      <zoey-button class="btn-item" type="default">default</zoey-button>
      <zoey-button class="btn-item" type="default" disabled>disabled default</zoey-button>
    </div>
    <hg-code :code="btnTypeCode" lang="html"/>
    
    <zoey-title type="h4">按钮类型-带图标</zoey-title>
    <zoey-title type="h5">可内嵌图标，当使用纯图标按钮时只需导入图标并在按钮组件添加
      <zcode>logo</zcode>
      属性即可
    </zoey-title>
    <div class="btn-list">
      <zoey-button class="btn-item" type="primary">
        <icon-button style="margin-right: 1rem;"></icon-button>
        开关
      </zoey-button>
      <zoey-button class="btn-item" type="success">
        <icon-success style="margin-right: 1rem;"></icon-success>
        success
      </zoey-button>
      <zoey-button logo type="success" class="btn-item">
        <icon-success fill="#FFF"></icon-success>
      </zoey-button>
      <zoey-button logo type="primary" class="btn-item">
        <icon-edit fill="#FFF"></icon-edit>
      </zoey-button>
      <zoey-button logo type="info" class="btn-item">
        <icon-email fill="#FFF"></icon-email>
      </zoey-button>
      <zoey-button logo type="warn" class="btn-item">
        <icon-collect fill="#FFF"></icon-collect>
      </zoey-button>
      <zoey-button logo type="error" class="btn-item">
        <icon-delete fill="#FFF"></icon-delete>
      </zoey-button>
      <zoey-button logo type="default" class="btn-item">
        <icon-search fill="#CCC"></icon-search>
      </zoey-button>
    </div>
    <hg-code :code="btnIconTypeCode" lang="html"/>
  </div>
</template>

<style scoped lang="scss">
.title {
  width: 83vw;
  margin: 5rem auto;
}

.btn-list {
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  padding: 2rem;
  margin: 0 auto;
  //background: lightcyan;
  .btn-item {
    margin: 4rem 1rem;
  }
}
</style>