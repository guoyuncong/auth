package com.yc.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.auth.model.entity.OperateLog;
import org.springframework.stereotype.Repository;

/**
 * 操作日志表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface OperateLogMapper extends BaseMapper<OperateLog> {
}
