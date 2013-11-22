package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 省份城市字典表
 */

public class UserCityareaKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号，自增长

    private String isDel;//是否删除，Y-已删除，N-未删除

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
