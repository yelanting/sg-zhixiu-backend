package com.zhixiu.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(scanBasePackages = { "com.zhixiu.product" })
@EntityScan(value = "com.zhixiu.product.model")
@MapperScan(basePackages = "com.zhixiu.product.mapper")
@EnableEurekaClient
@Controller
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Value("${env}")
	private String env;

	@GetMapping("/testReq")
	public String testReq() {
		return env;
	}

}