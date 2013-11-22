package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoKey;

public interface ShopInterfaceInfoMapper
{

    public Integer countByExample(ShopInterfaceInfoExample shopInterfaceInfoExample);

    public List<ShopInterfaceInfo> selectByExample(ShopInterfaceInfoExample shopInterfaceInfoExample);

    public ShopInterfaceInfo selectByPrimaryKey(ShopInterfaceInfoKey shopInterfaceInfoKey);

}
