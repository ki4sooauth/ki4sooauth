package com.gooagoo.api.business.query.member.card;

public interface CheckCardQueryService
{
    /**
     * 验证刷卡信息（店员助理或转发器）
     * gtsc11
     * @param shopId 商家编号
     * @param scardno 会员卡音频编号
     * @return Boolean
     * @throws Exception
     */
    public Boolean checkCard(String shopId, String scardno) throws Exception;

}
