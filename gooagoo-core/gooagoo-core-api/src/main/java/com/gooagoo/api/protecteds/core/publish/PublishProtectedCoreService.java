package com.gooagoo.api.protecteds.core.publish;

public interface PublishProtectedCoreService
{

    /**
     * 生成静态页面(事件、CMS内容)
     * @param Object (cms内容 or 活动)
     * @param generateType 生成类型(0-购好奇、3-邮件、D-手机服务、M-手机、W-网站)
     * @return
     */
    public boolean generateEventOrCmsHtml(Object obj, String generateType) throws Exception;

    /**
     * 生成静态页面(活动、商品、优惠券)
     * @param obj (活动、商品、优惠券)
     * @param goodsIdList 已发布的单品编号列表
     * @return
     */
    public boolean generateHtml(Object obj) throws Exception;

}
