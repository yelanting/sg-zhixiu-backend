/**
 * @author : 孙留平
 * @since : 2020年2月27日 下午1:36:23
 * @see:
 */
package com.zhixiu.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.app.dao.SysRoleDeptMapper;
import com.zhixiu.app.model.SysRoleDept;
import com.zhixiu.app.service.SysRoleDeptService;

/**
 * @author : Administrator
 * @since : 2020年2月27日 下午1:36:23
 * @see :
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

	@Autowired
	private SysRoleDeptMapper sysRoleDeptMapper;

	@Override
	public List<SysRoleDept> deleteByRoleId(Long roleId) {

		List<SysRoleDept> currentSysRoleDepts = findRoleDeptsByRoleId(roleId);
		if (currentSysRoleDepts.isEmpty()) {
			return new ArrayList<SysRoleDept>();
		}

		sysRoleDeptMapper.deleteByRoleId(roleId);

		return currentSysRoleDepts;

	}

	@Override
	public SysRoleDept delete(Long id) {
		SysRoleDept currentSysRoleDept = findById(id);
		if (null == currentSysRoleDept) {
			return null;
		}
		sysRoleDeptMapper.deleteByPrimaryKey(id);
		return currentSysRoleDept;
	}

	@Override
	public SysRoleDept save(SysRoleDept record) {
		if (null != record.getId()) {
			sysRoleDeptMapper.updateByPrimaryKey(record);
			return record;
		}

		sysRoleDeptMapper.insert(record);
		return record;
	}

	@Override
	public SysRoleDept findById(Long id) {
		return sysRoleDeptMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysRoleDept> findRoleDeptsByRoleId(Long roleId) {
		return sysRoleDeptMapper.findRoleDeptsByRoleId(roleId);
	}

	@Override
	public List<SysRoleDept> findRoleDeptsByDeptId(Long deptId) {
		return sysRoleDeptMapper.findRoleDeptsByDeptId(deptId);
	}

}
