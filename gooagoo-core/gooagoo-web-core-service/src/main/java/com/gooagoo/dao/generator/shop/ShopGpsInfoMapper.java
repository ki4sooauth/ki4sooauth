package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfoKey;

public interface ShopGpsInfoMapper
{

    public Integer countByExample(ShopGpsInfoExample shopGpsInfoExample);

    public List<ShopGpsInfo> selectByExample(ShopGpsInfoExample shopGpsInfoExample);

    public ShopGpsInfo selectByPrimaryKey(ShopGpsInfoKey shopGpsInfoKey);

    public Integer deleteByExample(ShopGpsInfoExample shopGpsInfoExample);

    public Integer deleteByPrimaryKey(ShopGpsInfoKey shopGpsInfoKey);

    public Integer insertSelective(ShopGpsInfo shopGpsInfo);

    public Integer updateAllByExample(@Param("record") ShopGpsInfo shopGpsInfo, @Param("example") ShopGpsInfoExample shopGpsInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopGpsInfo shopGpsInfo, @Param("example") ShopGpsInfoExample shopGpsInfoExample);

    public Integer updateByPrimaryKeySelective(ShopGpsInfo shopGpsInfo);

}
