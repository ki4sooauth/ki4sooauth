package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OriginalBillDetailGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillDetailExample;
import com.gooagoo.entity.generator.bill.OriginalBillDetailKey;
import com.gooagoo.dao.generator.bill.OriginalBillDetailMapper;

@Service
public class OriginalBillDetailGeneratorQueryServiceImpl implements OriginalBillDetailGeneratorQueryService
{

    @Autowired
    private OriginalBillDetailMapper originalBillDetailMapper;

    @Override
    public Integer countByExample(OriginalBillDetailExample originalBillDetailExample) 
    {
        return this.originalBillDetailMapper.countByExample(originalBillDetailExample);
    }

    @Override
    public List<OriginalBillDetail> selectByExample(OriginalBillDetailExample originalBillDetailExample) 
    {
        return this.originalBillDetailMapper.selectByExample(originalBillDetailExample);
    }

    @Override
    public OriginalBillDetail selectByPrimaryKey(String primaryKey) 
    {
        OriginalBillDetailKey originalBillDetailKey = new OriginalBillDetailKey();
        originalBillDetailKey.setBillDetailId(primaryKey);
        return this.originalBillDetailMapper.selectByPrimaryKey(originalBillDetailKey);
    }

}
