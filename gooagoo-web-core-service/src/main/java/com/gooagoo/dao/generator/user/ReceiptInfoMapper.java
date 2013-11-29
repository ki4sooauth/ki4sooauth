package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.entity.generator.user.ReceiptInfoExample;
import com.gooagoo.entity.generator.user.ReceiptInfoKey;

public interface ReceiptInfoMapper
{

    public Integer countByExample(ReceiptInfoExample receiptInfoExample);

    public List<ReceiptInfo> selectByExample(ReceiptInfoExample receiptInfoExample);

    public ReceiptInfo selectByPrimaryKey(ReceiptInfoKey receiptInfoKey);

    public Integer deleteByExample(ReceiptInfoExample receiptInfoExample);

    public Integer deleteByPrimaryKey(ReceiptInfoKey receiptInfoKey);

    public Integer insertSelective(ReceiptInfo receiptInfo);

    public Integer updateAllByExample(@Param("record") ReceiptInfo receiptInfo, @Param("example") ReceiptInfoExample receiptInfoExample);

    public Integer updateByExampleSelective(@Param("record") ReceiptInfo receiptInfo, @Param("example") ReceiptInfoExample receiptInfoExample);

    public Integer updateByPrimaryKeySelective(ReceiptInfo receiptInfo);

}
