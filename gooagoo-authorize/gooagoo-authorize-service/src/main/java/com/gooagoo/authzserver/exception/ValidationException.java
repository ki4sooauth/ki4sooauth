package com.gooagoo.authzserver.exception;

/**
 * 接口参数校验异常类
 * 使用说明：在接口实现中较难接口入参，如果不合法抛出该异常
 */
public class ValidationException extends Exception
{
    private static final long serialVersionUID = -8465118248461356513L;

    /**
     * 错误信息代码
     */
    private String errCode;
    private String errMessage;

    public ValidationException(String errCode, String errMsg)
    {
        super(errMsg);
        this.errCode = errCode;
        this.errMessage = errMsg;
    }

    /**
     * 获取较验异常信息代码
     */
    public String getErrorCode()
    {
        return this.errCode;
    }

    /**
     * 获取较验异常详细内容
     */
    public String getErrorMessage()
    {
        return this.errMessage;
    }
}
