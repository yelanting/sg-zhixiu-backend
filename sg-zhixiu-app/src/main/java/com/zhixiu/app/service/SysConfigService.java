package com.zhixiu.app.service;

import java.util.List;

import com.zhixiu.app.model.SysConfig;

/**
 * 系统配置管理
 * @author administrator
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
