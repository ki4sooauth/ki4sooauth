package com.gooagoo.api.generator.core.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;

public interface ServiceToolSortGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于查询表中对应数据条数
     * @param serviceToolSortExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(ServiceToolSortExample serviceToolSortExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param serviceToolSortExample 查询条件
     * @return 
     */
    public List<ServiceToolSort> selectByExample(ServiceToolSortExample serviceToolSortExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public ServiceToolSort selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param serviceToolSortExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(ServiceToolSortExample serviceToolSortExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于往表中添加数据
     * @param serviceToolSort 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(ServiceToolSort serviceToolSort) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param serviceToolSort 更新数据
     * @param serviceToolSortExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(ServiceToolSort serviceToolSort,ServiceToolSortExample serviceToolSortExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表service_tool_sort用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param serviceToolSort 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(ServiceToolSort serviceToolSort) ;

}
