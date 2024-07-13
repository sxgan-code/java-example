package cn.sxgan.base.auth.services;

import cn.sxgan.common.response.ResponseResult;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

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
    
    /**
     * 获取验证码图片
     *
     * @return vToken, Base64 img
     */
    ResponseResult<Map<String, String>> getVerifyCodeImg(HttpServletResponse response);
}