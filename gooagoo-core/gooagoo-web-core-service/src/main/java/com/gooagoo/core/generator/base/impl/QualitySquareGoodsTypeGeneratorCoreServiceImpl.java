package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.QualitySquareGoodsTypeGeneratorCoreService;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeKey;
import com.gooagoo.dao.generator.base.QualitySquareGoodsTypeMapper;

@Service
public class QualitySquareGoodsTypeGeneratorCoreServiceImpl implements QualitySquareGoodsTypeGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample) 
    {
        return this.qualitySquareGoodsTypeMapper.deleteByExample(qualitySquareGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        QualitySquareGoodsTypeKey qualitySquareGoodsTypeKey = new QualitySquareGoodsTypeKey();
        qualitySquareGoodsTypeKey.setGoodsTypeId(primaryKey);
        return this.qualitySquareGoodsTypeMapper.deleteByPrimaryKey(qualitySquareGoodsTypeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample) 
    {
        QualitySquareGoodsType qualitySquareGoodsType = new QualitySquareGoodsType();
        qualitySquareGoodsType.setIsDel("Y");
        return this.qualitySquareGoodsTypeMapper.updateByExampleSelective(qualitySquareGoodsType,qualitySquareGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        QualitySquareGoodsType qualitySquareGoodsType = new QualitySquareGoodsType();
        qualitySquareGoodsType.setGoodsTypeId(primaryKey);
        qualitySquareGoodsType.setIsDel("Y");
        return this.qualitySquareGoodsTypeMapper.updateByPrimaryKeySelective(qualitySquareGoodsType) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(QualitySquareGoodsType qualitySquareGoodsType) 
    {
        return this.qualitySquareGoodsTypeMapper.insertSelective(qualitySquareGoodsType) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(QualitySquareGoodsType qualitySquareGoodsType,QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample) 
    {
        return this.qualitySquareGoodsTypeMapper.updateByExampleSelective(qualitySquareGoodsType,qualitySquareGoodsTypeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(QualitySquareGoodsType qualitySquareGoodsType) 
    {
        return this.qualitySquareGoodsTypeMapper.updateByPrimaryKeySelective(qualitySquareGoodsType) > 0 ? true : false;
    }

}
