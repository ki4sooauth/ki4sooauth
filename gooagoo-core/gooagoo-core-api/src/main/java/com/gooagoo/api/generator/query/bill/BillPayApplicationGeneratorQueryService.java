package com.gooagoo.api.generator.query.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;

public interface BillPayApplicationGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表bill_pay_application用于查询表中对应数据条数
     * @param billPayApplicationExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(BillPayApplicationExample billPayApplicationExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表bill_pay_application用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param billPayApplicationExample 查询条件
     * @return 
     */
    public List<BillPayApplication> selectByExample(BillPayApplicationExample billPayApplicationExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表bill_pay_application用于查询数据
     * @param billPayApplicationKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public BillPayApplication selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表bill_pay_application用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public BillPayApplication selectByPrimaryKey(String primaryKey) ;

}
