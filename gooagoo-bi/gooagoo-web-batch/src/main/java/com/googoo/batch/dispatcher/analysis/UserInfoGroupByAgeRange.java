package com.googoo.batch.dispatcher.analysis;

import java.util.List;

import com.gooagoo.api.generator.query.member.ConvertApplyGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.generator.user.UserProfileExample;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.AnalysisUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Engine(BatchTimeCnstants.everyHour)
public class UserInfoGroupByAgeRange implements Tyre
{
    UserProfileGeneratorQueryService userProfileService = SpringBeanUtils.getBean(UserProfileGeneratorQueryService.class);

    MemberBaseInfoGeneratorQueryService memberBaseInfoService = SpringBeanUtils.getBean(MemberBaseInfoGeneratorQueryService.class);

    ConvertApplyGeneratorQueryService convertApplyService = SpringBeanUtils.getBean(ConvertApplyGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserInfoGroupByAgeRange");
        UserProfileExample example = new UserProfileExample();
        example.createCriteria().andBirthdayIsNotNull();
        List<UserProfile> userList = this.userProfileService.selectByExample(example);

        MemberBaseInfoExample memberExample = new MemberBaseInfoExample();
        memberExample.createCriteria().andBirthdayIsNotNull().andPhyNoIsNotNull();
        List<MemberBaseInfo> memberList = this.memberBaseInfoService.selectByExample(memberExample);

        ConvertApplyExample convertExample = new ConvertApplyExample();
        convertExample.createCriteria().andPhyNoIsNotNull().andUserIdIsNotNull();
        List<ConvertApply> convertList = this.convertApplyService.selectByExample(convertExample);

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BY_BASIC);

        if (userList != null)
        {
            for (UserProfile user : userList)
            {
                BasicDBObject query = new BasicDBObject();
                query.append("_id", user.getUserId());

                BasicDBObject bo = new BasicDBObject(query).append("_id", user.getUserId()).append("birthday", user.getBirthday());
                bo.append("age", AnalysisUtils.getAge(user.getBirthday()));
                bo.append("age_range", AnalysisUtils.getAgeRange(user.getBirthday()));

                coll.update(query, bo, true, false);
            }
        }

        if (memberList != null && convertList != null)
        {
            for (MemberBaseInfo member : memberList)
            {
                for (ConvertApply ca : convertList)
                {
                    if (member.getPhyNo() == ca.getPhyNo() || member.getPhyNo().equals(ca.getPhyNo()))
                    {
                        BasicDBObject query = new BasicDBObject();
                        query.append("_id", ca.getUserId());

                        BasicDBObject bo = new BasicDBObject(query).append("_id", ca.getUserId()).append("birthday", member.getBirthday());
                        bo.append("age", AnalysisUtils.getAge(member.getBirthday()));
                        bo.append("age_range", AnalysisUtils.getAgeRange(member.getBirthday()));

                        coll.update(query, bo, true, false);
                    }
                }

            }
        }
    }
}
