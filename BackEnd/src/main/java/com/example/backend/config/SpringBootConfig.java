package com.example.backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@MapperScan("com.example.backend.mapper")
public class SpringBootConfig {
}
