package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.ProductSerialNumberExample;
import com.gooagoo.entity.generator.user.ProductSerialNumberKey;

public interface ProductSerialNumberMapper
{

    public Integer countByExample(ProductSerialNumberExample productSerialNumberExample);

    public List<ProductSerialNumber> selectByExample(ProductSerialNumberExample productSerialNumberExample);

    public ProductSerialNumber selectByPrimaryKey(ProductSerialNumberKey productSerialNumberKey);

    public Integer deleteByExample(ProductSerialNumberExample productSerialNumberExample);

    public Integer deleteByPrimaryKey(ProductSerialNumberKey productSerialNumberKey);

    public Integer insertSelective(ProductSerialNumber productSerialNumber);

    public Integer updateAllByExample(@Param("record") ProductSerialNumber productSerialNumber, @Param("example") ProductSerialNumberExample productSerialNumberExample);

    public Integer updateByExampleSelective(@Param("record") ProductSerialNumber productSerialNumber, @Param("example") ProductSerialNumberExample productSerialNumberExample);

    public Integer updateByPrimaryKeySelective(ProductSerialNumber productSerialNumber);

}
