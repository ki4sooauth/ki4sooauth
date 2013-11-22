package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfoKey;

public interface ShopWifiinfoMapper
{

    public Integer countByExample(ShopWifiinfoExample shopWifiinfoExample);

    public List<ShopWifiinfo> selectByExample(ShopWifiinfoExample shopWifiinfoExample);

    public ShopWifiinfo selectByPrimaryKey(ShopWifiinfoKey shopWifiinfoKey);

    public Integer deleteByExample(ShopWifiinfoExample shopWifiinfoExample);

    public Integer deleteByPrimaryKey(ShopWifiinfoKey shopWifiinfoKey);

    public Integer insertSelective(ShopWifiinfo shopWifiinfo);

    public Integer updateAllByExample(@Param("record") ShopWifiinfo shopWifiinfo, @Param("example") ShopWifiinfoExample shopWifiinfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopWifiinfo shopWifiinfo, @Param("example") ShopWifiinfoExample shopWifiinfoExample);

    public Integer updateByPrimaryKeySelective(ShopWifiinfo shopWifiinfo);

}
