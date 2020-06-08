package com.zhixiu.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.gateway.dao.PlatformMapper;
import com.zhixiu.gateway.model.Platform;
import com.zhixiu.gateway.page.MybatisPageHelper;
import com.zhixiu.gateway.page.PageRequest;
import com.zhixiu.gateway.page.PageResult;
import com.zhixiu.gateway.page.Param;
import com.zhixiu.gateway.service.PlatformService;
import com.zhixiu.gateway.util.HttpUtils;

@Service("platformService")
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformMapper platformMapper;

	@Override
	public int save(Platform record) {

		record.setImageUrl(HttpUtils.getFavico(record.getAccessUrl()));
		if (record.getId() == null || record.getId() == 0) {
			return platformMapper.insert(record);
		}

		return platformMapper.updateByPrimaryKey(record);
	}

	@Override
	public int delete(Platform record) {
		return platformMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<Platform> records) {
		for (Platform record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Platform findById(Long id) {
		return platformMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("platformName");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, platformMapper,
			        "findPageByPlatformName", label.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, platformMapper);
	}

	@Override
	public Platform findByPlatformName(String platformName) {
		return platformMapper.findByPlatformName(platformName);
	}

	@Override
	public List<Platform> findAll() {
		return platformMapper.findAll();
	}

}
