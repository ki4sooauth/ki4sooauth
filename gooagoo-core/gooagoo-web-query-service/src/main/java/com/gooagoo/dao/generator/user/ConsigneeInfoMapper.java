package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.entity.generator.user.ConsigneeInfoKey;

public interface ConsigneeInfoMapper
{

    public Integer countByExample(ConsigneeInfoExample consigneeInfoExample);

    public List<ConsigneeInfo> selectByExample(ConsigneeInfoExample consigneeInfoExample);

    public ConsigneeInfo selectByPrimaryKey(ConsigneeInfoKey consigneeInfoKey);

}
