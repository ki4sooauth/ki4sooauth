package com.gooagoo.exception.business.member;


/**
 * 会员特征值长度超过32个字符异常
 *
 */
public class MemberFeatureValueTooLongException extends MemberFeatureException
{

    private static final long serialVersionUID = 1L;

    public MemberFeatureValueTooLongException(String message)
    {
        super(message);
    }

}
