package com.boraydata.hygiene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.boraydata.hygiene.dal.mapper")
public class HygieneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HygieneApplication.class, args);
    }

}
