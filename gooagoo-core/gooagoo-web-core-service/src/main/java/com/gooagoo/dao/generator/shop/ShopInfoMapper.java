package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoKey;

public interface ShopInfoMapper
{

    public Integer countByExample(ShopInfoExample shopInfoExample);

    public List<ShopInfo> selectByExample(ShopInfoExample shopInfoExample);

    public ShopInfo selectByPrimaryKey(ShopInfoKey shopInfoKey);

    public Integer deleteByExample(ShopInfoExample shopInfoExample);

    public Integer deleteByPrimaryKey(ShopInfoKey shopInfoKey);

    public Integer insertSelective(ShopInfo shopInfo);

    public Integer updateAllByExample(@Param("record") ShopInfo shopInfo, @Param("example") ShopInfoExample shopInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopInfo shopInfo, @Param("example") ShopInfoExample shopInfoExample);

    public Integer updateByPrimaryKeySelective(ShopInfo shopInfo);

}
