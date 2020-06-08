package com.zhixiu.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.server.dao.PlatformMapper;
import com.zhixiu.server.model.Platform;
import com.zhixiu.server.page.MybatisPageHelper;
import com.zhixiu.server.page.PageRequest;
import com.zhixiu.server.page.PageResult;
import com.zhixiu.server.page.Param;
import com.zhixiu.server.service.PlatformService;
import com.zhixiu.server.util.HttpUtils;

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
