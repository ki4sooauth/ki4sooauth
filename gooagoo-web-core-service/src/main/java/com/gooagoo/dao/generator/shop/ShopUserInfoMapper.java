package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.entity.generator.shop.ShopUserInfoKey;

public interface ShopUserInfoMapper
{

    public Integer countByExample(ShopUserInfoExample shopUserInfoExample);

    public List<ShopUserInfo> selectByExample(ShopUserInfoExample shopUserInfoExample);

    public ShopUserInfo selectByPrimaryKey(ShopUserInfoKey shopUserInfoKey);

    public Integer deleteByExample(ShopUserInfoExample shopUserInfoExample);

    public Integer deleteByPrimaryKey(ShopUserInfoKey shopUserInfoKey);

    public Integer insertSelective(ShopUserInfo shopUserInfo);

    public Integer updateAllByExample(@Param("record") ShopUserInfo shopUserInfo, @Param("example") ShopUserInfoExample shopUserInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopUserInfo shopUserInfo, @Param("example") ShopUserInfoExample shopUserInfoExample);

    public Integer updateByPrimaryKeySelective(ShopUserInfo shopUserInfo);

}
