package com.gooagoo.api.business.query.system.cms;

public interface SysCmsContentQueryService
{

    /**
     * 获取手机虚拟商家、网站虚拟商家访问路径
     * @param shopId 商家编号
     * @param channelType 栏目分类:M-手机、W-网站
     * @return String 手机虚拟商家、网站虚拟商家访问路径
     * @throws Exception
     */
    public String getCmsContentUrl(String shopId, String channelType) throws Exception;

}
