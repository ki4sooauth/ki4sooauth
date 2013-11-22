package com.gooagoo.api.generator.core.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.bill.OriginalBillPicExample;

public interface OriginalBillPicGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于查询表中对应数据条数
     * @param originalBillPicExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(OriginalBillPicExample originalBillPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param originalBillPicExample 查询条件
     * @return 
     */
    public List<OriginalBillPic> selectByExample(OriginalBillPicExample originalBillPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public OriginalBillPic selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param originalBillPicExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(OriginalBillPicExample originalBillPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于往表中添加数据
     * @param originalBillPic 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(OriginalBillPic originalBillPic) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param originalBillPic 更新数据
     * @param originalBillPicExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(OriginalBillPic originalBillPic,OriginalBillPicExample originalBillPicExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表original_bill_pic用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param originalBillPic 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(OriginalBillPic originalBillPic) ;

}
