package com.gooagoo.api.generator.query.base;

import java.util.List;

import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;

public interface PromptingMessageGeneratorQueryService
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

}
