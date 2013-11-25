package com.gooagoo.api.generator.core.base;

import java.util.List;

import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;

public interface PromptingMessageGeneratorCoreService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于查询表中对应数据条数
     * @param promptingMessageExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(PromptingMessageExample promptingMessageExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param promptingMessageExample 查询条件
     * @return 
     */
    public List<PromptingMessage> selectByExample(PromptingMessageExample promptingMessageExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于查询数据
     * @param promptingMessageKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public PromptingMessage selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public PromptingMessage selectByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param promptingMessageExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(PromptingMessageExample promptingMessageExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于逻辑删除数据（修改is_del值为Y)
     * @param promptingMessageExample 删除条件
     * @return true-逻辑删除数据成功 false-逻辑删除数据失败
     */
    public boolean deleteByExample(PromptingMessageExample promptingMessageExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于逻辑删除数据（修改is_del值为Y)
     * @param primaryKey 删除条件 主键
     * @return true-逻辑删除成功 false-逻辑删除失败
     */
    public boolean deleteByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于往表中添加数据
     * @param promptingMessage 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(PromptingMessage promptingMessage) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param promptingMessage 更新数据
     * @param promptingMessageExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(PromptingMessage promptingMessage,PromptingMessageExample promptingMessageExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表prompting_message用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param promptingMessage 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(PromptingMessage promptingMessage) ;

}