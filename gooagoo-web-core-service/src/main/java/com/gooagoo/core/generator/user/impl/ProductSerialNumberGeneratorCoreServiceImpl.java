package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.ProductSerialNumberGeneratorCoreService;
import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.ProductSerialNumberExample;
import com.gooagoo.entity.generator.user.ProductSerialNumberKey;
import com.gooagoo.dao.generator.user.ProductSerialNumberMapper;

@Service
public class ProductSerialNumberGeneratorCoreServiceImpl implements ProductSerialNumberGeneratorCoreService
{

    @Autowired
    private ProductSerialNumberMapper productSerialNumberMapper;

    @Override
    public Integer countByExample(ProductSerialNumberExample productSerialNumberExample) 
    {
        return this.productSerialNumberMapper.countByExample(productSerialNumberExample);
    }

    @Override
    public List<ProductSerialNumber> selectByExample(ProductSerialNumberExample productSerialNumberExample) 
    {
        return this.productSerialNumberMapper.selectByExample(productSerialNumberExample);
    }

    @Override
    public ProductSerialNumber selectByPrimaryKey(String primaryKey) 
    {
        ProductSerialNumberKey productSerialNumberKey = new ProductSerialNumberKey();
        productSerialNumberKey.setGooagooId(primaryKey);
        return this.productSerialNumberMapper.selectByPrimaryKey(productSerialNumberKey);
    }

    @Override
    public boolean physicalDeleteByExample(ProductSerialNumberExample productSerialNumberExample) 
    {
        return this.productSerialNumberMapper.deleteByExample(productSerialNumberExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ProductSerialNumberKey productSerialNumberKey = new ProductSerialNumberKey();
        productSerialNumberKey.setGooagooId(primaryKey);
        return this.productSerialNumberMapper.deleteByPrimaryKey(productSerialNumberKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ProductSerialNumber productSerialNumber) 
    {
        return this.productSerialNumberMapper.insertSelective(productSerialNumber) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ProductSerialNumber productSerialNumber,ProductSerialNumberExample productSerialNumberExample) 
    {
        return this.productSerialNumberMapper.updateByExampleSelective(productSerialNumber,productSerialNumberExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ProductSerialNumber productSerialNumber) 
    {
        return this.productSerialNumberMapper.updateByPrimaryKeySelective(productSerialNumber) > 0 ? true : false;
    }

}
