package com.gooagoo.api.business.query.member.query;

import java.util.List;

import com.gooagoo.entity.business.member.MemberBaseInfoBusiness;
import com.gooagoo.entity.business.member.MemberInfoBusiness;

public interface UserMemberQueryService
{

    /**
     * 查询会员信息
     * @param userId
     * @param shopId
     * @param scardno
     * @return MemberInfoBusiness
     */
    public MemberInfoBusiness findMemberInfo(String userId, String shopId, String scardno) throws Exception;

    /**
     * 会员特征管理列表查询
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void findMemberFeatureList(String userId, String shopId) throws Exception;

    /**
     * 查询会员特征信息
     * @param userId
     * @param shopId
     * @throws Exception
     */
    public void findMemberFeature(String userId, String shopId) throws Exception;

    /**
     * 店员查询店内区域会员列表
     * gase01
     * @param shopId
     * @param positionid
     * @throws Exception
     */
    public List<MemberBaseInfoBusiness> findMemberListInPosition(String shopId, String positionid, Integer pageIndex, Integer pageSize) throws Exception;

}
