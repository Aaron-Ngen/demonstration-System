package com.copm.demonstrationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ApplicationSpringBoot {
    public static void main(String[] args) {
        System.out.println("启动成功");
        SpringApplication.run(ApplicationSpringBoot.class);

    }
}
