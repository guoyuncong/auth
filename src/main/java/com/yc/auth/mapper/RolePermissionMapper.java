package com.yc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.auth.model.entity.RoleMenu;
import org.springframework.stereotype.Repository;

/**
 * 角色权限表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RoleMenu> {
}
