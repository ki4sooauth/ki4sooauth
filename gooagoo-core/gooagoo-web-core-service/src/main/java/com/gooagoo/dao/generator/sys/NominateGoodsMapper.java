package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;
import com.gooagoo.entity.generator.sys.NominateGoodsKey;

public interface NominateGoodsMapper
{

    public Integer countByExample(NominateGoodsExample nominateGoodsExample);

    public List<NominateGoods> selectByExample(NominateGoodsExample nominateGoodsExample);

    public NominateGoods selectByPrimaryKey(NominateGoodsKey nominateGoodsKey);

    public Integer deleteByExample(NominateGoodsExample nominateGoodsExample);

    public Integer deleteByPrimaryKey(NominateGoodsKey nominateGoodsKey);

    public Integer insertSelective(NominateGoods nominateGoods);

    public Integer updateAllByExample(@Param("record") NominateGoods nominateGoods, @Param("example") NominateGoodsExample nominateGoodsExample);

    public Integer updateByExampleSelective(@Param("record") NominateGoods nominateGoods, @Param("example") NominateGoodsExample nominateGoodsExample);

    public Integer updateByPrimaryKeySelective(NominateGoods nominateGoods);

}
