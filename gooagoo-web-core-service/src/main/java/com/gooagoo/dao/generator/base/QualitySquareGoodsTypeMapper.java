package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeKey;

public interface QualitySquareGoodsTypeMapper
{

    public Integer countByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public List<QualitySquareGoodsType> selectByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public QualitySquareGoodsType selectByPrimaryKey(QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey);

    public Integer deleteByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public Integer deleteByPrimaryKey(QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey);

    public Integer insertSelective(QualitySquareGoodsType qualitySquareGoodsType);

    public Integer updateAllByExample(@Param("record") QualitySquareGoodsType qualitySquareGoodsType, @Param("example") QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public Integer updateByExampleSelective(@Param("record") QualitySquareGoodsType qualitySquareGoodsType, @Param("example") QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample);

    public Integer updateByPrimaryKeySelective(QualitySquareGoodsType qualitySquareGoodsType);

}
