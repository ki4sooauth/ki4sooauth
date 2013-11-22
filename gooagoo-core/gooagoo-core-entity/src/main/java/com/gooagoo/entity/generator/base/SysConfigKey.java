package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 系统配置信息
 */

public class SysConfigKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号，自增长

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

}
