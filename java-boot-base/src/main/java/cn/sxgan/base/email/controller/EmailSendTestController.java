package cn.sxgan.base.email.controller;

import cn.sxgan.common.exception.AuthorityException;
import cn.sxgan.common.exception.ExceptionStatus;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.mail.internet.InternetAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Email邮件发送测试
 * @Author: sxgan
 * @Date: 2024-06-17 18:01
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/email/")
@Slf4j
@Tag(name = "springboot整合/整合Email", description = "整合Email")
public class EmailSendTestController {
    
    @Value("${spring.mail.username}")
    private String sendEmail;
    @Resource
    private JavaMailSender javaMailSender;
    
    @Operation(
            summary = "模拟验证码",
            description = "模拟注册验证码",
            parameters = {
                    @Parameter(name = "captcha", description = "验证码", required = true, example = "LU45LI2H",
                            schema = @Schema(implementation = String.class)),
                    @Parameter(name = "email", description = "目标邮箱", required = true, example = "sxgan@foxmail.com",
                            schema = @Schema(implementation = Integer.class))
            }
    )
    @PostMapping("/send")
    public ResponseResult<String> testSend(@RequestParam String captcha, @RequestParam String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Zoey注册邮箱验证码");
        message.setText("尊敬的用户 " + email + "\n\n您好! 感谢您注册Zoey。\n\n您的校验验证码为: "
                + captcha + "\n\n有效期5分钟，请不要把验证码信息泄露给其他人,如非本人请勿操作");
        message.setTo(email);
        try {
            // 对方看到的发送人（发件人的邮箱，根据实际业务进行修改，一般填写的是企业邮箱）
            log.info("发送人邮箱：{}", sendEmail);
            int i = 1 / 0;
            message.setFrom(new InternetAddress(sendEmail).toString());
            // 发送邮件
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("邮件发送失败", e);
            throw new AuthorityException(
                    ExceptionStatus.EXCEPTION_STATUS_712.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_712.getExceptionMsg());
        }
        return ResponseResult.success("发送成功");
    }
    
}
