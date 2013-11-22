package com.gooagoo.api.business.query.member.query;

import java.util.List;

import com.gooagoo.entity.business.member.MemberBaseInfoAdapter;
import com.gooagoo.entity.business.member.ShopMemberDetail;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;

public interface ShopMemberQueryService
{

    /**
     * 会员查询会员信息
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void findMemberInfo(String userId, String shopId) throws Exception;

    /**
     * 店里所有会员列表查询
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void findMemberList(String userId, String shopId) throws Exception;

    /**
     * 店内踪迹查询
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void findTraces(String userId, String shopId) throws Exception;

    /**
     * 通过物理卡查询会员详细信息（包括会员基本信息、积分信息、会员卡基本信息、会员卡和用户关联信息）
     * @param shopId
     * @param phyCardNo 物理卡号
     * @throws Exception
     */
    public ShopMemberDetail findShopMemberDetailByPhyCardNo(String shopId, String phyCardNo) throws Exception;

    /**
     * 查询用户特征信息
     * @param shopId
     * @param userId
     * @throws Exception
     */
    public List<MemberFeatureInfo> findMemberFeatures(String shopId, String userId) throws Exception;

    /**
     * 查询会员基本信息
     * @param phyNo 物理卡号
     * @param name 姓名
     * @throws Exception
     */
    public Integer countMemberBaseInfo(MemberBaseInfo memberBaseInfo) throws Exception;

    /**
     * 查询会员基本信息
     * @param phyNo 物理卡号
     * @param name 姓名
     * @throws Exception
     */
    public List<MemberBaseInfoAdapter> findMemberBaseInfo(MemberBaseInfo memberBaseInfo, Integer pageIndex, Integer pageSize) throws Exception;

}
