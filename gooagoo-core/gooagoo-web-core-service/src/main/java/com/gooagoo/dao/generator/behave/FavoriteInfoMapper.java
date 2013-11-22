package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoKey;

public interface FavoriteInfoMapper
{

    public Integer countByExample(FavoriteInfoExample favoriteInfoExample);

    public List<FavoriteInfo> selectByExample(FavoriteInfoExample favoriteInfoExample);

    public FavoriteInfo selectByPrimaryKey(FavoriteInfoKey favoriteInfoKey);

    public Integer deleteByExample(FavoriteInfoExample favoriteInfoExample);

    public Integer deleteByPrimaryKey(FavoriteInfoKey favoriteInfoKey);

    public Integer insertSelective(FavoriteInfo favoriteInfo);

    public Integer updateAllByExample(@Param("record") FavoriteInfo favoriteInfo, @Param("example") FavoriteInfoExample favoriteInfoExample);

    public Integer updateByExampleSelective(@Param("record") FavoriteInfo favoriteInfo, @Param("example") FavoriteInfoExample favoriteInfoExample);

    public Integer updateByPrimaryKeySelective(FavoriteInfo favoriteInfo);

}
