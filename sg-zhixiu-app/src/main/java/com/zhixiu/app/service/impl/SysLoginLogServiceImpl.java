package com.zhixiu.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhixiu.app.dao.SysLoginLogMapper;
import com.zhixiu.app.model.SysLoginLog;
import com.zhixiu.app.page.MybatisPageHelper;
import com.zhixiu.app.page.PageRequest;
import com.zhixiu.app.page.PageResult;
import com.zhixiu.app.page.Param;
import com.zhixiu.app.service.SysLoginLogService;

@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements SysLoginLogService {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(SysLoginLogServiceImpl.class);

	@Autowired
	private SysLoginLogMapper sysLoginLogMapper;

	@Override
	public int save(SysLoginLog record) {
		if (record.getId() == null || record.getId() == 0) {
			return sysLoginLogMapper.insertSelective(record);
		}
		return sysLoginLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLoginLog record) {
		return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLoginLog> records) {
		for (SysLoginLog record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLoginLog findById(Long id) {
		return sysLoginLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {

		LOGGER.debug("pageNum:{},pageSize:{}", pageRequest.getPageNum(),
		        pageRequest.getPageSize());
		PageHelper.startPage(pageRequest.getPageNum(),
		        pageRequest.getPageSize());

		List<SysLoginLog> currentPageList = sysLoginLogMapper.findPage();

		PageInfo<SysLoginLog> pageResultNew = new PageInfo<>(currentPageList);

		LOGGER.debug("pageResultNew:{}", pageResultNew);

		Param userName = pageRequest.getParam("userName");
		if (userName != null) {
			return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper,
			        "findPageByUserName", userName.getValue());
		}
		Param status = pageRequest.getParam("status");
		if (status != null) {
			return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper,
			        "findPageByStatus", status.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
	}

}
