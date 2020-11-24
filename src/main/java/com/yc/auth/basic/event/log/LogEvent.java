package com.yc.auth.basic.event.log;

import com.yc.auth.basic.enums.LoginLogType;
import com.yc.auth.basic.util.ServletUtils;
import com.yc.auth.security.LoginUser;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 保存日志
 */
@Getter
public class LogEvent extends ApplicationEvent {

    private String userId;

    private String uri;

    public LogEvent(Object source) {
        super(source);
    }

    public LogEvent(Object source, LoginUser loginUser, LoginLogType loginLogType) {
        super(source);
        this.uri = ServletUtils.getRequest().getRequestURI();
    }
}
