package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.ReceiptInfoGeneratorQueryService;
import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.entity.generator.user.ReceiptInfoExample;
import com.gooagoo.entity.generator.user.ReceiptInfoKey;
import com.gooagoo.dao.generator.user.ReceiptInfoMapper;

@Service
public class ReceiptInfoGeneratorQueryServiceImpl implements ReceiptInfoGeneratorQueryService
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

}
