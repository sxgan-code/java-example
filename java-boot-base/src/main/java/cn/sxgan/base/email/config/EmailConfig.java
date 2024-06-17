package cn.sxgan.base.email.config;

import cn.sxgan.common.entity.SysCode;
import cn.sxgan.common.entity.SysCodeQuery;
import cn.sxgan.common.mappers.SysCodeMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {
    @Resource
    private SysCodeMapper sysCodeMapper;
    
    private final static String PASSWORD_KEY = "email.password";
    
    // 注入配置文件中的属性值
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String username;
    
    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;
    
    @Value("${spring.mail.protocol}")
    private String protocol;
    
    @Value("${spring.mail.properties.mail.smtp.ssl.enable}")
    private String sslEnable;
    
    @Value("${spring.mail.properties.mail.smtp.ssl.required}")
    private String sslRequired;
    
    @Value("${spring.mail.properties.mail.smtp.timeout}")
    private String timeout;
    
    @Value("${spring.mail.properties.mail.smtp.connection-timeout}")
    private String connectionTimeout;
    
    @Value("${spring.mail.properties.mail.smtp.write-timeout}")
    private String writeTimeout;
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        SysCodeQuery sysCodeQuery = new SysCodeQuery();
        sysCodeQuery.setConfigKey(PASSWORD_KEY);
        List<SysCode> sysCodes = sysCodeMapper.selectConfigByCondition(sysCodeQuery);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(username);
        mailSender.setPassword(sysCodes.getFirst().getConfigValue());
        mailSender.setDefaultEncoding(defaultEncoding);
        mailSender.setProtocol(protocol);
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.enable", sslEnable);
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.required", sslRequired);
        mailSender.getJavaMailProperties().put("mail.smtp.timeout", timeout);
        mailSender.getJavaMailProperties().put("mail.smtp.connection-timeout", connectionTimeout);
        mailSender.getJavaMailProperties().put("mail.smtp.write-timeout", writeTimeout);
        
        return mailSender;
    }
}