<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {ref} from 'vue'
import {sendMailVerifyCode, signinApi, signupApi} from "@/api/auth/index.ts"
//控制注册与登录表单的显示， 默认显示注册
const isRegister = ref(false)
const loading = ref(false)

// 定义注册数据模型
const registerData = ref({
  email: '',
  password: '',
  rePassword: '',
  verifyCode: ''
})
// 校验注册数据
const checkRePassword = (rule, value, callback) => {
  console.log(value)
  console.log(registerData.value.rePassword)
  if (value === '') {
    callback(new Error('请再次确认密码'))
  } else if (value !== registerData.value.password) {
    callback(new Error('请确保两次输入的密码相同'))
  } else {
    callback()
  }
}
const rules = {
  email: [
    {required: true, message: '请输入用户邮箱', trigger: 'blur'},
    {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'],}
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 5, max: 16, message: '长度为5~16位非空字符', trigger: 'blur'}
  ],
  rePassword: [
    {required: true, message: '请输入确认密码', trigger: 'blur'},
    {validator: checkRePassword, trigger: 'blur'}
  ],
  verifyCode: [
    {required: true, message: '请输入验证码', trigger: 'blur'},
    {min: 8, max: 8, type: 'string', message: '长度为8位非空字符', trigger: 'blur'}
  ]
}
// 登录注册相关逻辑

// 获取form表单引用
const form = ref(null)
const verifyCode = ref(null)
const verifyImg = ref('http://localhost:9090/auth/verifyCodeImg')
// 当点击登录按钮时的函数
const getVerifyCodeImg = () => {
  verifyImg.value.src = 'http://localhost:9090/auth/verifyCodeImg?time=' + new Date().getTime()
}
const signinSys = () => {
  form.value.validate((isValid, invalidFields) => {
    if (isValid) {
      // 表单所有元素验证通过，可以提交了
      console.log('登录')
      loading.value = true
      signinApi(registerData.value).then(res => {
        console.log(res)
        loading.value = false
      }).catch(err => {
        console.log(err)
        
      })
    }
    
  })
}

const sendVerify = async () => {
  form.value.validateField(['email'], isValid => {
    if (isValid) {
      sendMailVerifyCode(registerData.value).then(res => {
        console.log(res)
      }).catch(err => {
        console.log(err)
      })
    } else {
      console.log('formError表单填写有误，请核对！')
      return false
    }
  })
  
}

const signupSys = async () => {
  form.value.validate((isValid, invalidFields) => {
    if (isValid) {
      // 表单所有元素验证通过，可以提交了
      loading.value = true
      signupApi(registerData.value).then(res => {
        console.log(res)
        loading.value = false
      }).catch(err => {
        console.log(err)
      })
    } else {
    
    }
  })
}

const cleanCacheData = () => {
  registerData.value = {
    email: '',
    password: '',
    rePassword: '',
    verifyCode: ''
  }
}

</script>

<template>
  <el-row class="login-page" v-loading="loading">
    <el-col :span="12" class="bg"></el-col>
    <el-col :span="6" :offset="3" class="form">
      <!-- 注册表单 -->
      <el-form ref="form" size="large" style="width: 400px" autocomplete="off" v-if="isRegister" :model="registerData"
               :rules='rules'>
        <el-form-item>
          <h1>注册</h1>
        </el-form-item>
        <el-form-item prop="email">
          <el-input :prefix-icon="User" placeholder="请输入邮箱"
                    v-model="registerData.email"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input :prefix-icon="Lock" type="password" placeholder="请输入密码"
                    v-model="registerData.password"></el-input>
        </el-form-item>
        <el-form-item prop="rePassword">
          <el-input :prefix-icon="Lock" type="password" placeholder="请输入再次密码"
                    v-model="registerData.rePassword"></el-input>
        </el-form-item>
        <el-form-item prop="verifyCode">
          <el-input style="width: 250px; margin-right: 10px;" v-model="registerData.verifyCode"
                    placeholder="请输入验证码"/>
          <el-button type="primary" @click="sendVerify">获取验证码</el-button>
        </el-form-item>
        <!-- 注册按钮 -->
        <el-form-item>
          <el-button class="button" type="primary" auto-insert-space @click="signupSys">
            注册
          </el-button>
        </el-form-item>
        <el-form-item class="flex">
          <el-link type="info" :underline="false" @click="isRegister = false;cleanCacheData()">
            ← 返回
          </el-link>
        </el-form-item>
      </el-form>
      <!-- 登录表单 -->
      <el-form ref="form" style="width: 400px" size="large" autocomplete="off" v-else :model="registerData"
               :rules='rules'>
        <el-form-item>
          <h1>登录</h1>
        </el-form-item>
        <el-form-item prop="email">
          <el-input :prefix-icon="User" v-model="registerData.email" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input name="password" v-model="registerData.password" :prefix-icon="Lock" type="password"
                    placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item prop="verifyCode">
          <el-input style="width: 250px; margin-right: 10px;" v-model="registerData.verifyCode"
                    placeholder="请输入验证码"/>
          <img width="100" style="margin-left: 2.5rem;" height="30" ref="verifyImg"
               src="http://localhost:9090/auth/verifyCodeImg" @click="getVerifyCodeImg"
               alt="">
        </el-form-item>
        <el-form-item class="flex">
          <div class="flex">
            <el-checkbox>记住我</el-checkbox>
            <el-link type="primary" :underline="false">忘记密码？</el-link>
          </div>
        </el-form-item>
        <!-- 登录按钮 -->
        <el-form-item>
          <el-button class="button" type="primary" auto-insert-space @click="signinSys">登录</el-button>
        </el-form-item>
        <el-form-item class="flex">
          <el-link type="info" :underline="false" @click="isRegister = true;cleanCacheData()">
            注册 →
          </el-link>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<style lang="scss" scoped>
/* 样式 */
.login-page {
  height: 100vh;
  background-color: #fff;
  
  .bg {
    background: //url('@/assets/images/logo2.png') no-repeat 40% 10% / 240px auto,
    url('@/assets/images/sys/bg.jpg') no-repeat 10% / cover;
    border-radius: 0 20px 20px 0;
  }
  
  .verify {
    display: flex;
    flex-direction: row;
  }
  
  .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    user-select: none;
    
    .title {
      margin: 0 auto;
    }
    
    .button {
      width: 100%;
    }
    
    .flex {
      width: 100%;
      display: flex;
      justify-content: space-between;
    }
  }
}
</style>