package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.BillPayApplicationKey;

public interface BillPayApplicationMapper
{

    public Integer countByExample(BillPayApplicationExample billPayApplicationExample);

    public List<BillPayApplication> selectByExample(BillPayApplicationExample billPayApplicationExample);

    public BillPayApplication selectByPrimaryKey(BillPayApplicationKey billPayApplicationKey);

    public Integer deleteByExample(BillPayApplicationExample billPayApplicationExample);

    public Integer deleteByPrimaryKey(BillPayApplicationKey billPayApplicationKey);

    public Integer insertSelective(BillPayApplication billPayApplication);

    public Integer updateAllByExample(@Param("record") BillPayApplication billPayApplication, @Param("example") BillPayApplicationExample billPayApplicationExample);

    public Integer updateByExampleSelective(@Param("record") BillPayApplication billPayApplication, @Param("example") BillPayApplicationExample billPayApplicationExample);

    public Integer updateByPrimaryKeySelective(BillPayApplication billPayApplication);

}
