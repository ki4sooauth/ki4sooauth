package com.gooagoo.api.business.core.system.resource.recommend;

import com.gooagoo.entity.generator.sys.NominateActivity;

/**
 *  推荐活动管理
 */
public interface RecommendActivityCoreService

{

    /**
     * 新增推荐活动
     * @param nominateActivity
     * @return
     * @throws Exception
     */
    public boolean addRecommendActivity(NominateActivity nominateActivity) throws Exception;

    /**
     * 编辑推荐活动
     * @param nominateActivity
     * @return
     * @throws Exception
     */
    public boolean updateRecommendActivity(NominateActivity nominateActivity) throws Exception;

    /**
     * 删除推荐活动
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delRecommendActivity(String id) throws Exception;

}
