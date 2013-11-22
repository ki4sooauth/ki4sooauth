package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;
import com.gooagoo.entity.generator.sys.NominateGoodsKey;

public interface NominateGoodsMapper
{

    public Integer countByExample(NominateGoodsExample nominateGoodsExample);

    public List<NominateGoods> selectByExample(NominateGoodsExample nominateGoodsExample);

    public NominateGoods selectByPrimaryKey(NominateGoodsKey nominateGoodsKey);

}
