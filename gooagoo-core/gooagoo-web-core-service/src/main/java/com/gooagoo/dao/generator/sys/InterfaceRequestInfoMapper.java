package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoKey;

public interface InterfaceRequestInfoMapper
{

    public Integer countByExample(InterfaceRequestInfoExample interfaceRequestInfoExample);

    public List<InterfaceRequestInfo> selectByExample(InterfaceRequestInfoExample interfaceRequestInfoExample);

    public InterfaceRequestInfo selectByPrimaryKey(InterfaceRequestInfoKey interfaceRequestInfoKey);

    public Integer deleteByExample(InterfaceRequestInfoExample interfaceRequestInfoExample);

    public Integer deleteByPrimaryKey(InterfaceRequestInfoKey interfaceRequestInfoKey);

    public Integer insertSelective(InterfaceRequestInfo interfaceRequestInfo);

    public Integer updateAllByExample(@Param("record") InterfaceRequestInfo interfaceRequestInfo, @Param("example") InterfaceRequestInfoExample interfaceRequestInfoExample);

    public Integer updateByExampleSelective(@Param("record") InterfaceRequestInfo interfaceRequestInfo, @Param("example") InterfaceRequestInfoExample interfaceRequestInfoExample);

    public Integer updateByPrimaryKeySelective(InterfaceRequestInfo interfaceRequestInfo);

}
