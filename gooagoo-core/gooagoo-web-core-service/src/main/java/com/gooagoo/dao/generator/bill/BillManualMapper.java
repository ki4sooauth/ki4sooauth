package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.entity.generator.bill.BillManualExample;
import com.gooagoo.entity.generator.bill.BillManualKey;

public interface BillManualMapper
{

    public Integer countByExample(BillManualExample billManualExample);

    public List<BillManual> selectByExample(BillManualExample billManualExample);

    public BillManual selectByPrimaryKey(BillManualKey billManualKey);

    public Integer deleteByExample(BillManualExample billManualExample);

    public Integer deleteByPrimaryKey(BillManualKey billManualKey);

    public Integer insertSelective(BillManual billManual);

    public Integer updateAllByExample(@Param("record") BillManual billManual, @Param("example") BillManualExample billManualExample);

    public Integer updateByExampleSelective(@Param("record") BillManual billManual, @Param("example") BillManualExample billManualExample);

    public Integer updateByPrimaryKeySelective(BillManual billManual);

}
