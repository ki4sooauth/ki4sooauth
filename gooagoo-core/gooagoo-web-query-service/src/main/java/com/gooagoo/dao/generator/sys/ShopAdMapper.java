package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopAdKey;

public interface ShopAdMapper
{

    public Integer countByExample(ShopAdExample shopAdExample);

    public List<ShopAd> selectByExample(ShopAdExample shopAdExample);

    public ShopAd selectByPrimaryKey(ShopAdKey shopAdKey);

}
