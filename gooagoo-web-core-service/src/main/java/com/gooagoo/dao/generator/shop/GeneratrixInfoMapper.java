package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.GeneratrixInfoExample;
import com.gooagoo.entity.generator.shop.GeneratrixInfoKey;

public interface GeneratrixInfoMapper
{

    public Integer countByExample(GeneratrixInfoExample generatrixInfoExample);

    public List<GeneratrixInfo> selectByExample(GeneratrixInfoExample generatrixInfoExample);

    public GeneratrixInfo selectByPrimaryKey(GeneratrixInfoKey generatrixInfoKey);

    public Integer deleteByExample(GeneratrixInfoExample generatrixInfoExample);

    public Integer deleteByPrimaryKey(GeneratrixInfoKey generatrixInfoKey);

    public Integer insertSelective(GeneratrixInfo generatrixInfo);

    public Integer updateAllByExample(@Param("record") GeneratrixInfo generatrixInfo, @Param("example") GeneratrixInfoExample generatrixInfoExample);

    public Integer updateByExampleSelective(@Param("record") GeneratrixInfo generatrixInfo, @Param("example") GeneratrixInfoExample generatrixInfoExample);

    public Integer updateByPrimaryKeySelective(GeneratrixInfo generatrixInfo);

}
