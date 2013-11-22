package com.gooagoo.exception.business.member;

import com.gooagoo.exception.common.FormatErrorException;

/**
 * 会员特征异常
 *
 */
public class MemberFeatureException extends FormatErrorException
{

    private static final long serialVersionUID = 1L;

    public MemberFeatureException(String message)
    {
        super(message);
    }

}
