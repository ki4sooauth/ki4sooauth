package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OriginalBillDetailGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillDetailExample;
import com.gooagoo.entity.generator.bill.OriginalBillDetailKey;
import com.gooagoo.dao.generator.bill.OriginalBillDetailMapper;

@Service
public class OriginalBillDetailGeneratorCoreServiceImpl implements OriginalBillDetailGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(OriginalBillDetailExample originalBillDetailExample) 
    {
        return this.originalBillDetailMapper.deleteByExample(originalBillDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OriginalBillDetailKey originalBillDetailKey = new OriginalBillDetailKey();
        originalBillDetailKey.setBillDetailId(primaryKey);
        return this.originalBillDetailMapper.deleteByPrimaryKey(originalBillDetailKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OriginalBillDetail originalBillDetail) 
    {
        return this.originalBillDetailMapper.insertSelective(originalBillDetail) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OriginalBillDetail originalBillDetail,OriginalBillDetailExample originalBillDetailExample) 
    {
        return this.originalBillDetailMapper.updateByExampleSelective(originalBillDetail,originalBillDetailExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OriginalBillDetail originalBillDetail) 
    {
        return this.originalBillDetailMapper.updateByPrimaryKeySelective(originalBillDetail) > 0 ? true : false;
    }

}
