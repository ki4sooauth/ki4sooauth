package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoKey;

public interface InterfaceBaseInfoMapper
{

    public Integer countByExample(InterfaceBaseInfoExample interfaceBaseInfoExample);

    public List<InterfaceBaseInfo> selectByExample(InterfaceBaseInfoExample interfaceBaseInfoExample);

    public InterfaceBaseInfo selectByPrimaryKey(InterfaceBaseInfoKey interfaceBaseInfoKey);

    public Integer deleteByExample(InterfaceBaseInfoExample interfaceBaseInfoExample);

    public Integer deleteByPrimaryKey(InterfaceBaseInfoKey interfaceBaseInfoKey);

    public Integer insertSelective(InterfaceBaseInfo interfaceBaseInfo);

    public Integer updateAllByExample(@Param("record") InterfaceBaseInfo interfaceBaseInfo, @Param("example") InterfaceBaseInfoExample interfaceBaseInfoExample);

    public Integer updateByExampleSelective(@Param("record") InterfaceBaseInfo interfaceBaseInfo, @Param("example") InterfaceBaseInfoExample interfaceBaseInfoExample);

    public Integer updateByPrimaryKeySelective(InterfaceBaseInfo interfaceBaseInfo);

}
