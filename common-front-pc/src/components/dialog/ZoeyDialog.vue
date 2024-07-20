<script lang="ts" setup>
let props = defineProps({
  top: {type: String, default: "50%"},//位置(中心位置)
  mask: {type: Boolean, default: true},//遮罩层(默认开启)
  left: {type: String, default: "50%"},//位置(中心位置)
  width: {type: String, default: ''},//宽度
  height: {type: String, default: ''},//高度
  maskColor: {type: String, default: "rgba(0, 0, 0, .4)"},//遮罩层颜色
  show: {type: Boolean, default: false},//弹框是否显示
  dialogColor: {type: String, default: "rgb(255,255,255)"},//背景色
})
//弹框显示与隐藏
let visible = props.show
const emit = defineEmits<{ (event: "update:modelValue", visible: Boolean): void }>()
const closeDialog = () => emit("update:modelValue", visible)

</script>

<template>
  <div class="modal" v-show="show">
    <div class="modal-mask" v-if="mask" @click="closeDialog"></div>
    <div class="modal-warp">
      <div class="modal-dialog">
        <div class="modal-dialog-close" @click="closeDialog"></div>
        <div class="modal-dialog-title">
          <slot name="title"></slot>
        </div>
        <div class="modal-dialog-content">
          <slot name="content"></slot>
        </div>
        <div class="modal-dialog-footer">
          <slot name="footer"></slot>
        </div>
      </div>
    </div>
  </div>
  <!--    </Teleport>-->
</template>


<style lang="scss" scoped>
.modal {
  position: fixed;
  z-index: 100;
  
  &-mask {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100%;
    background-color: v-bind(maskColor)
  }
  
  &-wrap {
    height: auto;
  }
  
  &-dialog {
    height: v-bind(height);
    width: v-bind(width);
    position: fixed;
    color: #fff;
    top: v-bind(top);
    left: v-bind(left);
    transform: translate(-50%, -50%);
    border-radius: 10px;
    padding: 0 20px;
    background-color: v-bind(dialogColor);
    
    
    &-close {
      position: absolute;
      top: 12px;
      right: 22px;
      width: 0;
      height: 0;
      z-index: 15;
      
      cursor: pointer;
      transition: width 0.6s;
      
      &:hover {
        &:before, &:after {
          background: #0E8E89;
        }
      }
      
      &:before, &:after {
        content: "";
        display: inline-block;
        position: absolute;
        top: 0;
        right: 0;
        width: 2px;
        height: 22px;
        background-color: #333333;
        transform: rotate(-45deg);
      }
      
      &:after {
        transform: rotate(45deg);
      }
    }
    
    &-title {
      line-height: 22px;
      font-size: 16px;
      font-weight: bold;
      text-align: left;
      color: #409EFF;
    }
    
    &-content {
      display: flex;
      width: 50rem;
      height: 50rem;
      background: #000;
      //padding: 20px;
    }
    
    &-footer {
      //border-top: 1px solid rgba(255, 255, 255, 0.2);
      display: flex;
      justify-content: space-around;
      align-items: center;
      //padding: 20px;
    }
  }
}
</style>