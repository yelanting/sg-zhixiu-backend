package com.zhixiu.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhixiu.app.dao.SysLogMapper;
import com.zhixiu.app.model.SysLog;
import com.zhixiu.app.page.MybatisPageHelper;
import com.zhixiu.app.page.PageRequest;
import com.zhixiu.app.page.PageResult;
import com.zhixiu.app.page.Param;
import com.zhixiu.app.service.SysLogService;
import com.zhixiu.util.core.StringUtil;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SysLogServiceImpl.class);

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "findDefaultPage")
    public PageResult findPage(PageRequest pageRequest) {
        Param label = pageRequest.getParam("userName");
        if (null != label && StringUtil.isStringAvaliable(label.getValue())) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper,
                    "findPageByUserName", label.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }

    public PageResult findDefaultPage(PageRequest pageRequest) {
        LOGGER.error("查询日志过于耗时，返回默认数据");
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        return pageResult;

    }
}
