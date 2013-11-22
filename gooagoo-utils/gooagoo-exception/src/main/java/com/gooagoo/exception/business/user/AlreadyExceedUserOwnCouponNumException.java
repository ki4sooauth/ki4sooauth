package com.gooagoo.exception.business.user;

import com.gooagoo.exception.GooagooException;

/**
 * 已超过用户拥有优惠券最大个数异常
 * @author YL
 *
 */
public class AlreadyExceedUserOwnCouponNumException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public AlreadyExceedUserOwnCouponNumException(String message)
    {
        super(message);
    }

}
