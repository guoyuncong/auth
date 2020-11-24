package com.yc.auth.service.impl;

import com.yc.auth.model.entity.OperateLog;
import com.yc.auth.service.OperateLogService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperateLogServiceImpl implements OperateLogService {

//    private final OperateLogMapper operateLogMapper;

    @Async("operationPool")
    @Override
    public void save(OperateLog operateLog) {
//        operateLogMapper.insert(operateLog);
    }
}
