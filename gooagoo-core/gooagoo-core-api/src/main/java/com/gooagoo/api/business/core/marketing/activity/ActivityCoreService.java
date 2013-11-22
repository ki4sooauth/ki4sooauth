package com.gooagoo.api.business.core.marketing.activity;

import com.gooagoo.entity.generator.marketing.MarketingActivity;

/**
 * 活动管理
 * @author Administrator
 *
 */
public interface ActivityCoreService
{

    /**
     *  6.2.4. 创建活动
     * @param marketingActivity
     * @return
     * @throws Exception
     */
    public boolean addActivity(MarketingActivity marketingActivity) throws Exception;

    /**
     *    6.2.5. 编辑活动
     * @param marketingActivity
     * @return
     * @throws Exception
     */
    public boolean updateActivity(MarketingActivity marketingActivity) throws Exception;

    /**
     *  6.2.6. 删除活动（删除活动规则、内容）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteActivity(String activityId) throws Exception;

    /**
     * 6.2.10. 审核活动
     * @param activityId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedActivity(String activityId, String status, String note) throws Exception;

    /**
     * 6.2.10. 发布活动
     * @param activityId
     * @return
     * @throws Exception
     */
    public boolean publishActivity(String activityId) throws Exception;

}
