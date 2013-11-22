package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderPicExample;
import com.gooagoo.entity.generator.bill.ShopOrderPicKey;

public interface ShopOrderPicMapper
{

    public Integer countByExample(ShopOrderPicExample shopOrderPicExample);

    public List<ShopOrderPic> selectByExample(ShopOrderPicExample shopOrderPicExample);

    public ShopOrderPic selectByPrimaryKey(ShopOrderPicKey shopOrderPicKey);

    public Integer deleteByExample(ShopOrderPicExample shopOrderPicExample);

    public Integer deleteByPrimaryKey(ShopOrderPicKey shopOrderPicKey);

    public Integer insertSelective(ShopOrderPic shopOrderPic);

    public Integer updateAllByExample(@Param("record") ShopOrderPic shopOrderPic, @Param("example") ShopOrderPicExample shopOrderPicExample);

    public Integer updateByExampleSelective(@Param("record") ShopOrderPic shopOrderPic, @Param("example") ShopOrderPicExample shopOrderPicExample);

    public Integer updateByPrimaryKeySelective(ShopOrderPic shopOrderPic);

}
