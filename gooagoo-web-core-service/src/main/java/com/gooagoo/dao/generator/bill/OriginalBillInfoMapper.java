package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillInfoExample;
import com.gooagoo.entity.generator.bill.OriginalBillInfoKey;

public interface OriginalBillInfoMapper
{

    public Integer countByExample(OriginalBillInfoExample originalBillInfoExample);

    public List<OriginalBillInfo> selectByExample(OriginalBillInfoExample originalBillInfoExample);

    public OriginalBillInfo selectByPrimaryKey(OriginalBillInfoKey originalBillInfoKey);

    public Integer deleteByExample(OriginalBillInfoExample originalBillInfoExample);

    public Integer deleteByPrimaryKey(OriginalBillInfoKey originalBillInfoKey);

    public Integer insertSelective(OriginalBillInfo originalBillInfo);

    public Integer updateAllByExample(@Param("record") OriginalBillInfo originalBillInfo, @Param("example") OriginalBillInfoExample originalBillInfoExample);

    public Integer updateByExampleSelective(@Param("record") OriginalBillInfo originalBillInfo, @Param("example") OriginalBillInfoExample originalBillInfoExample);

    public Integer updateByPrimaryKeySelective(OriginalBillInfo originalBillInfo);

}
