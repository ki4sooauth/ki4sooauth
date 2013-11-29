package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidDetailKey;

public interface ShopLidDetailMapper
{

    public Integer countByExample(ShopLidDetailExample shopLidDetailExample);

    public List<ShopLidDetail> selectByExample(ShopLidDetailExample shopLidDetailExample);

    public ShopLidDetail selectByPrimaryKey(ShopLidDetailKey shopLidDetailKey);

    public Integer deleteByExample(ShopLidDetailExample shopLidDetailExample);

    public Integer deleteByPrimaryKey(ShopLidDetailKey shopLidDetailKey);

    public Integer insertSelective(ShopLidDetail shopLidDetail);

    public Integer updateAllByExample(@Param("record") ShopLidDetail shopLidDetail, @Param("example") ShopLidDetailExample shopLidDetailExample);

    public Integer updateByExampleSelective(@Param("record") ShopLidDetail shopLidDetail, @Param("example") ShopLidDetailExample shopLidDetailExample);

    public Integer updateByPrimaryKeySelective(ShopLidDetail shopLidDetail);

}
