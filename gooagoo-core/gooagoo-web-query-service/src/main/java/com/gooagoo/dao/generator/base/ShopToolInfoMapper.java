package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.base.ShopToolInfoKey;

public interface ShopToolInfoMapper
{

    public Integer countByExample(ShopToolInfoExample shopToolInfoExample);

    public List<ShopToolInfo> selectByExample(ShopToolInfoExample shopToolInfoExample);

    public ShopToolInfo selectByPrimaryKey(ShopToolInfoKey shopToolInfoKey);

}
