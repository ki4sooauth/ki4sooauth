package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.BillAddInfoKey;

public interface BillAddInfoMapper
{

    public Integer countByExample(BillAddInfoExample billAddInfoExample);

    public List<BillAddInfo> selectByExample(BillAddInfoExample billAddInfoExample);

    public BillAddInfo selectByPrimaryKey(BillAddInfoKey billAddInfoKey);

    public Integer deleteByExample(BillAddInfoExample billAddInfoExample);

    public Integer deleteByPrimaryKey(BillAddInfoKey billAddInfoKey);

    public Integer insertSelective(BillAddInfo billAddInfo);

    public Integer updateAllByExample(@Param("record") BillAddInfo billAddInfo, @Param("example") BillAddInfoExample billAddInfoExample);

    public Integer updateByExampleSelective(@Param("record") BillAddInfo billAddInfo, @Param("example") BillAddInfoExample billAddInfoExample);

    public Integer updateByPrimaryKeySelective(BillAddInfo billAddInfo);

}
