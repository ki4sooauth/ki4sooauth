package com.gooagoo.dao.business.member.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.member.MemberBaseInfoAdapter;

public interface MemberInfoAdapterMapper
{

    /**
     * 关联会员卡与用户关联表查询会员基本信息数量
     * @param shopId 商家编号
     * @param phyNo 物理卡号
     * @param name 姓名
     * @param Integer pageIndex
     * @param Integer pageSize
     * @return
     */
    public Integer countMemberBaseInfo(@Param("shopId") String shopId, @Param("phyNo") String phyNo, @Param("name") String name);

    /**
     * 关联会员卡与用户关联表查询会员基本信息
     * @param shopId 商家编号
     * @param phyNo 物理卡号
     * @param name 姓名
     * @param Integer pageIndex
     * @param Integer pageSize
     * @return
     */
    public List<MemberBaseInfoAdapter> findMemberBaseInfo(@Param("shopId") String shopId, @Param("phyNo") String phyNo, @Param("name") String name, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
