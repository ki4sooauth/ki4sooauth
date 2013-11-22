package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.GeneratrixInfoExample;
import com.gooagoo.entity.generator.shop.GeneratrixInfoKey;

public interface GeneratrixInfoMapper
{

    public Integer countByExample(GeneratrixInfoExample generatrixInfoExample);

    public List<GeneratrixInfo> selectByExample(GeneratrixInfoExample generatrixInfoExample);

    public GeneratrixInfo selectByPrimaryKey(GeneratrixInfoKey generatrixInfoKey);

}
