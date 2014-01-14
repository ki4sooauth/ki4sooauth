package com.gooagoo.dao.generator.open;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.open.OpenAppInfo;
import com.gooagoo.entity.generator.open.OpenAppInfoExample;
import com.gooagoo.entity.generator.open.OpenAppInfoKey;

public interface OpenAppInfoMapper
{

    public Integer countByExample(OpenAppInfoExample openAppInfoExample);

    public List<OpenAppInfo> selectByExample(OpenAppInfoExample openAppInfoExample);

    public OpenAppInfo selectByPrimaryKey(OpenAppInfoKey openAppInfoKey);

    public Integer deleteByExample(OpenAppInfoExample openAppInfoExample);

    public Integer deleteByPrimaryKey(OpenAppInfoKey openAppInfoKey);

    public Integer insertSelective(OpenAppInfo openAppInfo);

    public Integer updateAllByExample(@Param("record") OpenAppInfo openAppInfo, @Param("example") OpenAppInfoExample openAppInfoExample);

    public Integer updateByExampleSelective(@Param("record") OpenAppInfo openAppInfo, @Param("example") OpenAppInfoExample openAppInfoExample);

    public Integer updateByPrimaryKeySelective(OpenAppInfo openAppInfo);

}
