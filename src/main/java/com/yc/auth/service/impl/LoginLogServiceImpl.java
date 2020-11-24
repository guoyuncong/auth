package com.yc.auth.service.impl;

import com.yc.auth.model.entity.LoginLog;
import com.yc.auth.service.LoginLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {

//    private final LoginLogMapper loginLogMapper;


    @Override
    public void save(LoginLog loginLog) {
//        loginLogMapper.insert(loginLog);
    }
}
