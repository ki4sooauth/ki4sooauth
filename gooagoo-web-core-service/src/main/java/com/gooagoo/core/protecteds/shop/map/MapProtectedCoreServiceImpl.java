package com.gooagoo.core.protecteds.shop.map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gooagoo.api.generator.core.shop.ShopPositionGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.map.MapProtectedCoreService;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;

@Service
public class MapProtectedCoreServiceImpl implements MapProtectedCoreService
{

    @Autowired
    private ShopPositionGeneratorCoreService shopPositionGeneratorCoreService;

    @Override
    public String getUnderShopPosition(String positionId)
    {
        StringBuffer sb = new StringBuffer();
        ShopPosition shopPosition = this.shopPositionGeneratorCoreService.selectUnDelByPrimaryKey(positionId);
        if (shopPosition != null)
        {
            sb.append(shopPosition.getPositionId() + ":" + shopPosition.getParentPositionId());
            this.recursionUnderShopPosition(sb, positionId);
        }
        return sb.toString();
    }

    /**
     * 递归封装
     * @param positionMap
     * @param parentPositionId
     */
    private void recursionUnderShopPosition(StringBuffer sb, String parentPositionId)
    {
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        shopPositionExample.createCriteria().andParentPositionIdEqualTo(parentPositionId).andIsDelEqualTo("N");
        List<ShopPosition> list = this.shopPositionGeneratorCoreService.selectByExample(shopPositionExample);
        if (!CollectionUtils.isEmpty(list))
        {
            for (ShopPosition item : list)
            {
                sb.append("," + item.getPositionId() + ":" + item.getParentPositionId());
                this.recursionUnderShopPosition(sb, item.getPositionId());
            }
        }
    }

}
