package cn.sxgan.base.auth.controller;

import cn.sxgan.base.auth.api.IAuthControllerApi;
import cn.sxgan.base.auth.entity.RequestHolder;
import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.base.auth.services.impl.AuthServiceImpl;
import cn.sxgan.base.auth.services.impl.MailSendServiceImpl;
import cn.sxgan.base.auth.services.impl.UserServiceImpl;
import cn.sxgan.common.anno.RequestBeforeLog;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.entity.vo.SysUserVO;
import cn.sxgan.common.enums.ResponseStatus;
import cn.sxgan.common.response.ResponseResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 认证控制器
 * @Author: sxgan
 * @Date: 2024-07-11 23:34
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/auth/")
public class AuthController implements IAuthControllerApi {
    
    @Resource
    MailSendServiceImpl mailSendService;
    
    @Resource
    AuthServiceImpl authService;
    
    @Resource
    UserServiceImpl userService;
    
    @PostMapping("/mailVerifyCode")
    public ResponseResult<String> sendVerifyCode(@RequestBody UserSessionInfo userSessionInfo) {
        String email = userSessionInfo.getEmail();
        if (StringUtils.isBlank(email)) {
            return ResponseResult.fail(ResponseStatus.EXCEPTION_STATUS_900.getMsg());
        }
        return mailSendService.sendVerifyCodeToSpecifiedEmail(email);
    }
    
    @PostMapping("/signup")
    public ResponseResult<Map<String, String>> signup(@RequestBody UserSessionInfo userSessionInfo) {
        return authService.signupUserByEmail(userSessionInfo);
    }
    
    @GetMapping("/verifyCodeImg")
    public ResponseResult<Map<String, String>> getVerifyCodeImg(HttpServletResponse response) {
        return mailSendService.getVerifyCodeImg(response);
    }
    
    @WorkTime("登录")
    @RequestBeforeLog
    @PostMapping("/signin")
    public ResponseResult<Map<String, String>> signin(@RequestBody UserSessionInfo userSessionInfo) {
        return authService.userAuthByEmail(userSessionInfo);
    }
    
    @GetMapping("/getSysUserInfo")
    public ResponseResult<SysUserVO> getSysUserInfo() {
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        SysUserVO sysUserVO = userService.selectSysUserInfo(currentUser);
        if (sysUserVO == null) {
            return ResponseResult.fail(null, ResponseStatus.EXCEPTION_STATUS_701.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_701.getMsg());
        }
        return ResponseResult.success(sysUserVO);
    }
    
    @PostMapping("/updateSysUserInfo")
    public ResponseResult<String> updateSysUserInfo(@RequestBody SysUserVO sysUserVO) {
        String result = userService.updateSysUserInfo(sysUserVO);
        if (result == null) {
            return ResponseResult.fail(null, ResponseStatus.EXCEPTION_STATUS_707.getCode(),
                    ResponseStatus.EXCEPTION_STATUS_707.getMsg());
        }
        return ResponseResult.success(result);
    }
    
    
}