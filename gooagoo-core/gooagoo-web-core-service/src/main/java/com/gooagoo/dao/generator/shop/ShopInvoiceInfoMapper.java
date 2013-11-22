package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoExample;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoKey;

public interface ShopInvoiceInfoMapper
{

    public Integer countByExample(ShopInvoiceInfoExample shopInvoiceInfoExample);

    public List<ShopInvoiceInfo> selectByExample(ShopInvoiceInfoExample shopInvoiceInfoExample);

    public ShopInvoiceInfo selectByPrimaryKey(ShopInvoiceInfoKey shopInvoiceInfoKey);

    public Integer deleteByExample(ShopInvoiceInfoExample shopInvoiceInfoExample);

    public Integer deleteByPrimaryKey(ShopInvoiceInfoKey shopInvoiceInfoKey);

    public Integer insertSelective(ShopInvoiceInfo shopInvoiceInfo);

    public Integer updateAllByExample(@Param("record") ShopInvoiceInfo shopInvoiceInfo, @Param("example") ShopInvoiceInfoExample shopInvoiceInfoExample);

    public Integer updateByExampleSelective(@Param("record") ShopInvoiceInfo shopInvoiceInfo, @Param("example") ShopInvoiceInfoExample shopInvoiceInfoExample);

    public Integer updateByPrimaryKeySelective(ShopInvoiceInfo shopInvoiceInfo);

}
