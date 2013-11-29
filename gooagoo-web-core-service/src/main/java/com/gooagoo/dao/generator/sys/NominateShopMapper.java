package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.NominateShop;
import com.gooagoo.entity.generator.sys.NominateShopExample;
import com.gooagoo.entity.generator.sys.NominateShopKey;

public interface NominateShopMapper
{

    public Integer countByExample(NominateShopExample nominateShopExample);

    public List<NominateShop> selectByExample(NominateShopExample nominateShopExample);

    public NominateShop selectByPrimaryKey(NominateShopKey nominateShopKey);

    public Integer deleteByExample(NominateShopExample nominateShopExample);

    public Integer deleteByPrimaryKey(NominateShopKey nominateShopKey);

    public Integer insertSelective(NominateShop nominateShop);

    public Integer updateAllByExample(@Param("record") NominateShop nominateShop, @Param("example") NominateShopExample nominateShopExample);

    public Integer updateByExampleSelective(@Param("record") NominateShop nominateShop, @Param("example") NominateShopExample nominateShopExample);

    public Integer updateByPrimaryKeySelective(NominateShop nominateShop);

}
