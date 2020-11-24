package com.yc.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class EntityDTO {

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonIgnore
    private Date updateTime;

    /**
     * 由谁创建
     */
    @JsonIgnore
    private String createBy;

    /**
     * 由谁修改
     */
    @JsonIgnore
    private String updateBy;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 修改时间
     */
    private Long updateDate;

    public Long getCreateDate() {
        return createTime.getTime();
    }

    public Long getUpdateDate() {
        return createTime.getTime();
    }
}
