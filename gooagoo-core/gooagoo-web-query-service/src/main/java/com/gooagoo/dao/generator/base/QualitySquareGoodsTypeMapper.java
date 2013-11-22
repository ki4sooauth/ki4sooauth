package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeKey;

public interface QualitySquareGoodsTypeMapper
{

    public Integer countByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public List<QualitySquareGoodsType> selectByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public QualitySquareGoodsType selectByPrimaryKey(QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey);

}
