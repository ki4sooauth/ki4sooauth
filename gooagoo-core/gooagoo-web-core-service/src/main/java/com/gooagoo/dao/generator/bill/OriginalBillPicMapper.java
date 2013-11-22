package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.OriginalBillPicExample;
import com.gooagoo.entity.generator.bill.OriginalBillPicKey;

public interface OriginalBillPicMapper
{

    public Integer countByExample(OriginalBillPicExample originalBillPicExample);

    public List<OriginalBillPic> selectByExample(OriginalBillPicExample originalBillPicExample);

    public OriginalBillPic selectByPrimaryKey(OriginalBillPicKey originalBillPicKey);

    public Integer deleteByExample(OriginalBillPicExample originalBillPicExample);

    public Integer deleteByPrimaryKey(OriginalBillPicKey originalBillPicKey);

    public Integer insertSelective(OriginalBillPic originalBillPic);

    public Integer updateAllByExample(@Param("record") OriginalBillPic originalBillPic, @Param("example") OriginalBillPicExample originalBillPicExample);

    public Integer updateByExampleSelective(@Param("record") OriginalBillPic originalBillPic, @Param("example") OriginalBillPicExample originalBillPicExample);

    public Integer updateByPrimaryKeySelective(OriginalBillPic originalBillPic);

}
