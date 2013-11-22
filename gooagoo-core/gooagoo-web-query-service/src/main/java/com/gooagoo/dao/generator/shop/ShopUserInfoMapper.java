package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.entity.generator.shop.ShopUserInfoKey;

public interface ShopUserInfoMapper
{

    public Integer countByExample(ShopUserInfoExample shopUserInfoExample);

    public List<ShopUserInfo> selectByExample(ShopUserInfoExample shopUserInfoExample);

    public ShopUserInfo selectByPrimaryKey(ShopUserInfoKey shopUserInfoKey);

}
