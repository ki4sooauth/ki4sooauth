package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.base.ShopInterfaceNameKey;

public interface ShopInterfaceNameMapper
{

    public Integer countByExample(ShopInterfaceNameExample shopInterfaceNameExample);

    public List<ShopInterfaceName> selectByExample(ShopInterfaceNameExample shopInterfaceNameExample);

    public ShopInterfaceName selectByPrimaryKey(ShopInterfaceNameKey shopInterfaceNameKey);

    public Integer deleteByExample(ShopInterfaceNameExample shopInterfaceNameExample);

    public Integer deleteByPrimaryKey(ShopInterfaceNameKey shopInterfaceNameKey);

    public Integer insertSelective(ShopInterfaceName shopInterfaceName);

    public Integer updateAllByExample(@Param("record") ShopInterfaceName shopInterfaceName, @Param("example") ShopInterfaceNameExample shopInterfaceNameExample);

    public Integer updateByExampleSelective(@Param("record") ShopInterfaceName shopInterfaceName, @Param("example") ShopInterfaceNameExample shopInterfaceNameExample);

    public Integer updateByPrimaryKeySelective(ShopInterfaceName shopInterfaceName);

}
