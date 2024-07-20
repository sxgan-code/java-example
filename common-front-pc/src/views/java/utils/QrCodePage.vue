<script setup lang="ts">
import ZoeyTitle from "@/components/titles/ZoeyTitle.vue";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
import {getDefaultQrCodeApi, getLogoQrCodeApi} from "@/api/java/qr.ts";
import {onMounted, ref} from "vue";
import message, {PositionTypeEnum} from "@/components/message";
import ZoeyCropper from "@/components/cropper/ZoeyCropper.vue";

const imgStream = ref()
const imgLogoStream = ref()
const getDefaultQr = (isFirst: boolean) => {
  console.log('生成二维码')
  getDefaultQrCodeApi().then((res: any) => {
    var blob = new Blob([res.data], {type: 'image/png'});
    imgStream.value = window.URL.createObjectURL(blob)
    if (!isFirst) {
      message.success('二维码生成成功', PositionTypeEnum.TOP)
    }
  }).catch(err => {
    message.success('系统错误', PositionTypeEnum.TOP)
    console.log(err)
  })
}

const getLogoQrCode = (isFirst: boolean) => {
  console.log('生成二维码')
  getLogoQrCodeApi().then((res: any) => {
    var blob = new Blob([res.data], {type: 'image/png'});
    imgStream.value = window.URL.createObjectURL(blob)
    if (!isFirst) {
      message.success('二维码生成成功', PositionTypeEnum.TOP)
    }
  }).catch(err => {
    message.success('系统错误', PositionTypeEnum.TOP)
    console.log(err)
  })
}
const imageSrc = ref('')

const handleImageChange = async (e) => {
  const file = e.target.files[0]
  imageSrc.value = file
}

const handleCrop = async () => {
  console.log('裁剪完成')
}


onMounted(() => getDefaultQr(true))
</script>

<template>
  <div class="qr-root">
    <zoey-title type="h1" hr>二维码生成</zoey-title>
    <zoey-title type="h2">点击按钮生成不同类型的黑白二维码：</zoey-title>
    <div class="default-qr">
      <div class="qr-btn">
        <zoey-button type="primary" size="default" @click="getDefaultQr(false)">生成二维码</zoey-button>
        <zoey-button type="primary" size="default" @click="getLogoQrCode(false)">生成Logo二维码</zoey-button>
      </div>
      <img :src="imgStream" alt="">
    </div>
    <zoey-title type="h2">截取图片上传生成二维码：</zoey-title>
    <div class="default-qr">
      <div class="qr-btn">
        <zoey-cropper/>
        <input type="file" @change="handleImageChange"/>
        <!--<button @click="submitCroppedImage">上传裁剪图片</button>-->
        <zoey-button type="primary" size="default" @click="getDefaultQr(false)">生成二维码</zoey-button>
      </div>
      <img :src="imgLogoStream" alt="">
    </div>
  </div>

</template>

<style scoped lang="scss">
.qr-root {
  width: 83vw;
  margin: 5rem auto;
  
  .default-qr {
    display: flex;
    width: 83vw;
    
    .qr-btn {
      display: flex;
      flex-direction: column;
      
      button {
        margin: 1rem 0;
      }
    }
    
    img {
      width: 30rem;
      height: 30rem;
      margin: 1rem auto;
    }
    
  }
}
</style>