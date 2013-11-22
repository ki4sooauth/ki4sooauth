package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoKey;

public interface FavoriteInfoMapper
{

    public Integer countByExample(FavoriteInfoExample favoriteInfoExample);

    public List<FavoriteInfo> selectByExample(FavoriteInfoExample favoriteInfoExample);

    public FavoriteInfo selectByPrimaryKey(FavoriteInfoKey favoriteInfoKey);

}
