package com.zhixiu.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhixiu.app.model.AccessLog;

public interface AccessLogMapper {
	int deleteByPrimaryKey(Long id);

	int insert(AccessLog record);

	int insertSelective(AccessLog record);

	AccessLog selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AccessLog record);

	int updateByPrimaryKey(AccessLog record);

	List<AccessLog> findPage();

	List<AccessLog> findPageByUserName(
	        @Param(value = "userName") String userName);

	List<AccessLog> findPageByIp(@Param(value = "ip") String ip);
}