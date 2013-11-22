package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.shop.ShopEntityInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopEntityInfoMapper;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class ShopEntityInfoGeneratorCoreServiceImpl implements ShopEntityInfoGeneratorCoreService
{

    @Autowired
    private ShopEntityInfoMapper shopEntityInfoMapper;

    @Override
    public Integer countByExample(ShopEntityInfoExample shopEntityInfoExample)
    {
        return this.shopEntityInfoMapper.countByExample(shopEntityInfoExample);
    }

    @Override
    public List<ShopEntityInfo> selectByExample(ShopEntityInfoExample shopEntityInfoExample)
    {
        return this.shopEntityInfoMapper.selectByExample(shopEntityInfoExample);
    }

    @Override
    public ShopEntityInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        ShopEntityInfoKey shopEntityInfoKey = new ShopEntityInfoKey();
        shopEntityInfoKey.setIsDel("N");
        shopEntityInfoKey.setShopEntityId(primaryKey);
        return this.shopEntityInfoMapper.selectByPrimaryKey(shopEntityInfoKey);
    }

    @Override
    public ShopEntityInfo selectByPrimaryKey(String primaryKey)
    {
        ShopEntityInfoKey shopEntityInfoKey = new ShopEntityInfoKey();
        shopEntityInfoKey.setShopEntityId(primaryKey);
        return this.shopEntityInfoMapper.selectByPrimaryKey(shopEntityInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopEntityInfoExample shopEntityInfoExample)
    {
        List<ShopEntityInfo> list = this.shopEntityInfoMapper.selectByExample(shopEntityInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopEntityInfoMapper.deleteByExample(shopEntityInfoExample) != list.size())
        {
            return false;
        }
        for (ShopEntityInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        ShopEntityInfoKey shopEntityInfoKey = new ShopEntityInfoKey();
        shopEntityInfoKey.setShopEntityId(primaryKey);
        if (this.shopEntityInfoMapper.deleteByPrimaryKey(shopEntityInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(ShopEntityInfoExample shopEntityInfoExample)
    {
        List<ShopEntityInfo> list = this.shopEntityInfoMapper.selectByExample(shopEntityInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ShopEntityInfo shopEntityInfo = new ShopEntityInfo();
        shopEntityInfo.setIsDel("Y");
        if (this.shopEntityInfoMapper.updateByExampleSelective(shopEntityInfo, shopEntityInfoExample) != list.size())
        {
            return false;
        }
        for (ShopEntityInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        ShopEntityInfo shopEntityInfo = new ShopEntityInfo();
        shopEntityInfo.setShopEntityId(primaryKey);
        shopEntityInfo.setIsDel("Y");
        if (this.shopEntityInfoMapper.updateByPrimaryKeySelective(shopEntityInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(ShopEntityInfo shopEntityInfo)
    {
        return this.shopEntityInfoMapper.insertSelective(shopEntityInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopEntityInfo shopEntityInfo, ShopEntityInfoExample shopEntityInfoExample)
    {
        List<ShopEntityInfo> list = this.shopEntityInfoMapper.selectByExample(shopEntityInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopEntityInfoMapper.updateByExampleSelective(shopEntityInfo, shopEntityInfoExample) != list.size())
        {
            return false;
        }
        for (ShopEntityInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopEntityInfo shopEntityInfo)
    {
        if (this.shopEntityInfoMapper.updateByPrimaryKeySelective(shopEntityInfo) != 1)
        {
            return false;
        }
        this.clearRedis(shopEntityInfo.getShopEntityId());
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
