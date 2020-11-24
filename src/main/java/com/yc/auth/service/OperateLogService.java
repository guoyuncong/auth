package com.yc.auth.service;


import com.yc.auth.model.entity.OperateLog;

public interface OperateLogService {

    /**
     * 保存操作日志
     *
     * @param operateLog bean
     */
    void save(OperateLog operateLog);
}
