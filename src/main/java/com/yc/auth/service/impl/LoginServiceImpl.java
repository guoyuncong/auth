package com.yc.auth.service.impl;

import com.yc.auth.basic.enums.LoginLogType;
import com.yc.auth.basic.enums.ResultCode;
import com.yc.auth.basic.event.log.LogEvent;
import com.yc.auth.basic.exception.BizException;
import com.yc.auth.basic.util.SecurityUtil;
import com.yc.auth.model.dto.UserInfoDTO;
import com.yc.auth.model.entity.User;
import com.yc.auth.model.param.LoginParam;
import com.yc.auth.security.LoginUser;
import com.yc.auth.security.service.TokenService;
import com.yc.auth.service.LoginService;
import com.yc.auth.service.PermissionService;
import com.yc.auth.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final PermissionService permissionService;

    private final RoleService roleService;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public String login(LoginParam loginParam) {
        /*// 验证图片验证码：❶ 获取验证码；❷ Redis 删除验证码；❸ 验证
        String verifyKey = RedisConstants.LOGIN_CAPTCHA_KEY + loginParam.getTicket();
        String captcha = RedisUtil.get(verifyKey);
        RedisUtil.delete(verifyKey);
        if (StrUtil.isEmpty(captcha)) {
            throw BizException.of(ResultCode.USER_VERIFICATION_CODE_ERROR);
        }
        if (! loginParam.getCode().equalsIgnoreCase(captcha)) {
            throw BizException.of(ResultCode.USER_VERIFICATION_CODE_ERROR);
        }*/
        // 用户验证
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword()));
        } catch (BadCredentialsException ex) {
            throw BizException.of(ResultCode.USER_PASSWORD_ERROR);
        }
        // 获取当前登录人
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        // 记入日志
        eventPublisher.publishEvent(new LogEvent(this, loginUser, LoginLogType.LOGIN));
        return tokenService.createJwtToken(loginUser);
    }

    @Override
    public void logout() {
        // 获取当前登录用户
        LoginUser loginUser = tokenService.getLoginUser();
        if (loginUser != null) {
            User user = loginUser.getUser();
            // 删除用户缓存记录
            tokenService.delLoginUser(user.getId());
            // 记录用户退出日志
            eventPublisher.publishEvent(new LogEvent(this, loginUser, LoginLogType.LOGOUT));
        }
    }

    @Override
    public UserInfoDTO getUserInfo() {
        // 获得当前 LoginUser
        LoginUser loginUser = SecurityUtil.getLoginUser();
        User user = loginUser.getUser();
        // 用户权限
        List<String> permissions = permissionService.getUserPermissions(user);
        // 用户角色
        List<String> roles = roleService.getUserRoles(user);
        // 返回信息
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setPermissions(permissions);
        userInfoDTO.setRoles(roles);
        userInfoDTO.setUser(user);
        return userInfoDTO;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }


}
