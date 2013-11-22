package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateShop;
import com.gooagoo.entity.generator.sys.NominateShopExample;
import com.gooagoo.entity.generator.sys.NominateShopKey;

public interface NominateShopMapper
{

    public Integer countByExample(NominateShopExample nominateShopExample);

    public List<NominateShop> selectByExample(NominateShopExample nominateShopExample);

    public NominateShop selectByPrimaryKey(NominateShopKey nominateShopKey);

}
