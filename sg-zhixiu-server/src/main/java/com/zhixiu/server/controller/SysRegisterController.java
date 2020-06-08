package com.zhixiu.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.server.service.SysRegisterService;
import com.zhixiu.server.vo.RegisterBean;
import com.zhixiu.util.vo.ResponseData;

/**
 * 登录控制器
 * 
 * @author administrator
 * @date Jan 14, 2019
 */
@RestController("sysRegister")
public class SysRegisterController {

	@Autowired
	private SysRegisterService sysRegisterService;

	@PostMapping("/register")
	public ResponseData register(@RequestBody RegisterBean registerBean) {
		return ResponseData
		        .getSuccessResult(sysRegisterService.register(registerBean));
	}
}
