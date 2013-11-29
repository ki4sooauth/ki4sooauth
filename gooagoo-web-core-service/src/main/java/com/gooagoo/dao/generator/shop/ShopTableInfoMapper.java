package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoKey;

public interface ShopTableInfoMapper
{

    public Integer countByExample(ShopTableInfoExample shopTableInfoExample);

    public List<ShopTableInfo> selectByExample(ShopTableInfoExample shopTableInfoExample);

    public ShopTableInfo selectByPrimaryKey(ShopTableInfoKey shopTableInfoKey);

    public Integer deleteByExample(ShopTableInfoExample shopTableInfoExample);

    public Integer deleteByPrimaryKey(ShopTableInfoKey shopTableInfoKey);

    public Integer insertSelective(ShopTableInfo shopTableInfo);

    public Integer updateAllByExample(@Param("record") ShopTableInfo shopTableInfo, @Param("example") ShopTableInfoExample shopTableInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopTableInfo shopTableInfo, @Param("example") ShopTableInfoExample shopTableInfoExample);

    public Integer updateByPrimaryKeySelective(ShopTableInfo shopTableInfo);

}
