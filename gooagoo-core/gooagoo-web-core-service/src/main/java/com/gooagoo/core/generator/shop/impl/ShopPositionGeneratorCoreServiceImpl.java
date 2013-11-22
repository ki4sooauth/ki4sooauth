package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.shop.ShopPositionGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopPositionMapper;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class ShopPositionGeneratorCoreServiceImpl implements ShopPositionGeneratorCoreService
{

    @Autowired
    private ShopPositionMapper shopPositionMapper;

    @Override
    public Integer countByExample(ShopPositionExample shopPositionExample)
    {
        return this.shopPositionMapper.countByExample(shopPositionExample);
    }

    @Override
    public List<ShopPosition> selectByExample(ShopPositionExample shopPositionExample)
    {
        return this.shopPositionMapper.selectByExample(shopPositionExample);
    }

    @Override
    public ShopPosition selectUnDelByPrimaryKey(String primaryKey)
    {
        ShopPositionKey shopPositionKey = new ShopPositionKey();
        shopPositionKey.setIsDel("N");
        shopPositionKey.setPositionId(primaryKey);
        return this.shopPositionMapper.selectByPrimaryKey(shopPositionKey);
    }

    @Override
    public ShopPosition selectByPrimaryKey(String primaryKey)
    {
        ShopPositionKey shopPositionKey = new ShopPositionKey();
        shopPositionKey.setPositionId(primaryKey);
        return this.shopPositionMapper.selectByPrimaryKey(shopPositionKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopPositionExample shopPositionExample)
    {
        List<ShopPosition> list = this.shopPositionMapper.selectByExample(shopPositionExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopPositionMapper.deleteByExample(shopPositionExample) != list.size())
        {
            return false;
        }
        for (ShopPosition item : list)
        {
            this.clearRedis(item.getPositionId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        ShopPositionKey shopPositionKey = new ShopPositionKey();
        shopPositionKey.setPositionId(primaryKey);
        if (this.shopPositionMapper.deleteByPrimaryKey(shopPositionKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(ShopPositionExample shopPositionExample)
    {
        List<ShopPosition> list = this.shopPositionMapper.selectByExample(shopPositionExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ShopPosition shopPosition = new ShopPosition();
        shopPosition.setIsDel("Y");
        if (this.shopPositionMapper.updateByExampleSelective(shopPosition, shopPositionExample) != list.size())
        {
            return false;
        }
        for (ShopPosition item : list)
        {
            this.clearRedis(item.getPositionId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        ShopPosition shopPosition = new ShopPosition();
        shopPosition.setPositionId(primaryKey);
        shopPosition.setIsDel("Y");
        if (this.shopPositionMapper.updateByPrimaryKeySelective(shopPosition) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(ShopPosition shopPosition)
    {
        return this.shopPositionMapper.insertSelective(shopPosition) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopPosition shopPosition, ShopPositionExample shopPositionExample)
    {
        List<ShopPosition> list = this.shopPositionMapper.selectByExample(shopPositionExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopPositionMapper.updateByExampleSelective(shopPosition, shopPositionExample) != list.size())
        {
            return false;
        }
        for (ShopPosition item : list)
        {
            this.clearRedis(item.getPositionId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopPosition shopPosition)
    {
        if (this.shopPositionMapper.updateByPrimaryKeySelective(shopPosition) != 1)
        {
            return false;
        }
        this.clearRedis(shopPosition.getPositionId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param positionId 位置编号
     */
    private void clearRedis(String positionId)
    {
        if (StringUtils.hasText(positionId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_position);
            base.del(positionId);
        }
    }

}
