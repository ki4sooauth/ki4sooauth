package com.gooagoo.exception.business.member;


/**
 * 会员特征编码为空异常
 *
 */
public class MemberFeatureCodeIsNullException extends MemberFeatureException
{

    private static final long serialVersionUID = 1L;

    public MemberFeatureCodeIsNullException(String message)
    {
        super(message);
    }

}
