package com.gooagoo.core.generator.goods.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.goods.GoodsBaseInfoMapper;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class GoodsBaseInfoGeneratorCoreServiceImpl implements GoodsBaseInfoGeneratorCoreService
{

    @Autowired
    private GoodsBaseInfoMapper goodsBaseInfoMapper;

    @Override
    public Integer countByExample(GoodsBaseInfoExample goodsBaseInfoExample)
    {
        return this.goodsBaseInfoMapper.countByExample(goodsBaseInfoExample);
    }

    @Override
    public List<GoodsBaseInfo> selectByExample(GoodsBaseInfoExample goodsBaseInfoExample)
    {
        return this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
    }

    @Override
    public GoodsBaseInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        GoodsBaseInfoKey goodsBaseInfoKey = new GoodsBaseInfoKey();
        goodsBaseInfoKey.setIsDel("N");
        goodsBaseInfoKey.setGoodsId(primaryKey);
        return this.goodsBaseInfoMapper.selectByPrimaryKey(goodsBaseInfoKey);
    }

    @Override
    public GoodsBaseInfo selectByPrimaryKey(String primaryKey)
    {
        GoodsBaseInfoKey goodsBaseInfoKey = new GoodsBaseInfoKey();
        goodsBaseInfoKey.setGoodsId(primaryKey);
        return this.goodsBaseInfoMapper.selectByPrimaryKey(goodsBaseInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(GoodsBaseInfoExample goodsBaseInfoExample)
    {
        List<GoodsBaseInfo> list = this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsBaseInfoMapper.deleteByExample(goodsBaseInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsBaseInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        GoodsBaseInfoKey goodsBaseInfoKey = new GoodsBaseInfoKey();
        goodsBaseInfoKey.setGoodsId(primaryKey);
        if (this.goodsBaseInfoMapper.deleteByPrimaryKey(goodsBaseInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(GoodsBaseInfoExample goodsBaseInfoExample)
    {
        List<GoodsBaseInfo> list = this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        GoodsBaseInfo goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setIsDel("Y");
        if (this.goodsBaseInfoMapper.updateByExampleSelective(goodsBaseInfo, goodsBaseInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsBaseInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        GoodsBaseInfo goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setGoodsId(primaryKey);
        goodsBaseInfo.setIsDel("Y");
        if (this.goodsBaseInfoMapper.updateByPrimaryKeySelective(goodsBaseInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(GoodsBaseInfo goodsBaseInfo)
    {
        return this.goodsBaseInfoMapper.insertSelective(goodsBaseInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(GoodsBaseInfo goodsBaseInfo, GoodsBaseInfoExample goodsBaseInfoExample)
    {
        List<GoodsBaseInfo> list = this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.goodsBaseInfoMapper.updateByExampleSelective(goodsBaseInfo, goodsBaseInfoExample) != list.size())
        {
            return false;
        }
        for (GoodsBaseInfo item : list)
        {
            this.clearRedis(item.getGoodsId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(GoodsBaseInfo goodsBaseInfo)
    {
        if (this.goodsBaseInfoMapper.updateByPrimaryKeySelective(goodsBaseInfo) != 1)
        {
            return false;
        }
        this.clearRedis(goodsBaseInfo.getGoodsId());
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
