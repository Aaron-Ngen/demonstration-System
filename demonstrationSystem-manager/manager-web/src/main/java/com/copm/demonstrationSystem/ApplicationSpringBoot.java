package com.copm.demonstrationSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class ApplicationSpringBoot {

 //   public static final Logger logger = LoggerFactory.getLogger(ApplicationSpringBoot.class);

    public static void main(String[] args) {
 //       logger.info("==============【启动成功】================");
        SpringApplication.run(ApplicationSpringBoot.class);
    }
}
