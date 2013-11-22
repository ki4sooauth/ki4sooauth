package com.gooagoo.query.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.BillAddInfoGeneratorQueryService;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.BillAddInfoKey;
import com.gooagoo.dao.generator.bill.BillAddInfoMapper;

@Service
public class BillAddInfoGeneratorQueryServiceImpl implements BillAddInfoGeneratorQueryService
{

    @Autowired
    private BillAddInfoMapper billAddInfoMapper;

    @Override
    public Integer countByExample(BillAddInfoExample billAddInfoExample) 
    {
        return this.billAddInfoMapper.countByExample(billAddInfoExample);
    }

    @Override
    public List<BillAddInfo> selectByExample(BillAddInfoExample billAddInfoExample) 
    {
        return this.billAddInfoMapper.selectByExample(billAddInfoExample);
    }

    @Override
    public BillAddInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        BillAddInfoKey billAddInfoKey = new BillAddInfoKey();
        billAddInfoKey.setIsDel("N");
        billAddInfoKey.setOrderDetailId(primaryKey);
        return this.billAddInfoMapper.selectByPrimaryKey(billAddInfoKey);
    }

    @Override
    public BillAddInfo selectByPrimaryKey(String primaryKey) 
    {
        BillAddInfoKey billAddInfoKey = new BillAddInfoKey();
        billAddInfoKey.setOrderDetailId(primaryKey);
        return this.billAddInfoMapper.selectByPrimaryKey(billAddInfoKey);
    }

}
