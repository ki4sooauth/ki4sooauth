package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageKey;

public interface ShopTableTypeManageMapper
{

    public Integer countByExample(ShopTableTypeManageExample shopTableTypeManageExample);

    public List<ShopTableTypeManage> selectByExample(ShopTableTypeManageExample shopTableTypeManageExample);

    public ShopTableTypeManage selectByPrimaryKey(ShopTableTypeManageKey shopTableTypeManageKey);

    public Integer deleteByExample(ShopTableTypeManageExample shopTableTypeManageExample);

    public Integer deleteByPrimaryKey(ShopTableTypeManageKey shopTableTypeManageKey);

    public Integer insertSelective(ShopTableTypeManage shopTableTypeManage);

    public Integer updateAllByExample(@Param("record") ShopTableTypeManage shopTableTypeManage, @Param("example") ShopTableTypeManageExample shopTableTypeManageExample);

    public Integer updateByExampleSelective(@Param("record") ShopTableTypeManage shopTableTypeManage, @Param("example") ShopTableTypeManageExample shopTableTypeManageExample);

    public Integer updateByPrimaryKeySelective(ShopTableTypeManage shopTableTypeManage);

}
