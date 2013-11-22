package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoKey;
import com.gooagoo.dao.generator.behave.FavoriteInfoMapper;

@Service
public class FavoriteInfoGeneratorQueryServiceImpl implements FavoriteInfoGeneratorQueryService
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

}
