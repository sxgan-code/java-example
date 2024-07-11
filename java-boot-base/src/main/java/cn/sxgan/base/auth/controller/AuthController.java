package cn.sxgan.base.auth.controller;

import cn.sxgan.common.utils.VerifyCodeUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description: 认证接口
 * @Author: sxgan
 * @Date: 2024-07-11 23:34
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/auth/")
@Slf4j
@Tag(name = "springboot案例/权限验证", description = "权限验证")
public class AuthController {
    
    //
    @Operation(
            summary = "获取验证码图片",
            description = "获取验证码图片"
    )
    @GetMapping("/verifyCodeImg")
    public void getVerifyCodeImg(HttpServletResponse response) {
        VerifyCodeUtils verifyCodeUtils = new VerifyCodeUtils();
        BufferedImage bi = verifyCodeUtils.getImage();// 获取验证码BufferedImage对象
        System.out.println(verifyCodeUtils.getText());// 获取验证码文本
        try {
            ImageIO.write(bi, "jpg", response.getOutputStream());
        } catch (IOException e) {
            log.error("获取验证码图片失败", e);
            throw new RuntimeException(e);
        }
        
    }
}
