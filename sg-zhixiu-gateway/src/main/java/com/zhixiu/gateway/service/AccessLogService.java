package com.zhixiu.gateway.service;

import com.zhixiu.gateway.model.AccessLog;
import com.zhixiu.gateway.page.PageRequest;
import com.zhixiu.gateway.page.PageResult;

/**
 * 操作日志
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
public interface AccessLogService extends CurdService<AccessLog> {

	/**
	 * 根据ip分页查询
	 * 
	 * @param pageRequest
	 *            自定义，统一分页查询请求
	 * @return PageResult 自定义，统一分页查询结果
	 */
	PageResult findPageByIp(PageRequest pageRequest);

}
