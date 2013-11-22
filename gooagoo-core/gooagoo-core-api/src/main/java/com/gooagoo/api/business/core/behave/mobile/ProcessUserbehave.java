package com.gooagoo.api.business.core.behave.mobile;

public interface ProcessUserbehave
{

    /**
     * 记录用户使用手机行为
     * @param behavior (由三部分组成,以“|”分隔
     *        ,第一部分是行为类型编码:01-浏览商品、02-浏览优惠劵、03-浏览活动、04-浏览通知、05-浏览吆喝
     *        ,第二部分是行为对象:营销内容与用户关联表主键
     *        ,第三部分是行为时间段:行为发生时间-YYYYMMDD HHMMSS,行为结束时间-YYYYMMDD HHMMSS)
     * @return
     * @throws Exception
     */
    public boolean processUserMobileBehave(String behavior) throws Exception;

}
