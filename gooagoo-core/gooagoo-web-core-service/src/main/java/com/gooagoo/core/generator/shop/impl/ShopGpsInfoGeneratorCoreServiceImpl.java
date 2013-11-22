package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.shop.ShopGpsInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopGpsInfoMapper;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class ShopGpsInfoGeneratorCoreServiceImpl implements ShopGpsInfoGeneratorCoreService
{

    @Autowired
    private ShopGpsInfoMapper shopGpsInfoMapper;

    @Override
    public Integer countByExample(ShopGpsInfoExample shopGpsInfoExample)
    {
        return this.shopGpsInfoMapper.countByExample(shopGpsInfoExample);
    }

    @Override
    public List<ShopGpsInfo> selectByExample(ShopGpsInfoExample shopGpsInfoExample)
    {
        return this.shopGpsInfoMapper.selectByExample(shopGpsInfoExample);
    }

    @Override
    public ShopGpsInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        ShopGpsInfoKey shopGpsInfoKey = new ShopGpsInfoKey();
        shopGpsInfoKey.setIsDel("N");
        shopGpsInfoKey.setShopEntityId(primaryKey);
        return this.shopGpsInfoMapper.selectByPrimaryKey(shopGpsInfoKey);
    }

    @Override
    public ShopGpsInfo selectByPrimaryKey(String primaryKey)
    {
        ShopGpsInfoKey shopGpsInfoKey = new ShopGpsInfoKey();
        shopGpsInfoKey.setShopEntityId(primaryKey);
        return this.shopGpsInfoMapper.selectByPrimaryKey(shopGpsInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopGpsInfoExample shopGpsInfoExample)
    {
        List<ShopGpsInfo> list = this.shopGpsInfoMapper.selectByExample(shopGpsInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopGpsInfoMapper.deleteByExample(shopGpsInfoExample) != list.size())
        {
            return false;
        }
        for (ShopGpsInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        ShopGpsInfoKey shopGpsInfoKey = new ShopGpsInfoKey();
        shopGpsInfoKey.setShopEntityId(primaryKey);
        if (this.shopGpsInfoMapper.deleteByPrimaryKey(shopGpsInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(ShopGpsInfoExample shopGpsInfoExample)
    {
        List<ShopGpsInfo> list = this.shopGpsInfoMapper.selectByExample(shopGpsInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ShopGpsInfo shopGpsInfo = new ShopGpsInfo();
        shopGpsInfo.setIsDel("Y");
        if (this.shopGpsInfoMapper.updateByExampleSelective(shopGpsInfo, shopGpsInfoExample) != list.size())
        {
            return false;
        }
        for (ShopGpsInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        ShopGpsInfo shopGpsInfo = new ShopGpsInfo();
        shopGpsInfo.setShopEntityId(primaryKey);
        shopGpsInfo.setIsDel("Y");
        if (this.shopGpsInfoMapper.updateByPrimaryKeySelective(shopGpsInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(ShopGpsInfo shopGpsInfo)
    {
        return this.shopGpsInfoMapper.insertSelective(shopGpsInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopGpsInfo shopGpsInfo, ShopGpsInfoExample shopGpsInfoExample)
    {
        List<ShopGpsInfo> list = this.shopGpsInfoMapper.selectByExample(shopGpsInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopGpsInfoMapper.updateByExampleSelective(shopGpsInfo, shopGpsInfoExample) != list.size())
        {
            return false;
        }
        for (ShopGpsInfo item : list)
        {
            this.clearRedis(item.getShopEntityId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopGpsInfo shopGpsInfo)
    {
        if (this.shopGpsInfoMapper.updateByPrimaryKeySelective(shopGpsInfo) != 1)
        {
            return false;
        }
        this.clearRedis(shopGpsInfo.getShopEntityId());
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
