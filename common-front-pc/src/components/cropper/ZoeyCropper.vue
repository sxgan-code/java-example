<script setup lang="ts">
import './index.css'


import {ref} from 'vue';
import ZCropper from "@/components/cropper/z-cropper.vue";
import message from "@/components/message";
import ZoeyButton from "@/components/btn/ZoeyButton.vue";
import ZoeyInput from "@/components/form/ZoeyInput.vue";
import IconAdd from "@/components/icons/IconAdd.vue";
import IconSub from "@/components/icons/IconSub.vue";
import IconRotateLeft from "@/components/icons/IconRotateLeft.vue";
import IconRotateRight from "@/components/icons/IconRotateRight.vue";

const cropper: any = ref(null);
const show = ref(true);
const fixed = ref(true);
const fixedNumber = ref([1, 1]);
/* 父组件触发事件 */
const emit = defineEmits<{ (event: "upload:logofile", data: any): void }>()


/* 组件数据 */
const previews = ref({
  w: 0,
  h: 0,
  div: '',
  url: '',
  img: ''
});

const option = ref({
  img: '/github/backgroud/2016991.jpg',
  size: 2,
  full: false,
  outputType: 'png',
  canMove: true,
  fixedBox: false,
  original: true,
  canMoveBox: true,
  autoCrop: true,
  // 只有自动截图开启 宽度高度才生效
  autoCropWidth: 200,
  autoCropHeight: 200,
  centerBox: true,
  high: true,
  max: 600,
})

const cropMoving = () => {
  console.log('移动中')
}
const imgLoad = () => {
  console.log('图片加载中')
}
/**
 * 上传图
 * @param e
 */
const uploadImg = (e: any) => {
  //上传图片
  // this.option.img
  var file = e.target.files[0];
  if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(e.target.value)) {
    message.warning('图片类型必须是.gif,jpeg,jpg,png,bmp中的一种');
    return false;
  }
  var reader = new FileReader();
  reader.onload = (e) => {
    let data: any;
    if (typeof e.target!.result === 'object' && e.target?.result != null) {
      // 把Array Buffer转化为blob 如果是base64不需要
      data = window.URL.createObjectURL(new Blob([e.target.result]));
    } else {
      data = e.target?.result;
    }
    option.value.img = data;
  };
  // 转化为base64
  // reader.readAsDataURL(file)
  // 转化为blob
  reader.readAsArrayBuffer(file);
}
/**
 * 实时预览
 * @param data
 */
const previewData = ref()
const realTime = (data: any) => {
  console.log('上面是', data);
  cropper.value.getCropBlob((data: Blob) => {
    console.log('这里是', data);
    var img = window.URL.createObjectURL(data);
    // this.model = true;
    previewData.value = img;
  });
}
/**
 * 更改大小
 * @param num
 */
const changeScale = (num: number) => {
  num = num || 1;
  cropper.value.changeScale(num);
}
/**
 * 旋转图片
 * @param isLeft
 */
const rotateImg = (isLeft: boolean) => {
  if (isLeft) {
    cropper.value.rotateLeft();
  } else {
    cropper.value.rotateRight();
  }
}
/**
 * 刷新
 */
const refreshCrop = () => {
  // refresh
  cropper.value.refresh();
}
const clearCrop = () => {
  // clear
  cropper.value.clearCrop();
}
/**
 * 生成截图
 * @param type
 */
const modelImgData = ref()
const getCropper = (type: string): any => {
  // 输出
  // var test = window.open('about:blank')
  // test.document.body.innerHTML = '图片生成中..'
  if (type === 'blob') {
    cropper.value.getCropBlob((data: Blob) => {
      console.log('这里是', data);
      var img = window.URL.createObjectURL(data);
      // this.model = true;
      modelImgData.value = img;
      emit('upload:logofile', data)
    });
  } else {
    cropper.getCropData((data: any) => {
      // this.model = true;
      modelImgData.value = data;
    });
  }
  console.log(modelImgData.value)
}
</script>
<template>
  <div class="cropper-root">
    <div class="cropper-root-cut">
      <z-cropper
          class="cropper-root-cut-cropper"
          ref="cropper"
          :img="option.img"
          :auto-crop="option.autoCrop"
          :auto-crop-height="option.autoCropHeight"
          :auto-crop-width="option.autoCropWidth"
          :fixed="fixed"
          :center-box="option.centerBox"
          :fixed-number="fixedNumber"
          :fixed-box="option.fixedBox"
          @real-time="realTime"
          @img-load="imgLoad"
          @crop-moving="cropMoving"
      ></z-cropper>
      <div class="show-preview" :style="{'overflow': 'hidden', 'margin': '5px','border-radius':'10rem'}">
        <div style="width: 20rem;height: 20rem">
          <img :src="previewData">
        </div>
      </div>
    </div>
    <div class="cropper-root-ctrl">
      <zoey-input class="zoey-input" type="file" @input-change="uploadImg">
        更换图片
      </zoey-input>
      <zoey-button logo type="default" @click="changeScale(1)">
        <icon-add fill="#7DAAFF"/>
      </zoey-button>
      <zoey-button logo type="default" @click="changeScale(-1)">
        <icon-sub fill="#7DAAFF"/>
      </zoey-button>
      <zoey-button logo type="default" @click="rotateImg(true)">
        <icon-rotate-left fill="#f759ab"/>
      </zoey-button>
      <zoey-button logo type="default" @click="rotateImg(false)">
        <icon-rotate-right fill="#f759ab"/>
      </zoey-button>
      <zoey-button type="warn" @click="refreshCrop()">重置</zoey-button>
      <zoey-button type="success" @click="getCropper('blob')">确定</zoey-button>
    </div>
  
  </div>

</template>

<style lang="scss" scoped>
.cropper-root {
  .cropper-root-cut {
    display: flex;
    
    .cropper-root-cut-cropper {
      width: 25rem;
      height: 25rem;
      margin-right: 10rem;
    }
    
    .show-preview {
      width: 20rem;
      height: 20rem;
      
      img {
        width: 20rem;
        height: 20rem;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        border-radius: 10rem;
      }
    }
    
  }
  
  .cropper-root-ctrl {
    width: 50rem;
    display: flex;
    flex-wrap: wrap;
    
    .zoey-input {
      margin: 1rem;
    }
    
    button {
      margin: 1rem;
    }
    
  }
}


</style>