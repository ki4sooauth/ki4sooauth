package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillDetailExample;
import com.gooagoo.entity.generator.bill.OriginalBillDetailKey;

public interface OriginalBillDetailMapper
{

    public Integer countByExample(OriginalBillDetailExample originalBillDetailExample);

    public List<OriginalBillDetail> selectByExample(OriginalBillDetailExample originalBillDetailExample);

    public OriginalBillDetail selectByPrimaryKey(OriginalBillDetailKey originalBillDetailKey);

    public Integer deleteByExample(OriginalBillDetailExample originalBillDetailExample);

    public Integer deleteByPrimaryKey(OriginalBillDetailKey originalBillDetailKey);

    public Integer insertSelective(OriginalBillDetail originalBillDetail);

    public Integer updateAllByExample(@Param("record") OriginalBillDetail originalBillDetail, @Param("example") OriginalBillDetailExample originalBillDetailExample);

    public Integer updateByExampleSelective(@Param("record") OriginalBillDetail originalBillDetail, @Param("example") OriginalBillDetailExample originalBillDetailExample);

    public Integer updateByPrimaryKeySelective(OriginalBillDetail originalBillDetail);

}
