package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.goods.GoodsMarketingInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.goods.GoodsMarketingInfoMapper;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class GoodsMarketingInfoGeneratorCoreServiceImpl implements GoodsMarketingInfoGeneratorCoreService
{

    @Autowired
    private GoodsMarketingInfoMapper goodsMarketingInfoMapper;

    @Override
    public Integer countByExample(GoodsMarketingInfoExample goodsMarketingInfoExample)
    {
        return this.goodsMarketingInfoMapper.countByExample(goodsMarketingInfoExample);
    }

    @Override
    public List<GoodsMarketingInfo> selectByExample(GoodsMarketingInfoExample goodsMarketingInfoExample)
    {
        return this.goodsMarketingInfoMapper.selectByExample(goodsMarketingInfoExample);
    }

    @Override
    public GoodsMarketingInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        GoodsMarketingInfoKey goodsMarketingInfoKey = new GoodsMarketingInfoKey();
        goodsMarketingInfoKey.setIsDel("N");
        goodsMarketingInfoKey.setGoodsId(primaryKey);
        return this.goodsMarketingInfoMapper.selectByPrimaryKey(goodsMarketingInfoKey);
    }

    @Override
    public GoodsMarketingInfo selectByPrimaryKey(String primaryKey)
    {
        GoodsMarketingInfoKey goodsMarketingInfoKey = new GoodsMarketingInfoKey();
        goodsMarketingInfoKey.setGoodsId(primaryKey);
        return this.goodsMarketingInfoMapper.selectByPrimaryKey(goodsMarketingInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(GoodsMarketingInfoExample goodsMarketingInfoExample)
    {
        List<GoodsMarketingInfo> list = this.goodsMarketingInfoMapper.selectByExample(goodsMarketingInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsMarketingInfoMapper.deleteByExample(goodsMarketingInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsMarketingInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        GoodsMarketingInfoKey goodsMarketingInfoKey = new GoodsMarketingInfoKey();
        goodsMarketingInfoKey.setGoodsId(primaryKey);
        if (this.goodsMarketingInfoMapper.deleteByPrimaryKey(goodsMarketingInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(GoodsMarketingInfoExample goodsMarketingInfoExample)
    {
        List<GoodsMarketingInfo> list = this.goodsMarketingInfoMapper.selectByExample(goodsMarketingInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        GoodsMarketingInfo goodsMarketingInfo = new GoodsMarketingInfo();
        goodsMarketingInfo.setIsDel("Y");
        if (this.goodsMarketingInfoMapper.updateByExampleSelective(goodsMarketingInfo, goodsMarketingInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsMarketingInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        GoodsMarketingInfo goodsMarketingInfo = new GoodsMarketingInfo();
        goodsMarketingInfo.setGoodsId(primaryKey);
        goodsMarketingInfo.setIsDel("Y");
        if (this.goodsMarketingInfoMapper.updateByPrimaryKeySelective(goodsMarketingInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(GoodsMarketingInfo goodsMarketingInfo)
    {
        return this.goodsMarketingInfoMapper.insertSelective(goodsMarketingInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsMarketingInfo goodsMarketingInfo, GoodsMarketingInfoExample goodsMarketingInfoExample)
    {
        List<GoodsMarketingInfo> list = this.goodsMarketingInfoMapper.selectByExample(goodsMarketingInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsMarketingInfoMapper.updateByExampleSelective(goodsMarketingInfo, goodsMarketingInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsMarketingInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsMarketingInfo goodsMarketingInfo)
    {
        if (this.goodsMarketingInfoMapper.updateByPrimaryKeySelective(goodsMarketingInfo) != 1)
        {
            return false;
        }
        this.clearRedis(goodsMarketingInfo.getGoodsId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param goodsId 商品编号
     */
    private void clearRedis(String goodsId)
    {
        if (StringUtils.hasText(goodsId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_goods);
            base.del(goodsId);
        }
    }

}
