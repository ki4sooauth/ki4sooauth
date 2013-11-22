package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 优惠凭证已过发行期异常
 */
public class CouponAlreadyPastPublishEndTimeException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CouponAlreadyPastPublishEndTimeException(String message)
    {
        super(message);
    }

}
