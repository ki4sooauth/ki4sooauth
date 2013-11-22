package com.gooagoo.igus.shop.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IShopService
{
    /**
     * 获取商家列表
     * @param request
     * @return
     */
    TransData<Object> getShopList(HttpServletRequest request);

    /**
     * 查询会员信息（做修改操作）
     * @param request
     * @return
     */
    TransData<Object> getMemberBaseInfo(HttpServletRequest request);

    /**
     * 修改会员信息
     * @param request
     * @return
     */
    TransData<Object> updateMemberBaseInfo(HttpServletRequest request);

    /**
     * 物理卡转换申请
     * @param request
     * @return
     */
    TransData<Object> phyCardConvertApply(HttpServletRequest request);

    /**
     * 关注商家
     * @param request
     * @return
     */
    TransData<Object> attention(HttpServletRequest request);

    /**
     * 申请会员
     * @param request
     * @return
     */
    TransData<Object> memberApply(HttpServletRequest request);

    /**
     * 取消关注
     * @param request
     * @return
     */
    TransData<Object> removeAttention(HttpServletRequest request);

    /**
     * 删除会员
     * @param request
     * @return
     */
    TransData<Object> removeMember(HttpServletRequest request);

}
