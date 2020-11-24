package com.yc.auth.basic.aop.listener;

import cn.hutool.core.bean.BeanUtil;
import com.yc.auth.basic.event.log.LogEvent;
import com.yc.auth.model.entity.LoginLog;
import com.yc.auth.service.LoginLogService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 登录日志事件监听
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Component
@AllArgsConstructor
public class LoginEventListener implements ApplicationListener<LogEvent> {

    private LoginLogService loginLogService;

    @Async
    @EventListener
    @Override
    public void onApplicationEvent(LogEvent logEvent) {
        LoginLog loginLog = new LoginLog();
        BeanUtil.copyProperties(logEvent, loginLog);
        loginLogService.save(loginLog);
    }
}
