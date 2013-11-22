package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.ReceiptInfoGeneratorCoreService;
import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.entity.generator.user.ReceiptInfoExample;
import com.gooagoo.entity.generator.user.ReceiptInfoKey;
import com.gooagoo.dao.generator.user.ReceiptInfoMapper;

@Service
public class ReceiptInfoGeneratorCoreServiceImpl implements ReceiptInfoGeneratorCoreService
{

    @Autowired
    private ReceiptInfoMapper receiptInfoMapper;

    @Override
    public Integer countByExample(ReceiptInfoExample receiptInfoExample) 
    {
        return this.receiptInfoMapper.countByExample(receiptInfoExample);
    }

    @Override
    public List<ReceiptInfo> selectByExample(ReceiptInfoExample receiptInfoExample) 
    {
        return this.receiptInfoMapper.selectByExample(receiptInfoExample);
    }

    @Override
    public ReceiptInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ReceiptInfoKey receiptInfoKey = new ReceiptInfoKey();
        receiptInfoKey.setIsDel("N");
        receiptInfoKey.setReceiptId(primaryKey);
        return this.receiptInfoMapper.selectByPrimaryKey(receiptInfoKey);
    }

    @Override
    public ReceiptInfo selectByPrimaryKey(String primaryKey) 
    {
        ReceiptInfoKey receiptInfoKey = new ReceiptInfoKey();
        receiptInfoKey.setReceiptId(primaryKey);
        return this.receiptInfoMapper.selectByPrimaryKey(receiptInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ReceiptInfoExample receiptInfoExample) 
    {
        return this.receiptInfoMapper.deleteByExample(receiptInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ReceiptInfoKey receiptInfoKey = new ReceiptInfoKey();
        receiptInfoKey.setReceiptId(primaryKey);
        return this.receiptInfoMapper.deleteByPrimaryKey(receiptInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ReceiptInfoExample receiptInfoExample) 
    {
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setIsDel("Y");
        return this.receiptInfoMapper.updateByExampleSelective(receiptInfo,receiptInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setReceiptId(primaryKey);
        receiptInfo.setIsDel("Y");
        return this.receiptInfoMapper.updateByPrimaryKeySelective(receiptInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ReceiptInfo receiptInfo) 
    {
        return this.receiptInfoMapper.insertSelective(receiptInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ReceiptInfo receiptInfo,ReceiptInfoExample receiptInfoExample) 
    {
        return this.receiptInfoMapper.updateByExampleSelective(receiptInfo,receiptInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ReceiptInfo receiptInfo) 
    {
        return this.receiptInfoMapper.updateByPrimaryKeySelective(receiptInfo) > 0 ? true : false;
    }

}
