package com.gooagoo.analysis.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.converter.service.ConverterService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.entity.business.log.BehaveLog;

@Service("behaveLogConverterService")
public class BehaveLogConverterServiceImpl implements ConverterService
{

    @Autowired
    private UserAccountQueryService userAccountQueryService;

    @Override
    public List<Behave> getBehave(Object object) throws Exception
    {
        List<Behave> behaveList = new ArrayList<Behave>();

        BehaveLog behaveLog = (BehaveLog) object;
        Behave behave = new Behave();

        behave.setBehaveId(behaveLog.getBehaveId());//消息流水号
        behave.setAccount(behaveLog.getAccount());//用户名
        behave.setUserId(behaveLog.getUserId());//用户编号
        behave.setScardno(behaveLog.getScardno());//会员卡音频编号（电子卡号）
        behave.setMobile(behaveLog.getMobile());//手机号
        behave.setPhyCardNo(behaveLog.getPhyCardNo());//物理卡号
        behave.setGooagooID(behaveLog.getGooagooID());//gooagooID，平台分配给手机设备的唯一编号
        behave.setIpAddress(behaveLog.getIpAddress());//IP地址
        behave.setEcAccount(behaveLog.getEcAccount());//电子商务帐号

        if (StringUtils.hasText(behaveLog.getMacAddress()))
        {
            behave.setMacAddress(behaveLog.getMacAddress());//MAC地址
        }
        else
        {
            if (StringUtils.hasText(behaveLog.getUserId()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("0", behaveLog.getUserId()));
            }
            else if (StringUtils.hasText(behaveLog.getScardno()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("6", behaveLog.getScardno()));
            }
            else if (StringUtils.hasText(behaveLog.getMobile()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("5", behaveLog.getMobile()));
            }
            else if (StringUtils.hasText(behaveLog.getPhyCardNo()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("7", behaveLog.getPhyCardNo()));
            }
            else if (StringUtils.hasText(behaveLog.getGooagooID()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("1", behaveLog.getGooagooID()));
            }
            else if (StringUtils.hasText(behaveLog.getIpAddress()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("2", behaveLog.getIpAddress()));
            }
            else if (StringUtils.hasText(behaveLog.getEcAccount()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("8", behaveLog.getEcAccount()));
            }
            else if (StringUtils.hasText(behaveLog.getHostName()))
            {
                behave.setMacAddress(this.getUserMacFromUserAccount("4", behaveLog.getHostName()));
            }
        }
        behave.setCardId(behaveLog.getCardId());//会员等级（会员卡编号）
        behave.setBehaveTime(behaveLog.getBehaveTime());//行为发生时间
        behave.setSource(behaveLog.getSource());//用户行为来源，参考通用字典表的behave_source
        behave.setPositionId(behaveLog.getPositionId());//行为发生地区的区域编号
        behave.setRemoteCode(behaveLog.getRemoteCode());//所调用的接口编码
        behave.setBehaveType(behaveLog.getBehaveType());//行为类型：比如浏览、收藏、关注等
        behave.setObjectValue(behaveLog.getObjectValue());//行为对象编号：比如商品、活动、商家等
        behave.setObjectType(behaveLog.getObjectType());//行为对象类型，A-活动，G-商品，C-优惠凭证，Y-吆喝，N-通知，Q-购好奇，M-邮件，S-手机服务，0-cms栏目，1-cms文章，2-广告
        behave.setObjectName(behaveLog.getObjectName());//行为对象名称
        behave.setShopId(behaveLog.getShopId());//行为对象所属商家编号
        behave.setShopEntityId(behaveLog.getShopEntityId());//行为对象所属实体店编号
        behave.setObjectSource(behaveLog.getObjectSource());//行为对象来源，记录优惠凭证是从哪个吆喝、通知中浏览和收藏的。
        behave.setCategoryId(behaveLog.getCategoryId());//品类，商品或账单所包含的品类
        behave.setBrandId(behaveLog.getBrandId());//品牌，商品或账单所包含的品牌
        behave.setDetail(behaveLog.getDetail());//详细信息
        behaveList.add(behave);
        return behaveList;
    }

    /**
     * 根据账号类型查询mac地址
     * @param accountType 账号类型
     * @param account 账号
     * @return mac地址
     */
    private String getUserMacFromUserAccount(String accountType, String account) throws Exception
    {
        String userId = this.userAccountQueryService.queryUserIdFromUserAccount(accountType, account);
        String mac = this.userAccountQueryService.queryMacFromUserId(userId);
        return mac;
    }

}
