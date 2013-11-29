package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.FavoriteInfoGeneratorCoreService;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoKey;
import com.gooagoo.dao.generator.behave.FavoriteInfoMapper;

@Service
public class FavoriteInfoGeneratorCoreServiceImpl implements FavoriteInfoGeneratorCoreService
{

    @Autowired
    private FavoriteInfoMapper favoriteInfoMapper;

    @Override
    public Integer countByExample(FavoriteInfoExample favoriteInfoExample) 
    {
        return this.favoriteInfoMapper.countByExample(favoriteInfoExample);
    }

    @Override
    public List<FavoriteInfo> selectByExample(FavoriteInfoExample favoriteInfoExample) 
    {
        return this.favoriteInfoMapper.selectByExample(favoriteInfoExample);
    }

    @Override
    public FavoriteInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        FavoriteInfoKey favoriteInfoKey = new FavoriteInfoKey();
        favoriteInfoKey.setIsDel("N");
        favoriteInfoKey.setFavoriteId(primaryKey);
        return this.favoriteInfoMapper.selectByPrimaryKey(favoriteInfoKey);
    }

    @Override
    public FavoriteInfo selectByPrimaryKey(String primaryKey) 
    {
        FavoriteInfoKey favoriteInfoKey = new FavoriteInfoKey();
        favoriteInfoKey.setFavoriteId(primaryKey);
        return this.favoriteInfoMapper.selectByPrimaryKey(favoriteInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(FavoriteInfoExample favoriteInfoExample) 
    {
        return this.favoriteInfoMapper.deleteByExample(favoriteInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        FavoriteInfoKey favoriteInfoKey = new FavoriteInfoKey();
        favoriteInfoKey.setFavoriteId(primaryKey);
        return this.favoriteInfoMapper.deleteByPrimaryKey(favoriteInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(FavoriteInfoExample favoriteInfoExample) 
    {
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setIsDel("Y");
        return this.favoriteInfoMapper.updateByExampleSelective(favoriteInfo,favoriteInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setFavoriteId(primaryKey);
        favoriteInfo.setIsDel("Y");
        return this.favoriteInfoMapper.updateByPrimaryKeySelective(favoriteInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(FavoriteInfo favoriteInfo) 
    {
        return this.favoriteInfoMapper.insertSelective(favoriteInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(FavoriteInfo favoriteInfo,FavoriteInfoExample favoriteInfoExample) 
    {
        return this.favoriteInfoMapper.updateByExampleSelective(favoriteInfo,favoriteInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(FavoriteInfo favoriteInfo) 
    {
        return this.favoriteInfoMapper.updateByPrimaryKeySelective(favoriteInfo) > 0 ? true : false;
    }

}
