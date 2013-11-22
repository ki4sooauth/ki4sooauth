package com.gooagoo.api.generator.core.bill;

import java.util.List;

import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderDetailExample;

public interface UserOrderDetailGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于查询表中对应数据条数
     * @param userOrderDetailExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(UserOrderDetailExample userOrderDetailExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param userOrderDetailExample 查询条件
     * @return 
     */
    public List<UserOrderDetail> selectByExample(UserOrderDetailExample userOrderDetailExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public UserOrderDetail selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param userOrderDetailExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(UserOrderDetailExample userOrderDetailExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于往表中添加数据
     * @param userOrderDetail 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(UserOrderDetail userOrderDetail) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param userOrderDetail 更新数据
     * @param userOrderDetailExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(UserOrderDetail userOrderDetail,UserOrderDetailExample userOrderDetailExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_order_detail用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param userOrderDetail 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(UserOrderDetail userOrderDetail) ;

}
