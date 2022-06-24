package com.air.airtest;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @MapperScan("com.air.airtest.mapper")
@SpringBootApplication
public class AirtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirtestApplication.class, args);
	}

}
