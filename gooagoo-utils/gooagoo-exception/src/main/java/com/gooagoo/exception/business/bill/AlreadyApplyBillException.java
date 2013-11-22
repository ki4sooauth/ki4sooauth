package com.gooagoo.exception.business.bill;

import com.gooagoo.exception.GooagooException;

/**
 * 已申请结账异常
 *
 */
public class AlreadyApplyBillException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyApplyBillException(String message)
    {
        super(message);
    }

}
