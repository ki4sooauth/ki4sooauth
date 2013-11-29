package com.gooagoo.core.generator.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.bill.OriginalBillPicGeneratorCoreService;
import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.OriginalBillPicExample;
import com.gooagoo.entity.generator.bill.OriginalBillPicKey;
import com.gooagoo.dao.generator.bill.OriginalBillPicMapper;

@Service
public class OriginalBillPicGeneratorCoreServiceImpl implements OriginalBillPicGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(OriginalBillPicExample originalBillPicExample) 
    {
        return this.originalBillPicMapper.deleteByExample(originalBillPicExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        OriginalBillPicKey originalBillPicKey = new OriginalBillPicKey();
        originalBillPicKey.setBillDetailId(primaryKey);
        return this.originalBillPicMapper.deleteByPrimaryKey(originalBillPicKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OriginalBillPic originalBillPic) 
    {
        return this.originalBillPicMapper.insertSelective(originalBillPic) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OriginalBillPic originalBillPic,OriginalBillPicExample originalBillPicExample) 
    {
        return this.originalBillPicMapper.updateByExampleSelective(originalBillPic,originalBillPicExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OriginalBillPic originalBillPic) 
    {
        return this.originalBillPicMapper.updateByPrimaryKeySelective(originalBillPic) > 0 ? true : false;
    }

}
