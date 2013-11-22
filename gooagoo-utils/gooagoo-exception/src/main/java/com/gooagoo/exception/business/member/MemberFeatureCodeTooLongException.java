package com.gooagoo.exception.business.member;


/**
 * 会员特征编码长度超过32个字符异常
 *
 */
public class MemberFeatureCodeTooLongException extends MemberFeatureException
{

    private static final long serialVersionUID = 1L;

    public MemberFeatureCodeTooLongException(String message)
    {
        super(message);
    }

}
