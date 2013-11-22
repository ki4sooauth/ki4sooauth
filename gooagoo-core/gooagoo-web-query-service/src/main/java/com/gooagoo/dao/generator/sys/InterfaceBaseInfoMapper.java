package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoKey;

public interface InterfaceBaseInfoMapper
{

    public Integer countByExample(InterfaceBaseInfoExample interfaceBaseInfoExample);

    public List<InterfaceBaseInfo> selectByExample(InterfaceBaseInfoExample interfaceBaseInfoExample);

    public InterfaceBaseInfo selectByPrimaryKey(InterfaceBaseInfoKey interfaceBaseInfoKey);

}
