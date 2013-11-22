package com.gooagoo.igms.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.member.FMemberCard;

public interface CardService
{
    /**
     * 会员卡列表（分页）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FMemberCard>> memberCardList(HttpServletRequest request) throws Exception;


    /**
     * 添加会员卡信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 获取会员卡信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FMemberCard> getMemberCard(HttpServletRequest request) throws Exception;

    /**
     * 修改会员卡信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除会员卡信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核会员卡
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布会员卡
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> publish(HttpServletRequest request) throws Exception;

    /**
     * 查看卡是否已被发放
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> cardHasGive(HttpServletRequest request) throws Exception;

}
