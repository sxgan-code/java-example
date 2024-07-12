package cn.sxgan.base.auth.services;

import cn.sxgan.common.response.ResponseResult;

/**
 * @Description: 邮箱服务接口
 * @Author: sxgan
 * @Date: 24/7/12 15:41
 * @Version: 1.0
 **/
public interface IMailSendService {
    
    
    /**
     * 发送验证码到指定邮箱
     *
     * @param email 邮箱
     * @return
     */
    ResponseResult<String> sendVerifyCodeToSpecifiedEmail(String email);
}