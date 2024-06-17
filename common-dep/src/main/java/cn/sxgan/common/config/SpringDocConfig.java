package cn.sxgan.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringDoc基本信息配置类
 * @Author: sxgan
 * @Date: 2024/3/1 15:12
 * @Version: 1.0
 **/
@Configuration
public class SpringDocConfig {
    
    @Bean
    public OpenAPI defaultOpenAPI() {
        return new OpenAPI().
                info(info())
                .externalDocs(documentation());
    }
    
    public Info info() {
        return new Info()
                .title("Java Example")
                .version("V1.0.0")
                .description("java案例整合项目")
                .license(new License().name("Apache-2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("sxgan").url("https://gitee.com/sxgan"))
                .summary("java案例整合项目");
    }
    
    public ExternalDocumentation documentation() {
        return new ExternalDocumentation().description("java案例整合项目")
                .url("http://localhost:9090/v3/api-docs");
    }
    
    
}