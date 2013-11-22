package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoKey;

public interface InterfaceRequestInfoMapper
{

    public Integer countByExample(InterfaceRequestInfoExample interfaceRequestInfoExample);

    public List<InterfaceRequestInfo> selectByExample(InterfaceRequestInfoExample interfaceRequestInfoExample);

    public InterfaceRequestInfo selectByPrimaryKey(InterfaceRequestInfoKey interfaceRequestInfoKey);

}
