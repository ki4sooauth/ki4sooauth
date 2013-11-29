package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.BillAddInfoGeneratorCoreService;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.BillAddInfoKey;
import com.gooagoo.dao.generator.bill.BillAddInfoMapper;

@Service
public class BillAddInfoGeneratorCoreServiceImpl implements BillAddInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(BillAddInfoExample billAddInfoExample) 
    {
        return this.billAddInfoMapper.deleteByExample(billAddInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        BillAddInfoKey billAddInfoKey = new BillAddInfoKey();
        billAddInfoKey.setOrderDetailId(primaryKey);
        return this.billAddInfoMapper.deleteByPrimaryKey(billAddInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(BillAddInfoExample billAddInfoExample) 
    {
        BillAddInfo billAddInfo = new BillAddInfo();
        billAddInfo.setIsDel("Y");
        return this.billAddInfoMapper.updateByExampleSelective(billAddInfo,billAddInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        BillAddInfo billAddInfo = new BillAddInfo();
        billAddInfo.setOrderDetailId(primaryKey);
        billAddInfo.setIsDel("Y");
        return this.billAddInfoMapper.updateByPrimaryKeySelective(billAddInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(BillAddInfo billAddInfo) 
    {
        return this.billAddInfoMapper.insertSelective(billAddInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(BillAddInfo billAddInfo,BillAddInfoExample billAddInfoExample) 
    {
        return this.billAddInfoMapper.updateByExampleSelective(billAddInfo,billAddInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(BillAddInfo billAddInfo) 
    {
        return this.billAddInfoMapper.updateByPrimaryKeySelective(billAddInfo) > 0 ? true : false;
    }

}
