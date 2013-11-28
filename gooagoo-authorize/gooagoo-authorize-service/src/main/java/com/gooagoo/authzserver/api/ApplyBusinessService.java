package com.gooagoo.authzserver.api;

import com.gooagoo.authzserver.entity.apply.ApplyBusiness;

public interface ApplyBusinessService
{
    /**
     * 获取应用信息
     */
    public ApplyBusiness getApplyBusiness(ApplyBusiness applyBusiness);

    /**
     * 添加应用信息
     */
    public void addApplyBusiness(ApplyBusiness applyBusiness);

    /**
     * 获取accessToken|刷新token更新应用信息
     */
    public void editApplyBusiness(ApplyBusiness applyBusiness);

    /**
     * 过期删除应用信息
     */
    public void delApplyBusiness(ApplyBusiness applyBusiness);
}
