package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.user.UserProfileGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.user.UserProfileMapper;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.generator.user.UserProfileExample;
import com.gooagoo.entity.generator.user.UserProfileKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class UserProfileGeneratorCoreServiceImpl implements UserProfileGeneratorCoreService
{

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public Integer countByExample(UserProfileExample userProfileExample)
    {
        return this.userProfileMapper.countByExample(userProfileExample);
    }

    @Override
    public List<UserProfile> selectByExample(UserProfileExample userProfileExample)
    {
        return this.userProfileMapper.selectByExample(userProfileExample);
    }

    @Override
    public UserProfile selectByPrimaryKey(String primaryKey)
    {
        UserProfileKey userProfileKey = new UserProfileKey();
        userProfileKey.setUserId(primaryKey);
        return this.userProfileMapper.selectByPrimaryKey(userProfileKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserProfileExample userProfileExample)
    {
        List<UserProfile> list = this.userProfileMapper.selectByExample(userProfileExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.userProfileMapper.deleteByExample(userProfileExample) != list.size())
        {
            return false;
        }
        for (UserProfile item : list)
        {
            this.clearRedis(item.getUserId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        UserProfileKey userProfileKey = new UserProfileKey();
        userProfileKey.setUserId(primaryKey);
        if (this.userProfileMapper.deleteByPrimaryKey(userProfileKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(UserProfile userProfile)
    {
        return this.userProfileMapper.insertSelective(userProfile) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserProfile userProfile, UserProfileExample userProfileExample)
    {
        List<UserProfile> list = this.userProfileMapper.selectByExample(userProfileExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.userProfileMapper.updateByExampleSelective(userProfile, userProfileExample) != list.size())
        {
            return false;
        }
        for (UserProfile item : list)
        {
            this.clearRedis(item.getUserId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserProfile userProfile)
    {
        if (this.userProfileMapper.updateByPrimaryKeySelective(userProfile) != 1)
        {
            return false;
        }
        this.clearRedis(userProfile.getUserId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param userId 用户编号
     */
    private void clearRedis(String userId)
    {
        if (StringUtils.hasText(userId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_user);
            base.del(userId);
        }
    }

}
