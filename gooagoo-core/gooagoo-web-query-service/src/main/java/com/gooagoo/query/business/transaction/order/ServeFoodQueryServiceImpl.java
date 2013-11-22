package com.gooagoo.query.business.transaction.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.transaction.order.ServeFoodQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.utils.TimeUtils;

@Service
public class ServeFoodQueryServiceImpl implements ServeFoodQueryService
{

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Override
    public List<Map<String, String>> findOrderDish(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        if (StringUtils.hasText(ctimestamp))
        {//由格式YYYY-MM-DD HH:MM:SS 转换成 yyyyMMddHHmmss
            ctimestamp = TimeUtils.dateFormat(ctimestamp, TimeUtils.FORMAT6);
        }
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "0");
    }

    @Override
    public List<Map<String, String>> findHurryDish(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        if (StringUtils.hasText(ctimestamp))
        {//由格式YYYY-MM-DD HH:MM:SS 转换成 yyyyMMddHHmmss
            ctimestamp = TimeUtils.dateFormat(ctimestamp, TimeUtils.FORMAT6);
        }
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "1");
    }

    @Override
    public List<Map<String, String>> findSlowDish(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        if (StringUtils.hasText(ctimestamp))
        {//由格式YYYY-MM-DD HH:MM:SS 转换成 yyyyMMddHHmmss
            ctimestamp = TimeUtils.dateFormat(ctimestamp, TimeUtils.FORMAT6);
        }
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "2");
    }

    @Override
    public List<Map<String, String>> findServe(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        if (StringUtils.hasText(ctimestamp))
        {//由格式YYYY-MM-DD HH:MM:SS 转换成 yyyyMMddHHmmss
            ctimestamp = TimeUtils.dateFormat(ctimestamp, TimeUtils.FORMAT6);
        }
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "11");
    }
}
