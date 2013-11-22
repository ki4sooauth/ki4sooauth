package com.gooagoo.analysis.complement.service;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;

public interface ComplementService
{
    /**
     *
     * @param behaveLog(0-消费,1-到店,2-到达区域,3-关注,4-申请会员卡,5-申请物理卡转换,6-评论,7-留言,8-收藏,9-浏览,A-使用服务,B-分享,D-下订单,E-申请结帐)
     * @return(时间段,会员等级,来源（手机/网站）,当天次数,累计次数,品类,品牌,商品,金额,区域,时长,服务类型,活动,事件,优惠凭证,虚拟商家店面)
     * @throws Exception
     */
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception;
}
