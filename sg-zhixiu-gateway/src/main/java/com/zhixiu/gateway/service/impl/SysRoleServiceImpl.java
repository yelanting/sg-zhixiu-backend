package com.zhixiu.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhixiu.gateway.constant.SysConstants;
import com.zhixiu.gateway.dao.SysMenuMapper;
import com.zhixiu.gateway.dao.SysRoleMapper;
import com.zhixiu.gateway.dao.SysRoleMenuMapper;
import com.zhixiu.gateway.model.SysMenu;
import com.zhixiu.gateway.model.SysRole;
import com.zhixiu.gateway.model.SysRoleMenu;
import com.zhixiu.gateway.page.MybatisPageHelper;
import com.zhixiu.gateway.page.PageRequest;
import com.zhixiu.gateway.page.PageResult;
import com.zhixiu.gateway.page.Param;
import com.zhixiu.gateway.service.SysRoleDeptService;
import com.zhixiu.gateway.service.SysRoleService;
import com.zhixiu.gateway.service.SysUserRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Autowired
	private SysRoleDeptService sysRoleDeptService;

	@Override
	public int save(SysRole record) {
		if (record.getId() == null || record.getId() == 0) {
			return sysRoleMapper.insertSelective(record);
		}
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysRole record) {
		// 删除角色之后，删除角色和部门、和菜单之间的关系表
		sysUserRoleService.deleteByRoleId(record.getId());
		sysRoleDeptService.deleteByRoleId(record.getId());
		sysRoleMapper.deleteByPrimaryKey(record.getId());
		return 1;
	}

	@Override
	public int delete(List<SysRole> records) {
		for (SysRole record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRole findById(Long id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Param label = pageRequest.getParam("name");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysRoleMapper,
			        "findPageByName", label.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
	}

	@Override
	public List<SysRole> findAll() {
		return sysRoleMapper.findAll();
	}

	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}

	public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
		this.sysRoleMapper = sysRoleMapper;
	}

	@Override
	public List<SysMenu> findRoleMenus(Long roleId) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
		if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
			// 如果是超级管理员，返回全部
			return sysMenuMapper.findAll();
		}
		return sysMenuMapper.findRoleMenus(roleId);
	}

	@Transactional
	@Override
	public int saveRoleMenus(List<SysRoleMenu> records) {
		if (records == null || records.isEmpty()) {
			return 1;
		}
		Long roleId = records.get(0).getRoleId();
		sysRoleMenuMapper.deleteByRoleId(roleId);
		for (SysRoleMenu record : records) {
			sysRoleMenuMapper.insertSelective(record);
		}
		return 1;
	}

	@Override
	public List<SysRole> findByName(String name) {
		return sysRoleMapper.findByName(name);
	}

}
