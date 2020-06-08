package com.zhixiu.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhixiu.server.dao.AccessLogMapper;
import com.zhixiu.server.model.AccessLog;
import com.zhixiu.server.page.MybatisPageHelper;
import com.zhixiu.server.page.PageRequest;
import com.zhixiu.server.page.PageResult;
import com.zhixiu.server.page.Param;
import com.zhixiu.server.service.AccessLogService;

@Service("accessLogService")
public class AccessLogServiceImpl implements AccessLogService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AccessLogServiceImpl.class);

    @Autowired
    private AccessLogMapper accessLogMapper;

    @Override
    public int save(AccessLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return accessLogMapper.insertSelective(record);
        }
        return accessLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AccessLog record) {
        return accessLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<AccessLog> records) {
        for (AccessLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public AccessLog findById(Long id) {
        return accessLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        // Param label = pageRequest.getParam("userName");
        // if (label != null) {
        // return MybatisPageHelper.findPage(pageRequest, accessLogMapper,
        // "findPageByUserName", label.getValue());
        // }
        // return MybatisPageHelper.findPage(pageRequest, accessLogMapper);
        LOGGER.debug("分页之前");
        PageHelper.startPage(pageRequest.getPageNum(),
                pageRequest.getPageSize());
        List<AccessLog> pageList = accessLogMapper.findPage();
        LOGGER.debug("查询之后");
        PageInfo<AccessLog> pageInfo = new PageInfo<AccessLog>(pageList);

        LOGGER.debug("查询之后findPage :{}", pageInfo);
        PageResult pageResult = MybatisPageHelper
                .parsePageResultFromPageInfo(pageRequest, pageInfo);
        return pageResult;
    }

    @Override
    public PageResult findPageByIp(PageRequest pageRequest) {
        Param label = pageRequest.getParam("ip");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, accessLogMapper,
                    "findPageByIp", label.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, accessLogMapper);
    }

}
