package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OriginalBillPicGeneratorQueryService;
import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.OriginalBillPicExample;
import com.gooagoo.entity.generator.bill.OriginalBillPicKey;
import com.gooagoo.dao.generator.bill.OriginalBillPicMapper;

@Service
public class OriginalBillPicGeneratorQueryServiceImpl implements OriginalBillPicGeneratorQueryService
{

    @Autowired
    private OriginalBillPicMapper originalBillPicMapper;

    @Override
    public Integer countByExample(OriginalBillPicExample originalBillPicExample) 
    {
        return this.originalBillPicMapper.countByExample(originalBillPicExample);
    }

    @Override
    public List<OriginalBillPic> selectByExample(OriginalBillPicExample originalBillPicExample) 
    {
        return this.originalBillPicMapper.selectByExample(originalBillPicExample);
    }

    @Override
    public OriginalBillPic selectByPrimaryKey(String primaryKey) 
    {
        OriginalBillPicKey originalBillPicKey = new OriginalBillPicKey();
        originalBillPicKey.setBillDetailId(primaryKey);
        return this.originalBillPicMapper.selectByPrimaryKey(originalBillPicKey);
    }

}
