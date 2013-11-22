package com.gooagoo.exception.business.sys;

import com.gooagoo.exception.GooagooException;

/**
 * 模板数据为空异常
 * @author YL
 *
 */
public class TemplateDataIsEmptyException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public TemplateDataIsEmptyException(String message)
    {
        super(message);
    }

}
