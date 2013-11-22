package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.ProductSerialNumberGeneratorQueryService;
import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.ProductSerialNumberExample;
import com.gooagoo.entity.generator.user.ProductSerialNumberKey;
import com.gooagoo.dao.generator.user.ProductSerialNumberMapper;

@Service
public class ProductSerialNumberGeneratorQueryServiceImpl implements ProductSerialNumberGeneratorQueryService
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

}
