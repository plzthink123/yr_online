package com.think123.yr_online;

import com.think123.yr_online.service.ShiroService;
import com.think123.yr_online.service.safty.impl.ShiroServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.think123.yr_online.dao")
public class YrOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(YrOnlineApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedMethods("*");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addRedirectViewController("/", "/safty/login/index.html");
            }
        };
    }

    @Bean
    public ShiroService shiroService() {
        return new ShiroServiceImpl();
    }
}
