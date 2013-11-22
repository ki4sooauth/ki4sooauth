package com.gooagoo.api.business.query.member.card;

import java.util.List;

import com.gooagoo.entity.business.member.MemberOfCardBusiness;

public interface UserCardQueryService
{

    /**
     * 查询用户会员卡列表
     * moba01
     * @param userId
     * @param shopId 选填
     * @param ctimestamp 
     * @param pageSize 页面大小
     * @return List<MemberOfCardBusiness> 
     * @throws Exception
     */
    public List<MemberOfCardBusiness> findUserMemberCardList(String userId, String shopId, String ctimestamp, Integer pageSize) throws Exception;

    /**
     * 查询用户会员卡总数量
     * moba01
     * @param userId
     * @param shopId 
     * @throws Exception
     */
    public Integer countUserMemberCardList(String userId, String shopId) throws Exception;

}
