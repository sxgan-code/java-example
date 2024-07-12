package cn.sxgan.base.auth.services.impl;

import cn.sxgan.base.auth.services.IMailSendService;
import cn.sxgan.common.cache.redis.RedisUtil;
import cn.sxgan.common.consts.RedisConst;
import cn.sxgan.common.enums.ResponseStatus;
import cn.sxgan.common.exception.AuthorityException;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.common.utils.DateUtils;
import jakarta.annotation.Resource;
import jakarta.mail.internet.InternetAddress;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 邮件发送服务
 * @Author: sxgan
 * @Date: 24/7/12 17:38
 * @Version: 1.0
 **/
@Slf4j
@Service
public class MailSendServiceImpl implements IMailSendService {
    
    @Value("${spring.mail.username}")
    private String sendEmail;
    
    @Resource
    private JavaMailSender javaMailSender;
    
    @Resource
    private RedisUtil redisUtil;
    
    @Override
    public ResponseResult<String> sendVerifyCodeToSpecifiedEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return ResponseResult.fail(ResponseStatus.EXCEPTION_STATUS_711.getMsg());
        }
        int count = 1;
        String captcha = CommonUtils.generateRandomCode(8);
        String captchaCacheVal;
        String captchaCacheKey = redisUtil.get(RedisConst.CARD_CAPTCHA_PREFIX + email, String.class);
        if (StringUtils.isBlank(captchaCacheKey)) {
            captchaCacheVal = captcha + "_" + count;
        } else {
            String[] capStrArr = captchaCacheKey.split("_");
            count = Integer.parseInt(capStrArr[1]);
            count++;
            if (count > 5) {
                return ResponseResult.fail("验证码次数超过今日上限，请明天再试");
            }
            captchaCacheVal = captcha + "_" + count;
        }
        captchaCacheVal = captchaCacheVal + "_" + System.currentTimeMillis();
        // 定义Redis的key
        captchaCacheKey = RedisConst.CARD_CAPTCHA_PREFIX + email;
        // 邮件对象（邮件模板，根据自身业务修改）
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Zoey注册邮箱验证码");
        message.setText("尊敬的用户 " + email + "\n\n您好! 感谢您注册Zoey。\n\n您的校验验证码为: "
                + captcha + "\n\n有效期5分钟，请不要把验证码信息泄露给其他人,如非本人请勿操作");
        message.setTo(email);
        try {
            // 对方看到的发送人（发件人的邮箱，根据实际业务进行修改，一般填写的是企业邮箱）
            log.info("发送人邮箱：{}", sendEmail);
            message.setFrom(new InternetAddress(sendEmail).toString());
            // 发送邮件
            javaMailSender.send(message);
            log.info("mail send success");
            redisUtil.set(captchaCacheKey, captchaCacheVal, DateUtils.getSecondsToMidnight(), TimeUnit.SECONDS);
            return ResponseResult.success("发送成功");
        } catch (Exception e) {
            log.info("mail send failed");
            throw new AuthorityException(
                    ResponseStatus.EXCEPTION_STATUS_712.getCode(), ResponseStatus.EXCEPTION_STATUS_712.getMsg());
        }
        
    }
}