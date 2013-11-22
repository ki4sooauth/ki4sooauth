package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 用户不可重复提交申请会员
 */
public class UserCanNotRepetitionApplyMemberException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public UserCanNotRepetitionApplyMemberException(String message)
    {
        super(message);
    }

}
