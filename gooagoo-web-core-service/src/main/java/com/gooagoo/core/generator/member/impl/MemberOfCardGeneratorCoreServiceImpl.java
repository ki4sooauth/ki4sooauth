package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.member.MemberOfCardMapper;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class MemberOfCardGeneratorCoreServiceImpl implements MemberOfCardGeneratorCoreService
{

    @Autowired
    private MemberOfCardMapper memberOfCardMapper;

    @Override
    public Integer countByExample(MemberOfCardExample memberOfCardExample)
    {
        return this.memberOfCardMapper.countByExample(memberOfCardExample);
    }

    @Override
    public List<MemberOfCard> selectByExample(MemberOfCardExample memberOfCardExample)
    {
        return this.memberOfCardMapper.selectByExample(memberOfCardExample);
    }

    @Override
    public MemberOfCard selectUnDelByPrimaryKey(String primaryKey)
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setIsDel("N");
        memberOfCardKey.setScardno(primaryKey);
        return this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
    }

    @Override
    public MemberOfCard selectByPrimaryKey(String primaryKey)
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setScardno(primaryKey);
        return this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
    }

    @Override
    public boolean physicalDeleteByExample(MemberOfCardExample memberOfCardExample)
    {
        List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.memberOfCardMapper.deleteByExample(memberOfCardExample) != list.size())
        {
            return false;
        }
        for (MemberOfCard item : list)
        {
            this.clearRedis(item.getUserId(), item.getShopId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setScardno(primaryKey);
        MemberOfCard memberOfCard = this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
        if (memberOfCard == null)
        {
            return false;
        }
        if (this.memberOfCardMapper.deleteByPrimaryKey(memberOfCardKey) != 1)
        {
            return false;
        }
        this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
        return true;
    }

    @Override
    public boolean deleteByExample(MemberOfCardExample memberOfCardExample)
    {
        List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        MemberOfCard memberOfCard = new MemberOfCard();
        memberOfCard.setIsDel("Y");
        if (this.memberOfCardMapper.updateByExampleSelective(memberOfCard, memberOfCardExample) != list.size())
        {
            return false;
        }
        for (MemberOfCard item : list)
        {
            this.clearRedis(item.getUserId(), item.getShopId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setScardno(primaryKey);
        memberOfCardKey.setIsDel("N");
        MemberOfCard memberOfCard = this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
        if (memberOfCard == null)
        {
            return false;
        }
        memberOfCard.setIsDel("Y");
        if (this.memberOfCardMapper.updateByPrimaryKeySelective(memberOfCard) != 1)
        {
            return false;
        }
        this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
        return true;
    }

    @Override
    public boolean insertSelective(MemberOfCard memberOfCard)
    {
        return this.memberOfCardMapper.insertSelective(memberOfCard) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberOfCard memberOfCard, MemberOfCardExample memberOfCardExample)
    {
        List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.memberOfCardMapper.updateByExampleSelective(memberOfCard, memberOfCardExample) != list.size())
        {
            return false;
        }
        for (MemberOfCard item : list)
        {
            this.clearRedis(item.getUserId(), item.getShopId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberOfCard memberOfCard)
    {
        if (this.memberOfCardMapper.updateByPrimaryKeySelective(memberOfCard) != 1)
        {
            return false;
        }
        this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
        return true;
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
