package com.zhixiu.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.app.model.SysLog;
import com.zhixiu.app.page.PageRequest;
import com.zhixiu.app.service.SysLogService;
import com.zhixiu.util.vo.ResponseData;

/**
 * 操作日志控制器
 * @author administrator
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("log")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	@PreAuthorize("hasAuthority('sys:log:view')")
	@PostMapping(value="/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData.getSuccessResult(sysLogService.findPage(pageRequest));
	}
	
	@PreAuthorize("hasAuthority('sys:log:delete')")
	@PostMapping(value="/delete")
	public ResponseData delete(@RequestBody List<SysLog> records) {
		return ResponseData.getSuccessResult(sysLogService.delete(records));
	}
}
