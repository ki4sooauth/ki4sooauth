package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.ProductSerialNumberExample;
import com.gooagoo.entity.generator.user.ProductSerialNumberKey;

public interface ProductSerialNumberMapper
{

    public Integer countByExample(ProductSerialNumberExample productSerialNumberExample);

    public List<ProductSerialNumber> selectByExample(ProductSerialNumberExample productSerialNumberExample);

    public ProductSerialNumber selectByPrimaryKey(ProductSerialNumberKey productSerialNumberKey);

}
