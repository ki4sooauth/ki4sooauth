package com.gooagoo.exception.business.member;


/**
 * 会员特征值为空异常
 *
 */
public class MemberFeatureValueIsNullException extends MemberFeatureException
{

    private static final long serialVersionUID = 1L;

    public MemberFeatureValueIsNullException(String message)
    {
        super(message);
    }

}
