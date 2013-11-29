package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.entity.generator.user.ConsigneeInfoKey;

public interface ConsigneeInfoMapper
{

    public Integer countByExample(ConsigneeInfoExample consigneeInfoExample);

    public List<ConsigneeInfo> selectByExample(ConsigneeInfoExample consigneeInfoExample);

    public ConsigneeInfo selectByPrimaryKey(ConsigneeInfoKey consigneeInfoKey);

    public Integer deleteByExample(ConsigneeInfoExample consigneeInfoExample);

    public Integer deleteByPrimaryKey(ConsigneeInfoKey consigneeInfoKey);

    public Integer insertSelective(ConsigneeInfo consigneeInfo);

    public Integer updateAllByExample(@Param("record") ConsigneeInfo consigneeInfo, @Param("example") ConsigneeInfoExample consigneeInfoExample);

    public Integer updateByExampleSelective(@Param("record") ConsigneeInfo consigneeInfo, @Param("example") ConsigneeInfoExample consigneeInfoExample);

    public Integer updateByPrimaryKeySelective(ConsigneeInfo consigneeInfo);

}
