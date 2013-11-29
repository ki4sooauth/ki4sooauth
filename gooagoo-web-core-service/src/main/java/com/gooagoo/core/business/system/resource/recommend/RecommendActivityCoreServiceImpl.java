package com.gooagoo.core.business.system.resource.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.resource.recommend.RecommendActivityCoreService;
import com.gooagoo.api.generator.core.sys.NominateActivityGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateActivity;

@Service
public class RecommendActivityCoreServiceImpl implements RecommendActivityCoreService

{
    @Autowired
    private NominateActivityGeneratorCoreService nominateActivityGeneratorCoreService;

    @Override
    public boolean addRecommendActivity(NominateActivity nominateActivity) throws Exception
    {
        nominateActivity.setIsDel("N");
        return this.nominateActivityGeneratorCoreService.insertSelective(nominateActivity);
    }

    @Override
    public boolean delRecommendActivity(String id) throws Exception
    {
        NominateActivity nominateActivity = new NominateActivity();
        nominateActivity.setId(id);
        nominateActivity.setIsDel("Y");
        return this.nominateActivityGeneratorCoreService.updateByPrimaryKeySelective(nominateActivity);
    }

    @Override
    public boolean updateRecommendActivity(NominateActivity nominateActivity) throws Exception
    {
        return this.nominateActivityGeneratorCoreService.updateByPrimaryKeySelective(nominateActivity);
    }
}
