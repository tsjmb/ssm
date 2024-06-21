package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

// 设置为配置类
@Configuration
// 扫描管理的bean
@ComponentScan({"com.service"})
// 加载配置文件中的属性
@PropertySource("classpath:jdbc.properties")
// 加载配置类
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {
}
