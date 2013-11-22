package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 接口请求参数信息表
 */

public class InterfaceRequestInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

}
