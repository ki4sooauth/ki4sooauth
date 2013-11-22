package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.QualitySquareGoodsTypeGeneratorQueryService;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeKey;
import com.gooagoo.dao.generator.base.QualitySquareGoodsTypeMapper;

@Service
public class QualitySquareGoodsTypeGeneratorQueryServiceImpl implements QualitySquareGoodsTypeGeneratorQueryService
{

    @Autowired
    private QualitySquareGoodsTypeMapper qualitySquareGoodsTypeMapper;

    @Override
    public Integer countByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample) 
    {
        return this.qualitySquareGoodsTypeMapper.countByExample(qualitySquareGoodsTypeExample);
    }

    @Override
    public List<QualitySquareGoodsType> selectByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample) 
    {
        return this.qualitySquareGoodsTypeMapper.selectByExample(qualitySquareGoodsTypeExample);
    }

    @Override
    public QualitySquareGoodsType selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey = new QualitySquareGoodsTypeKey();
        qualitySquareGoodsTypeKey.setIsDel("N");
        qualitySquareGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.qualitySquareGoodsTypeMapper.selectByPrimaryKey(qualitySquareGoodsTypeKey);
    }

    @Override
    public QualitySquareGoodsType selectByPrimaryKey(Integer primaryKey) 
    {
        QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey = new QualitySquareGoodsTypeKey();
        qualitySquareGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.qualitySquareGoodsTypeMapper.selectByPrimaryKey(qualitySquareGoodsTypeKey);
    }

}
