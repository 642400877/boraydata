package com.boraydata.hygiene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boraydata.hygiene.dal.mapper")
public class HygieneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HygieneApplication.class, args);
    }

}
