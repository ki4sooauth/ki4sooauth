package com.gooagoo.authzserver.exception;

import com.gooagoo.authzserver.constants.ErrorConstants;
import com.gooagoo.cache.ExceptionCache;

/**
 * 客户端参数较验工具类
 */
public class RequestValidationUtils
{
    /**
     * 较验参数是否为空
     */
    public static void checkIsEmpty(Object value, String fieldName) throws ValidationException
    {
        if (value == null)
        {
            throw new ValidationException(ErrorConstants.CLIENT_ERROR_MISSING, ExceptionCache.get(ErrorConstants.CLIENT_ERROR_MISSING) + "[" + fieldName + "]");
        }
        if (value instanceof String)
        {
            if (((String) value).trim().length() == 0)
            {
                throw new ValidationException(ErrorConstants.CLIENT_ERROR_MISSING, ExceptionCache.get(ErrorConstants.CLIENT_ERROR_MISSING) + "[" + fieldName + "]");
            }
        }
    }
}
