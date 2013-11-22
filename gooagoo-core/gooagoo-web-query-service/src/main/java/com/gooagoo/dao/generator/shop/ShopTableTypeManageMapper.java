package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageKey;

public interface ShopTableTypeManageMapper
{

    public Integer countByExample(ShopTableTypeManageExample shopTableTypeManageExample);

    public List<ShopTableTypeManage> selectByExample(ShopTableTypeManageExample shopTableTypeManageExample);

    public ShopTableTypeManage selectByPrimaryKey(ShopTableTypeManageKey shopTableTypeManageKey);

}
