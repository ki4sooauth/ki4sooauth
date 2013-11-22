package com.gooagoo.exception.business.user;

import com.gooagoo.exception.common.FormatErrorException;

/**
 * 密保问题答案不正确异常
 * @author frenn
 *
 */
public class SecurityQuestionAnswerErrorException extends FormatErrorException
{

    private static final long serialVersionUID = 1L;

    public SecurityQuestionAnswerErrorException(String message)
    {
        super(message);
    }

}
