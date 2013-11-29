package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoKey;

public interface ShopInterfaceInfoMapper
{

    public Integer countByExample(ShopInterfaceInfoExample shopInterfaceInfoExample);

    public List<ShopInterfaceInfo> selectByExample(ShopInterfaceInfoExample shopInterfaceInfoExample);

    public ShopInterfaceInfo selectByPrimaryKey(ShopInterfaceInfoKey shopInterfaceInfoKey);

    public Integer deleteByExample(ShopInterfaceInfoExample shopInterfaceInfoExample);

    public Integer deleteByPrimaryKey(ShopInterfaceInfoKey shopInterfaceInfoKey);

    public Integer insertSelective(ShopInterfaceInfo shopInterfaceInfo);

    public Integer updateAllByExample(@Param("record") ShopInterfaceInfo shopInterfaceInfo, @Param("example") ShopInterfaceInfoExample shopInterfaceInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopInterfaceInfo shopInterfaceInfo, @Param("example") ShopInterfaceInfoExample shopInterfaceInfoExample);

    public Integer updateByPrimaryKeySelective(ShopInterfaceInfo shopInterfaceInfo);

}
