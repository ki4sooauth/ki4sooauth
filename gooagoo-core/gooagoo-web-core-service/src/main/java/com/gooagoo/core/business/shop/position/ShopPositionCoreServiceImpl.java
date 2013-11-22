package com.gooagoo.core.business.shop.position;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.shop.position.ShopPositionCoreService;
import com.gooagoo.api.generator.core.shop.ShopPositionGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.exception.common.NullException;

@Service
public class ShopPositionCoreServiceImpl implements ShopPositionCoreService
{
    @Autowired
    private ShopPositionGeneratorCoreService shopPositionGeneratorCoreService;

    @Override
    public boolean addShopPosition(ShopPosition shopPosition) throws Exception
    {
        shopPosition.setIsDel("N");
        return this.shopPositionGeneratorCoreService.insertSelective(shopPosition);
    }

    @Override
    public boolean updateShopPosition(ShopPosition shopPosition) throws Exception
    {
        return this.shopPositionGeneratorCoreService.updateByPrimaryKeySelective(shopPosition);
    }

    @Override
    public boolean deleteShopPosition(String id) throws Exception
    {
        if (StringUtils.isBlank(id))
        {
            GooagooLog.warn("删除商家位置信息：Id为空");
            return false;
        }
        return this.shopPositionGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void importShopPosition(String shopEntityId, List<ShopPosition> shopPositionList) throws Exception
    {
        if (StringUtils.isBlank(shopEntityId) || CollectionUtils.isEmpty(shopPositionList))
        {
            throw new NullException("参数实体店编号或位置信息列表为空");
        }
        //软删除实体店的位置信息
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        shopPositionExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        ShopPosition shopPosition = new ShopPosition();
        shopPosition.setIsDel("Y");
        this.shopPositionGeneratorCoreService.updateByExampleSelective(shopPosition, shopPositionExample);
        //批量添加商家位置信息
        for (ShopPosition item : shopPositionList)
        {
            this.shopPositionGeneratorCoreService.insertSelective(item);
        }
    }
}
