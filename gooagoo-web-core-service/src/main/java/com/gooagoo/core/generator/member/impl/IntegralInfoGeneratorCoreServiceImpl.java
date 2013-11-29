package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.member.IntegralInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.member.IntegralInfoMapper;
import com.gooagoo.dao.generator.member.MemberOfCardMapper;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.IntegralInfoKey;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class IntegralInfoGeneratorCoreServiceImpl implements IntegralInfoGeneratorCoreService
{

    @Autowired
    private IntegralInfoMapper integralInfoMapper;
    @Autowired
    private MemberOfCardMapper memberOfCardMapper;

    @Override
    public Integer countByExample(IntegralInfoExample integralInfoExample)
    {
        return this.integralInfoMapper.countByExample(integralInfoExample);
    }

    @Override
    public List<IntegralInfo> selectByExample(IntegralInfoExample integralInfoExample)
    {
        return this.integralInfoMapper.selectByExample(integralInfoExample);
    }

    @Override
    public IntegralInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        IntegralInfoKey integralInfoKey = new IntegralInfoKey();
        integralInfoKey.setIsDel("N");
        integralInfoKey.setIntegralId(primaryKey);
        return this.integralInfoMapper.selectByPrimaryKey(integralInfoKey);
    }

    @Override
    public IntegralInfo selectByPrimaryKey(String primaryKey)
    {
        IntegralInfoKey integralInfoKey = new IntegralInfoKey();
        integralInfoKey.setIntegralId(primaryKey);
        return this.integralInfoMapper.selectByPrimaryKey(integralInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(IntegralInfoExample integralInfoExample)
    {
        return this.integralInfoMapper.deleteByExample(integralInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        IntegralInfoKey integralInfoKey = new IntegralInfoKey();
        integralInfoKey.setIntegralId(primaryKey);
        return this.integralInfoMapper.deleteByPrimaryKey(integralInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(IntegralInfoExample integralInfoExample)
    {
        IntegralInfo integralInfo = new IntegralInfo();
        integralInfo.setIsDel("Y");
        return this.integralInfoMapper.updateByExampleSelective(integralInfo, integralInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        IntegralInfo integralInfo = new IntegralInfo();
        integralInfo.setIntegralId(primaryKey);
        integralInfo.setIsDel("Y");
        return this.integralInfoMapper.updateByPrimaryKeySelective(integralInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(IntegralInfo integralInfo)
    {
        if (this.integralInfoMapper.insertSelective(integralInfo) != 1)
        {
            return false;
        }
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andUserIdEqualTo(integralInfo.getUserId()).andShopIdEqualTo(integralInfo.getShopId());
        List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(list))
        {
            MemberOfCard memberOfCard = list.get(0);
            this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
        }
        return true;
    }

    @Override
    public boolean updateByExampleSelective(IntegralInfo integralInfo, IntegralInfoExample integralInfoExample)
    {
        return this.integralInfoMapper.updateByExampleSelective(integralInfo, integralInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(IntegralInfo integralInfo)
    {
        return this.integralInfoMapper.updateByPrimaryKeySelective(integralInfo) > 0 ? true : false;
    }

    /**
     * 清空品类redis缓存
     * @param userId 用户编号
     * @param shopId 商家编号
     */
    private void clearRedis(String userId, String shopId)
    {
        RedisDatabase base = new RedisDatabase(RedisServerConstants.business_user_shop);
        if (StringUtils.hasText(userId) && StringUtils.hasText(shopId))
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId);
            List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
            if (CollectionUtils.isNotEmpty(list))
            {
                base.del(userId + "_" + shopId);
                for (MemberOfCard item : list)
                {
                    base.del(item.getScardno());
                }
            }
        }
    }

}
