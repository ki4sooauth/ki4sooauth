package com.gooagoo.api.generator.query.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;

public interface MemberFeatureGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表member_feature用于查询表中对应数据条数
     * @param memberFeatureExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(MemberFeatureExample memberFeatureExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表member_feature用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param memberFeatureExample 查询条件
     * @return 
     */
    public List<MemberFeature> selectByExample(MemberFeatureExample memberFeatureExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表member_feature用于查询数据
     * @param memberFeatureKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public MemberFeature selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表member_feature用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public MemberFeature selectByPrimaryKey(String primaryKey) ;

}