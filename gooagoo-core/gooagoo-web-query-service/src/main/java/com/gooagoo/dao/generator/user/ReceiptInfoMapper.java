package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.entity.generator.user.ReceiptInfoExample;
import com.gooagoo.entity.generator.user.ReceiptInfoKey;

public interface ReceiptInfoMapper
{

    public Integer countByExample(ReceiptInfoExample receiptInfoExample);

    public List<ReceiptInfo> selectByExample(ReceiptInfoExample receiptInfoExample);

    public ReceiptInfo selectByPrimaryKey(ReceiptInfoKey receiptInfoKey);

}
