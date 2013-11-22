package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.igus.common.service.IShopTypeCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UShopType;

@Service("iShopTypeCommonService")
public class IShopTypeCommonServiceImpl implements IShopTypeCommonService
{

    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST)
    public TransData<Object> getShopTypeList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //1、获取商家类型列表
            ShopTypeExample queryCondition = new ShopTypeExample();
            queryCondition.createCriteria().andIsDelEqualTo("N");
            queryCondition.setOrderByClause("sort_order");
            List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(shopTypeList))
            {
                GooagooLog.info("获取商家类型列表：未获取到满足条件的商家类型列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UShopType> ushopTypeList = this.getShopTypeList(shopTypeList, -1);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushopTypeList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家类型列表：获取商家类型列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
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
            ushopType.setChildren(this.getShopTypeList(shopTypeList, shopType.getShopTypeId()));
            uShopTypeList.add(ushopType);
        }

        return uShopTypeList;
    }

}
