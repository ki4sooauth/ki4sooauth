package com.gooagoo.mobile.api;

/**
 * 用户手机行为相关接口
 */
public interface UserBehaveMobileService
{
    /**
     * 接口 mobj01 : 记录用户使用手机行为 
     * @param userId 用户编号
     * @param behavior 用户使用手机行为，由三部分组成，以“|”分隔，第一部分是行为类型编码（2位字符）， 第二部分是行为对象（例如商品编号），第三部分是行为时间段（行为发生时间：YYYYMMDD HHMMSS,行为结束时间：YYYYMMDD HHMMSS）。 
     * @return
     * @throws Exception
     */
    public boolean recordUserbehave(String userId, String behavior) throws Exception;
}
