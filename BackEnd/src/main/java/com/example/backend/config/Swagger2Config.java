package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
//    http://localhost:9099/swagger-ui.html
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                // 配置基本信息
                .apiInfo(apiInfo());
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "jhn", // 作者姓名
                null, // 作者网址
                null); // 作者邮箱
        return new ApiInfoBuilder()
                .title("电影院预约系统接口文档") // 标题
                .description("电影院预约系统") // 描述
                .version("1.0") // 版本
                .contact(contact)
                .build();
    }
}

