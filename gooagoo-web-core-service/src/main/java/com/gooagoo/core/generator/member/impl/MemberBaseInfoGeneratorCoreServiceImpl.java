package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.member.MemberBaseInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.member.MemberBaseInfoMapper;
import com.gooagoo.dao.generator.member.MemberOfCardMapper;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfoKey;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class MemberBaseInfoGeneratorCoreServiceImpl implements MemberBaseInfoGeneratorCoreService
{

    @Autowired
    private MemberBaseInfoMapper memberBaseInfoMapper;
    @Autowired
    private MemberOfCardMapper memberOfCardMapper;

    @Override
    public Integer countByExample(MemberBaseInfoExample memberBaseInfoExample)
    {
        return this.memberBaseInfoMapper.countByExample(memberBaseInfoExample);
    }

    @Override
    public List<MemberBaseInfo> selectByExample(MemberBaseInfoExample memberBaseInfoExample)
    {
        return this.memberBaseInfoMapper.selectByExample(memberBaseInfoExample);
    }

    @Override
    public MemberBaseInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        MemberBaseInfoKey memberBaseInfoKey = new MemberBaseInfoKey();
        memberBaseInfoKey.setIsDel("N");
        memberBaseInfoKey.setId(primaryKey);
        return this.memberBaseInfoMapper.selectByPrimaryKey(memberBaseInfoKey);
    }

    @Override
    public MemberBaseInfo selectByPrimaryKey(String primaryKey)
    {
        MemberBaseInfoKey memberBaseInfoKey = new MemberBaseInfoKey();
        memberBaseInfoKey.setId(primaryKey);
        return this.memberBaseInfoMapper.selectByPrimaryKey(memberBaseInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(MemberBaseInfoExample memberBaseInfoExample)
    {
        return this.memberBaseInfoMapper.deleteByExample(memberBaseInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        MemberBaseInfoKey memberBaseInfoKey = new MemberBaseInfoKey();
        memberBaseInfoKey.setId(primaryKey);
        return this.memberBaseInfoMapper.deleteByPrimaryKey(memberBaseInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MemberBaseInfoExample memberBaseInfoExample)
    {
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setIsDel("Y");
        return this.memberBaseInfoMapper.updateByExampleSelective(memberBaseInfo, memberBaseInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
        memberBaseInfo.setId(primaryKey);
        memberBaseInfo.setIsDel("Y");
        return this.memberBaseInfoMapper.updateByPrimaryKeySelective(memberBaseInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MemberBaseInfo memberBaseInfo)
    {
        return this.memberBaseInfoMapper.insertSelective(memberBaseInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberBaseInfo memberBaseInfo, MemberBaseInfoExample memberBaseInfoExample)
    {
        List<MemberBaseInfo> memberBaseInfoList = this.memberBaseInfoMapper.selectByExample(memberBaseInfoExample);
        if (CollectionUtils.isEmpty(memberBaseInfoList))
        {
            return false;
        }
        if (this.memberBaseInfoMapper.updateByExampleSelective(memberBaseInfo, memberBaseInfoExample) != memberBaseInfoList.size())
        {
            return false;
        }
        for (MemberBaseInfo item : memberBaseInfoList)
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andPhyCardNoEqualTo(item.getPhyNo()).andShopIdEqualTo(item.getShopId()).andIsDelEqualTo("N");
            List<MemberOfCard> memberOfCardList = this.memberOfCardMapper.selectByExample(memberOfCardExample);
            if (CollectionUtils.isNotEmpty(memberOfCardList))
            {
                MemberOfCard memberOfCard = memberOfCardList.get(0);
                this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
            }
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberBaseInfo memberBaseInfo)
    {
        if (this.memberBaseInfoMapper.updateByPrimaryKeySelective(memberBaseInfo) != 1)
        {
            return false;
        }
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andPhyCardNoEqualTo(memberBaseInfo.getPhyNo()).andShopIdEqualTo(memberBaseInfo.getShopId()).andIsDelEqualTo("N");
        List<MemberOfCard> list = this.memberOfCardMapper.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(list))
        {
            MemberOfCard memberOfCard = list.get(0);
            this.clearRedis(memberOfCard.getUserId(), memberOfCard.getShopId());
        }
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
