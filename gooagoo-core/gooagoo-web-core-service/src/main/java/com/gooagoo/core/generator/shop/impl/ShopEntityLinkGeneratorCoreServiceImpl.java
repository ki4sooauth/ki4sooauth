package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.shop.ShopEntityLinkGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopEntityLinkMapper;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopEntityLinkKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class ShopEntityLinkGeneratorCoreServiceImpl implements ShopEntityLinkGeneratorCoreService
{

    @Autowired
    private ShopEntityLinkMapper shopEntityLinkMapper;

    @Override
    public Integer countByExample(ShopEntityLinkExample shopEntityLinkExample)
    {
        return this.shopEntityLinkMapper.countByExample(shopEntityLinkExample);
    }

    @Override
    public List<ShopEntityLink> selectByExample(ShopEntityLinkExample shopEntityLinkExample)
    {
        return this.shopEntityLinkMapper.selectByExample(shopEntityLinkExample);
    }

    @Override
    public ShopEntityLink selectUnDelByPrimaryKey(String primaryKey)
    {
        ShopEntityLinkKey shopEntityLinkKey = new ShopEntityLinkKey();
        shopEntityLinkKey.setIsDel("N");
        shopEntityLinkKey.setShopEntityId(primaryKey);
        return this.shopEntityLinkMapper.selectByPrimaryKey(shopEntityLinkKey);
    }

    @Override
    public ShopEntityLink selectByPrimaryKey(String primaryKey)
    {
        ShopEntityLinkKey shopEntityLinkKey = new ShopEntityLinkKey();
        shopEntityLinkKey.setShopEntityId(primaryKey);
        return this.shopEntityLinkMapper.selectByPrimaryKey(shopEntityLinkKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopEntityLinkExample shopEntityLinkExample)
    {
        List<ShopEntityLink> list = this.shopEntityLinkMapper.selectByExample(shopEntityLinkExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopEntityLinkMapper.deleteByExample(shopEntityLinkExample) != list.size())
        {
            return false;
        }
        for (ShopEntityLink item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        ShopEntityLinkKey shopEntityLinkKey = new ShopEntityLinkKey();
        shopEntityLinkKey.setShopEntityId(primaryKey);
        if (this.shopEntityLinkMapper.deleteByPrimaryKey(shopEntityLinkKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(ShopEntityLinkExample shopEntityLinkExample)
    {
        List<ShopEntityLink> list = this.shopEntityLinkMapper.selectByExample(shopEntityLinkExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ShopEntityLink shopEntityLink = new ShopEntityLink();
        shopEntityLink.setIsDel("Y");
        if (this.shopEntityLinkMapper.updateByExampleSelective(shopEntityLink, shopEntityLinkExample) != list.size())
        {
            return false;
        }
        for (ShopEntityLink item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        ShopEntityLink shopEntityLink = new ShopEntityLink();
        shopEntityLink.setShopEntityId(primaryKey);
        shopEntityLink.setIsDel("Y");
        if (this.shopEntityLinkMapper.updateByPrimaryKeySelective(shopEntityLink) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(ShopEntityLink shopEntityLink)
    {
        return this.shopEntityLinkMapper.insertSelective(shopEntityLink) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopEntityLink shopEntityLink, ShopEntityLinkExample shopEntityLinkExample)
    {
        List<ShopEntityLink> list = this.shopEntityLinkMapper.selectByExample(shopEntityLinkExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopEntityLinkMapper.updateByExampleSelective(shopEntityLink, shopEntityLinkExample) != list.size())
        {
            return false;
        }
        for (ShopEntityLink item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopEntityLink shopEntityLink)
    {
        if (this.shopEntityLinkMapper.updateByPrimaryKeySelective(shopEntityLink) != 1)
        {
            return false;
        }
        this.clearRedis(shopEntityLink.getShopEntityId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param shopEntityId 实体店编号
     */
    private void clearRedis(String shopEntityId)
    {
        if (StringUtils.hasText(shopEntityId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_shop);
            base.del(shopEntityId);
        }
    }

}
