package com.htht.debbo_provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: debbo_piesat
 * @description: 启动类
 * @author: Zhao Lianlian
 * @create: 2021-04-27 08:56
 */
@SpringBootApplication
//@ImportResource(locations = "classpath:dubbo-provider.xml")
@EnableDubbo //开启注解形式dubbo发布,不需要配置dubbo-provider.xml等文件
@MapperScan(basePackages = "com.htht.debbo_provider.mapper")
public class DebboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebboProviderApplication.class, args);
    }

}
