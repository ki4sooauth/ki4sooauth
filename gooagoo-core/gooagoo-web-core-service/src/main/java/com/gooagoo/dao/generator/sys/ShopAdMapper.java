package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopAdKey;

public interface ShopAdMapper
{

    public Integer countByExample(ShopAdExample shopAdExample);

    public List<ShopAd> selectByExample(ShopAdExample shopAdExample);

    public ShopAd selectByPrimaryKey(ShopAdKey shopAdKey);

    public Integer deleteByExample(ShopAdExample shopAdExample);

    public Integer deleteByPrimaryKey(ShopAdKey shopAdKey);

    public Integer insertSelective(ShopAd shopAd);

    public Integer updateAllByExample(@Param("record") ShopAd shopAd, @Param("example") ShopAdExample shopAdExample);

    public Integer updateByExampleSelective(@Param("record") ShopAd shopAd, @Param("example") ShopAdExample shopAdExample);

    public Integer updateByPrimaryKeySelective(ShopAd shopAd);

}
