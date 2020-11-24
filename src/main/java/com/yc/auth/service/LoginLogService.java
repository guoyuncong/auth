package com.yc.auth.service;


import com.yc.auth.model.entity.LoginLog;

public interface LoginLogService {

    /**
     * 新增
     *
     * @param loginLog   bean
     */
    void save(LoginLog loginLog);
}
