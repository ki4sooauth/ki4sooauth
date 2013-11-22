package com.gooagoo.exception.business.bill;

import com.gooagoo.exception.GooagooException;

/**
 * 已开发票异常
 */
public class InvoiceAlreadyExistsException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public InvoiceAlreadyExistsException(String message)
    {
        super(message);
    }

}
