package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

/**
 * 优惠凭证使用条件json实体
 * 使用校验信息，校验json串，支持品类、实体店、会员等级
 * 接口gasl05:结账申请，用到该实体转换json串为对象，校验优惠凭证使用条件
 */
public class CanNotUseCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String favoriteId;

    private String code;

    private String message;

    public String getFavoriteId()
    {
        return this.favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "CanNotUseCoupon [favoriteId=" + this.favoriteId + ", code=" + this.code + ", message=" + this.message + "]";
    }

}
