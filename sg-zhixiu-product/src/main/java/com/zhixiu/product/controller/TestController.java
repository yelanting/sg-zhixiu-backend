/**
 * @author : 孙留平
 * @since : 2020年6月8日 下午7:14:29
 * @see:
 */
package com.zhixiu.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Administrator
 * @since : 2020年6月8日 下午7:14:29
 * @see :
 */
@RestController
public class TestController {
	@Value("${env}")
	private String env;

	@GetMapping("/testReq")
	public String testReq() {
		return env;
	}
}
