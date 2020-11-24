package com.yc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.auth.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
