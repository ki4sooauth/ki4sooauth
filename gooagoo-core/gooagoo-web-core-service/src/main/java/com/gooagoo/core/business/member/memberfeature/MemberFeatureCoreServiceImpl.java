package com.gooagoo.core.business.member.memberfeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.member.memberfeature.MemberFeatureCoreService;
import com.gooagoo.api.generator.core.member.MemberFeatureGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberFeatureInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MemberFeatureCoreServiceImpl implements MemberFeatureCoreService
{
    @Autowired
    private MemberFeatureGeneratorCoreService memberFeatureGeneratorCoreService;
    @Autowired
    private MemberFeatureInfoGeneratorCoreService memberFeatureInfoGeneratorCoreService;

    @Override
    public boolean addMemberFeature(MemberFeature memberFeature) throws Exception
    {
        memberFeature.setIsDel("N");
        return this.memberFeatureGeneratorCoreService.insertSelective(memberFeature);
    }

    @Override
    public boolean updateMemberFeature(MemberFeature memberFeature) throws Exception
    {
        return this.memberFeatureGeneratorCoreService.updateByPrimaryKeySelective(memberFeature);
    }

    @Override
    public boolean deleteMemberFeature(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除会员特征项：Id为空");
            return false;
        }
        return this.memberFeatureGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateMemberFeatureInfos(String shopId, String userId, String phyNo, String scardNo, List<String> featureCodes, List<String> featureValues) throws Exception
    {
        if (featureCodes == null || featureCodes.size() == 0 || featureValues == null)
        {
            GooagooLog.info("修改会员特征值：featureCodes或featureValues为空，featureValues=" + featureValues + ",featureCodes=" + featureCodes);
            return false;
        }
        if (featureValues.size() != featureCodes.size())
        {
            GooagooLog.info("更新会员特征值：featureCodes或featureValues长度不一致，featureValueSize=" + featureValues.size() + ",featureCodeSize=" + featureCodes.size());
            return false;
        }
        //存放页面提交数据
        Map<String, String> featureValueMap = new HashMap<String, String>();
        for (int i = 0; i < featureCodes.size(); i++)
        {
            String code = featureCodes.get(i);
            featureValueMap.put(code, featureValues.get(i));
        }
        Map<String, String> featureInfoMap = new HashMap<String, String>();//key:MemberFeatureInfo.featureCode,value:A-添加，N+ID-修改，Y+ID-删除

        //查询会员特征值的历史数据
        MemberFeatureInfoExample memberFeatureInfoExample = new MemberFeatureInfoExample();
        memberFeatureInfoExample.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userId);
        List<MemberFeatureInfo> featureInfos = this.memberFeatureInfoGeneratorCoreService.selectByExample(memberFeatureInfoExample);
        if (featureInfos == null)
        {
            featureInfos = new ArrayList<MemberFeatureInfo>();
        }
        //历史数据处理：添加的权限若存在于历史数据使用历史数据
        for (Iterator<MemberFeatureInfo> iterator = featureInfos.iterator(); iterator.hasNext();)
        {
            MemberFeatureInfo mf = iterator.next();
            String code = mf.getFeatureCode();
            if (!featureCodes.contains(code))
            {
                featureInfoMap.put(code, "Y" + mf.getId());
            }
            else
            {
                featureInfoMap.put(code, "N" + mf.getId());
                featureCodes.remove(code);
            }
        }
        //添加历史数据中没有的特征值，重复的不处理
        for (Iterator<String> iterator = featureCodes.iterator(); iterator.hasNext();)
        {
            String code = iterator.next();
            if (!featureInfoMap.containsKey(code))
            {
                featureInfoMap.put(code, "A");
            }
        }
        //根据特征值数据类型进行数据保存操作
        for (Iterator<String> iterator = featureInfoMap.keySet().iterator(); iterator.hasNext();)
        {
            String key = iterator.next();
            String value = featureInfoMap.get(key);
            MemberFeatureInfo memberFeatureInfo = new MemberFeatureInfo();
            memberFeatureInfo.setShopId(shopId);
            memberFeatureInfo.setUserId(userId);
            memberFeatureInfo.setPhyNo(phyNo);
            memberFeatureInfo.setScardNo(scardNo);
            memberFeatureInfo.setFeatureCode(key);
            String featureValue = featureValueMap.get(key);
            memberFeatureInfo.setFeatureValue(featureValue);
            boolean isOk = false;
            if ("A".equals(value))
            {
                memberFeatureInfo.setIsDel("N");
                memberFeatureInfo.setId(com.gooagoo.common.utils.StringUtils.getUUID());
                isOk = this.memberFeatureInfoGeneratorCoreService.insertSelective(memberFeatureInfo);
            }
            else
            {
                memberFeatureInfo.setId(value.substring(1));
                memberFeatureInfo.setIsDel(value.substring(0, 1));
                isOk = this.memberFeatureInfoGeneratorCoreService.updateByPrimaryKeySelective(memberFeatureInfo);
            }
            if (!isOk)
            {
                GooagooLog.warn("修改会员特征值失败:mapValue=" + value + ",obj=" + new Gson().toJson(memberFeatureInfo));
                throw new OperateFailException("修改会员特征值失败");
            }
        }
        return true;
    }
}
