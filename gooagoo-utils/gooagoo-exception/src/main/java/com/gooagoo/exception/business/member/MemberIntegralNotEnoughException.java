package com.gooagoo.exception.business.member;

import com.gooagoo.exception.GooagooException;

/**
 * 会员积分不足异常
 *
 */
public class MemberIntegralNotEnoughException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public MemberIntegralNotEnoughException(String message)
    {
        super(message);
    }

}
