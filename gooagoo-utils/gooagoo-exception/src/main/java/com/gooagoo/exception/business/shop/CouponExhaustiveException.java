package com.gooagoo.exception.business.shop;

import com.gooagoo.exception.GooagooException;

/**
 * 优惠券收藏数量超过商家发行数量异常
 * @author YL
 *
 */
public class CouponExhaustiveException extends GooagooException
{

    private static final long serialVersionUID = 1L;

    public CouponExhaustiveException(String message)
    {
        super("优惠券收藏数量超过商家发行数量" + message);
    }

}
