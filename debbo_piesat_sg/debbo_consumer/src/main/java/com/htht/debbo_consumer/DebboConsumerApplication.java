package com.htht.debbo_consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: debbo_piesat
 * @description: 启动类
 * @author: Zhao Lianlian
 * @create: 2021-04-27 09:34
 */
@SpringBootApplication
@EnableDubbo
//@ImportResource(locations = "classpath:dubbo-consumer.xml")
public class DebboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebboConsumerApplication.class, args);
    }

}
