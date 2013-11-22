package com.gooagoo.dao.generator.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.OriginalBillPicExample;
import com.gooagoo.entity.generator.bill.OriginalBillPicKey;

public interface OriginalBillPicMapper
{

    public Integer countByExample(OriginalBillPicExample originalBillPicExample);

    public List<OriginalBillPic> selectByExample(OriginalBillPicExample originalBillPicExample);

    public OriginalBillPic selectByPrimaryKey(OriginalBillPicKey originalBillPicKey);

}
