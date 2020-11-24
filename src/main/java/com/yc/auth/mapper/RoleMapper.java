package com.yc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.auth.model.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * 角色表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
}
