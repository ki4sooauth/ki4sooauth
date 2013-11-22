package com.gooagoo.dao.business.bill.transaction;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.transaction.OrderInfoBusiness;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;

public interface OrderInfoBusinessMapper
{

    public int countOrderInfoList(@Param("userId") String userId, @Param("shopId") String shopId, @Param("begin") Date begin, @Param("end") Date end, @Param("goodsName") String goodsName);

    public List<OrderInfoBusiness> findOrderInfoList(@Param("userId") String userId, @Param("shopId") String shopId, @Param("begin") Date begin, @Param("end") Date end, @Param("goodsName") String goodsName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy);

    public List<PurchasedGoodsBusiness> findBoughtGoodsList(@Param("userId") String userId, @Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId, @Param("shopIdList") List<String> shopIdList, @Param("begin") Date begin, @Param("end") Date end, @Param("goodsName") String goodsName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
