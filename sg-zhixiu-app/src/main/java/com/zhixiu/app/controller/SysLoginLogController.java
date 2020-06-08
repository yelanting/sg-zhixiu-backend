package com.zhixiu.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.app.model.SysLoginLog;
import com.zhixiu.app.page.PageRequest;
import com.zhixiu.app.service.SysLoginLogService;
import com.zhixiu.util.vo.ResponseData;

/**
 * 登录日志控制器
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

	@Autowired
	private SysLoginLogService sysLoginLogService;

	@PreAuthorize("hasAuthority('sys:loginlog:view')")
	@PostMapping(value="/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(sysLoginLogService.findPage(pageRequest));
	}
	
	@PreAuthorize("hasAuthority('sys:loginlog:delete')")
	@PostMapping(value="/delete")
	public ResponseData delete(@RequestBody List<SysLoginLog> records) {
		return ResponseData.getSuccessResult(sysLoginLogService.delete(records));
	}
}
