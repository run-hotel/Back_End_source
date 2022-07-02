package com.air.airtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.air.airtest.mapper")
public class AirtestApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirtestApplication.class, args);
		System.out.println("启动成功");
	}

}
