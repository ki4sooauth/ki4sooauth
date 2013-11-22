package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UShopType;

/**
 * 获取商家类型列表
 * @author SPZ
 *
 */
@Service("igus018Service")
public class IGus018ServiceImpl implements IGusService
{

    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            ShopTypeExample shopTypeExample = new ShopTypeExample();
            shopTypeExample.createCriteria().andIsDelEqualTo("N");
            shopTypeExample.setOrderByClause("sort_order");
            List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);
            if (CollectionUtils.isEmpty(shopTypeList))
            {
                GooagooLog.error("获取商家类型列表：未获取到满足条件的商家类型列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UShopType> ushopTypeList = this.getShopTypeList(shopTypeList, -1);
            transData = new TransData<Object>(true, null, ushopTypeList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家类型列表：获取商家类型列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

    /**
     * 组装商家类型列表
     * @param shopTypeList
     * @param parentShopTypeId
     * @return
     */
    private List<UShopType> getShopTypeList(List<ShopType> shopTypeList, Integer parentShopTypeId)
    {
        List<ShopType> childrenShopTypeList = new ArrayList<ShopType>();
        for (ShopType shopType : shopTypeList)
        {
            if (shopType.getParentShopTypeId().intValue() == parentShopTypeId.intValue())
            {
                childrenShopTypeList.add(shopType);
            }
        }
        if (childrenShopTypeList.size() == 0)
        {
            return new ArrayList<UShopType>();
        }
        List<UShopType> uShopTypeList = new ArrayList<UShopType>();
        for (ShopType shopType : childrenShopTypeList)
        {
            UShopType ushopType = new UShopType();
            ushopType.setShopTypeId(shopType.getShopTypeId());
            ushopType.setShopTypeName(shopType.getShopTypeName());
            ushopType.setChildrenShopType(this.getShopTypeList(shopTypeList, shopType.getShopTypeId()));
            uShopTypeList.add(ushopType);
        }
        return uShopTypeList;
    }

}
