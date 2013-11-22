package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.base.ShopInterfaceNameKey;

public interface ShopInterfaceNameMapper
{

    public Integer countByExample(ShopInterfaceNameExample shopInterfaceNameExample);

    public List<ShopInterfaceName> selectByExample(ShopInterfaceNameExample shopInterfaceNameExample);

    public ShopInterfaceName selectByPrimaryKey(ShopInterfaceNameKey shopInterfaceNameKey);

}
