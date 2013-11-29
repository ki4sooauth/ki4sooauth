package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.user.UserMobileInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.user.UserMobileInfoMapper;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class UserMobileInfoGeneratorCoreServiceImpl implements UserMobileInfoGeneratorCoreService
{

    @Autowired
    private UserMobileInfoMapper userMobileInfoMapper;

    @Override
    public Integer countByExample(UserMobileInfoExample userMobileInfoExample)
    {
        return this.userMobileInfoMapper.countByExample(userMobileInfoExample);
    }

    @Override
    public List<UserMobileInfo> selectByExample(UserMobileInfoExample userMobileInfoExample)
    {
        return this.userMobileInfoMapper.selectByExample(userMobileInfoExample);
    }

    @Override
    public UserMobileInfo selectByPrimaryKey(String primaryKey)
    {
        UserMobileInfoKey userMobileInfoKey = new UserMobileInfoKey();
        userMobileInfoKey.setUserId(primaryKey);
        return this.userMobileInfoMapper.selectByPrimaryKey(userMobileInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserMobileInfoExample userMobileInfoExample)
    {
        return this.userMobileInfoMapper.deleteByExample(userMobileInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        UserMobileInfoKey userMobileInfoKey = new UserMobileInfoKey();
        userMobileInfoKey.setUserId(primaryKey);
        return this.userMobileInfoMapper.deleteByPrimaryKey(userMobileInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserMobileInfo userMobileInfo)
    {
        return this.userMobileInfoMapper.insertSelective(userMobileInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserMobileInfo userMobileInfo, UserMobileInfoExample userMobileInfoExample)
    {
        return this.userMobileInfoMapper.updateByExampleSelective(userMobileInfo, userMobileInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserMobileInfo userMobileInfo)
    {
        UserMobileInfoKey userMobileInfoKey = new UserMobileInfoKey();
        userMobileInfoKey.setUserId(userMobileInfo.getUserId());
        UserMobileInfo oldUserMobileInfo = this.userMobileInfoMapper.selectByPrimaryKey(userMobileInfoKey);
        if (oldUserMobileInfo == null)
        {
            return false;
        }
        this.userMobileInfoMapper.updateByPrimaryKeySelective(userMobileInfo);
        if (!userMobileInfo.getMacAddress().equals(oldUserMobileInfo.getMacAddress()))
        {
            this.clearRedis(oldUserMobileInfo.getMacAddress());
        }
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param mac mac地址
     */
    private void clearRedis(String mac)
    {
        if (StringUtils.hasText(mac))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_mac);
            base.del(mac);
        }
    }

}
