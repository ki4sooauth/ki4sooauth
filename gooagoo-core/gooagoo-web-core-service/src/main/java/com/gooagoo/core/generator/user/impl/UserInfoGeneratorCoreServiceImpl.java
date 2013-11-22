package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.user.UserInfoMapper;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class UserInfoGeneratorCoreServiceImpl implements UserInfoGeneratorCoreService
{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer countByExample(UserInfoExample userInfoExample)
    {
        return this.userInfoMapper.countByExample(userInfoExample);
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample userInfoExample)
    {
        return this.userInfoMapper.selectByExample(userInfoExample);
    }

    @Override
    public UserInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setIsDel("N");
        userInfoKey.setUserId(primaryKey);
        return this.userInfoMapper.selectByPrimaryKey(userInfoKey);
    }

    @Override
    public UserInfo selectByPrimaryKey(String primaryKey)
    {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setUserId(primaryKey);
        return this.userInfoMapper.selectByPrimaryKey(userInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserInfoExample userInfoExample)
    {
        List<UserInfo> list = this.userInfoMapper.selectByExample(userInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.userInfoMapper.deleteByExample(userInfoExample) != list.size())
        {
            return false;
        }
        for (UserInfo item : list)
        {
            this.clearRedis(item.getUserId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setUserId(primaryKey);
        if (this.userInfoMapper.deleteByPrimaryKey(userInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(UserInfoExample userInfoExample)
    {
        List<UserInfo> list = this.userInfoMapper.selectByExample(userInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setIsDel("Y");
        if (this.userInfoMapper.updateByExampleSelective(userInfo, userInfoExample) != list.size())
        {
            return false;
        }
        for (UserInfo item : list)
        {
            this.clearRedis(item.getUserId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(primaryKey);
        userInfo.setIsDel("Y");
        if (this.userInfoMapper.updateByPrimaryKeySelective(userInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(UserInfo userInfo)
    {
        return this.userInfoMapper.insertSelective(userInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserInfo userInfo, UserInfoExample userInfoExample)
    {
        List<UserInfo> list = this.userInfoMapper.selectByExample(userInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.userInfoMapper.updateByExampleSelective(userInfo, userInfoExample) != list.size())
        {
            return false;
        }
        for (UserInfo item : list)
        {
            this.clearRedis(item.getUserId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserInfo userInfo)
    {
        if (this.userInfoMapper.updateByPrimaryKeySelective(userInfo) != 1)
        {
            return false;
        }
        this.clearRedis(userInfo.getUserId());
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
