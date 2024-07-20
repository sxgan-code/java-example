package cn.sxgan.base.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 相关配置
 * @Author: sxgan
 * @Date: 2024-07-19 23:07
 * @Version: 1.0
 **/
@Data
@Component
public class ZoeyConfig {
    @Value("${token.admin.secretKey}")
    String secretKey;
}
