package com.gooagoo.api.business.core.user.notice;

/**
 * 通知管理
 */
public interface UserNoticeCoreService
{

    /**
    * 删除用户关联通知
    * @param ids(多个用逗号隔开)
    * @return
    * @throws Exception
    */
    public boolean deleteNotice(String ids) throws Exception;

}
