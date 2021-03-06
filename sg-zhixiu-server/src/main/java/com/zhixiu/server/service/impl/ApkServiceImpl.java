package com.zhixiu.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.server.dao.ApkMapper;
import com.zhixiu.server.model.Apk;
import com.zhixiu.server.page.MybatisPageHelper;
import com.zhixiu.server.page.PageRequest;
import com.zhixiu.server.page.PageResult;
import com.zhixiu.server.page.Param;
import com.zhixiu.server.service.ApkService;

@Service("apkService")
public class ApkServiceImpl implements ApkService {

	@Autowired
	private ApkMapper apkMapper;

	@Override
	public int save(Apk record) {

		if (record.getId() == null || record.getId() == 0) {
			// record.setCreateBy(GlobalAuth.USERNAME);
			// record.setLastUpdateBy(GlobalAuth.USERNAME);
			return apkMapper.insert(record);
		}

		// record.setLastUpdateBy(GlobalAuth.USERNAME);
		return apkMapper.updateByPrimaryKey(record);
	}

	@Override
	public int delete(Apk record) {
		return apkMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<Apk> records) {
		for (Apk record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Apk findById(Long id) {
		return apkMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("label");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, apkMapper,
			        "findPageByLabel", label.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, apkMapper);
	}

	@Override
	public Apk findByName(String name) {
		return apkMapper.findByName(name);
	}

	@Override
	public Apk findByPackageName(String packageName) {
		return apkMapper.findByPackageName(packageName);
	}

	@Override
	public List<Apk> findByLable(String label) {
		return apkMapper.findByLable(label);
	}

	@Override
	public List<Apk> findAll() {
		return apkMapper.findAll();
	}

	@Override
	public Apk insertOrUpdate(Apk record) {
		if (record.getId() == null || record.getId() == 0) {
			// record.setCreateBy(GlobalAuth.USERNAME);
			// record.setLastUpdateBy(GlobalAuth.USERNAME);
			apkMapper.insert(record);
			return record;
		}

		// record.setLastUpdateBy(GlobalAuth.USERNAME);
		apkMapper.updateByPrimaryKey(record);
		return record;
	}

}
