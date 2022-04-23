package com.duoduo.hashming.artisan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.duoduo.hashming.artisan.mapper")
public class ArtisanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtisanApplication.class, args);
	}

}
