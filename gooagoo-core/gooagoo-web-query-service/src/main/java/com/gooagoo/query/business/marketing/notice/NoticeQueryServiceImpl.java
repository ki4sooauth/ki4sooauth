package com.gooagoo.query.business.marketing.notice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.notice.NoticeQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.marketing.notice.MarketingNoticeAdapterMapper;
import com.gooagoo.entity.business.marketing.IsdeletedInfo;
import com.gooagoo.entity.business.marketing.NoticeInfoBusiness;
import com.gooagoo.entity.business.marketing.NoticeLinkInfoBussiness;
import com.gooagoo.entity.business.marketing.notice.MarketingNoticeAdapter;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample.Criteria;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;

@Service
public class NoticeQueryServiceImpl implements NoticeQueryService
{

    @Autowired
    private MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;

    @Autowired
    private NoticeInfoGeneratorQueryService noticeInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private MarketingNoticeAdapterMapper marketingNoticeAdapterMapper;

    @Override
    public NoticeLinkInfoBussiness findUserReceiveNotice(String userId, String shopId, String cTimeStamp, String pageId, String pageType, Integer pageSize) throws Exception
    {
        IsdeletedInfo isdeletedInfo = new IsdeletedInfo();//记录被删除的信息
        //1.查询未删除的用户接受到信息
        //1)封装查询用户接收到的吆喝查询通知数据类型标识
        if ("N".equals(pageType))
        {//旧通知
            isdeletedInfo.setFlag("N");
        }
        else if ("P".equals(pageType))
        {//新通知
         //最新数据总条数
            Integer laterDataNum = this.marketingNoticeAdapterMapper.countPageNoticeInfo(userId, shopId, null, null, pageId, pageType);
            if (laterDataNum > pageSize)
            {//最新数据总条数大于每页信息显示条数，则倒序去最新的几条数据

                isdeletedInfo.setFlag("Y");//要查询的新吆喝条数大于每页信息显示条数
            }
            else
            {
                isdeletedInfo.setFlag("N");//要查询的新吆喝条数在每页信息显示条数范围内
            }
        }
        //2)查询用户接受到的未删除的吆喝信息
        List<NoticeInfoBusiness> noticeInfoBusinessList = this.findNoticeList("M", userId, shopId, null, null, pageId, pageType, pageSize);
        //3).封装查询到用户接受到的未删除的吆喝信息
        NoticeLinkInfoBussiness noticeLinkInfoBussiness = new NoticeLinkInfoBussiness();
        if (CollectionUtils.isNotEmpty(noticeInfoBusinessList))
        {
            noticeLinkInfoBussiness.setNoticeInfoBusinessList(noticeInfoBusinessList);
            isdeletedInfo.setCtimestamp(noticeInfoBusinessList.get(0).getcTimeStamp());
        }
        //2.传入时间戳时，查询已删除的通知的编号
        //设置查询删除信息的最大时间戳，改时间取自于两种情况：1.用户没有删除数据，取未删除数据的最大时间戳，2.用户有已删除数据，取删除数据的最大时间戳
        if (StringUtils.hasText(cTimeStamp) && "P".equals(pageType))
        {//当存在最大时间戳和翻页类型为N—下一页时，才查询删除的通知信息
            this.getDelUserReceiveNoticeInfo(userId, shopId, TimeUtils.convertStringToDate(cTimeStamp), isdeletedInfo);
        }

        noticeLinkInfoBussiness.setIsdeletedInfo(isdeletedInfo);

        return noticeLinkInfoBussiness;
    }

    /**
     * 查询删除的用户接收到的通知信息
     * @param userId
     * @param cTimeStamp
     * @param isdeletedInfo
     */
    private void getDelUserReceiveNoticeInfo(String userId, String shopId, Date cTimeStamp, IsdeletedInfo isdeletedInfo)
    {
        MarketingUserLinkExample marketingUserLinkExample1 = new MarketingUserLinkExample();
        Criteria criteria1 = marketingUserLinkExample1.createCriteria();
        criteria1.andAccountTypeEqualTo("0");//用户类型，0-表示userId
        criteria1.andAccountEqualTo(userId);//用户账号
        criteria1.andMarketingTypeEqualTo("2");//2-通知
        criteria1.andIsPushedEqualTo("Y");//已经推送给用户
        criteria1.andIsDelEqualTo("Y");//已删除
        if (StringUtils.hasText(shopId))
        {
            criteria1.andShopIdEqualTo(shopId);
        }
        criteria1.andCTimeStampGreaterThan(cTimeStamp);
        marketingUserLinkExample1.setOrderByClause("c_time_stamp DESC");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample1);
        if (CollectionUtils.isNotEmpty(marketingUserLinkList))
        {//有已删除的用户接收到的通知信息
            if (isdeletedInfo == null)
            {
                isdeletedInfo = new IsdeletedInfo();
            }
            String delId = "";
            for (MarketingUserLink temp : marketingUserLinkList)
            {
                if ("".equals(delId))
                {
                    delId = temp.getId();
                }
                else
                {
                    delId = delId + "," + temp.getId();
                }
            }
            isdeletedInfo.setIdstr(delId);
            //设置删除信息的最大时间戳
            isdeletedInfo.setCtimestamp(TimeUtils.convertDateToString(marketingUserLinkList.get(0).getCTimeStamp(), TimeUtils.FORMAT1));
        }

    }

    @Override
    public List<NoticeInfoBusiness> findNoticeList(String source, String userId, String shopId, String startPushTime, String endPushTime, String pageId, String pageType, Integer pageSize) throws Exception
    {
        List<NoticeInfoBusiness> noticeInfoBusinessList = null;
        Date startTime = StringUtils.hasText(startPushTime) ? TimeUtils.convertStringToDate(startPushTime) : null;
        Date endTime = StringUtils.hasText(endPushTime) ? TimeUtils.convertStringToDate(endPushTime) : null;
        List<MarketingNoticeAdapter> cryoutInfoAdapterList = null;
        if ("W".equalsIgnoreCase(source))
        {
            cryoutInfoAdapterList = this.marketingNoticeAdapterMapper.pageNoticeInfo(userId, shopId, startTime, endTime, pageId, pageType, pageSize);
        }
        else if ("M".equalsIgnoreCase(source))
        {
            cryoutInfoAdapterList = this.marketingNoticeAdapterMapper.pageNoticeInfoM(userId, shopId, startTime, endTime, pageId, pageType, pageSize);
        }
        if (CollectionUtils.isNotEmpty(cryoutInfoAdapterList))
        {
            noticeInfoBusinessList = new ArrayList<NoticeInfoBusiness>();

            for (MarketingNoticeAdapter marketingNoticeAdapter : cryoutInfoAdapterList)
            {
                if (marketingNoticeAdapter.getMarketingUserLink() != null)
                {
                    MarketingUserLink marketingUserLink = marketingNoticeAdapter.getMarketingUserLink();
                    //商家通知信息表
                    NoticeInfo noticeInfo = this.noticeInfoGeneratorQueryService.selectUnDelByPrimaryKey(marketingUserLink.getMarketingId());
                    if (noticeInfo != null)
                    {
                        NoticeInfoBusiness noticeInfoBusiness = new NoticeInfoBusiness();
                        noticeInfoBusiness.setPageId(marketingNoticeAdapter.getPageId());
                        noticeInfoBusiness.setMarketingUserLinkId(marketingUserLink.getId());
                        noticeInfoBusiness.setMarketingLinkId(noticeInfo.getMarketingLinkId());
                        noticeInfoBusiness.setMarketingLinkType(noticeInfo.getMarketingLinkType());
                        noticeInfoBusiness.setPushTime(marketingUserLink.getPushTime() != null ? TimeUtils.convertDateToString(marketingUserLink.getPushTime(), TimeUtils.FORMAT1) : null);
                        noticeInfoBusiness.setNoticeInfoId(noticeInfo.getNoticeInfoId());
                        noticeInfoBusiness.setNoticeTitle(noticeInfo.getNoticeTitle());
                        noticeInfoBusiness.setImg(noticeInfo.getImg());
                        noticeInfoBusiness.setNoticeTextMobile(noticeInfo.getNoticeTextMobile());
                        noticeInfoBusiness.setNoticeTextWeb(noticeInfo.getNoticeTextWeb());
                        noticeInfoBusiness.setcTimeStamp(TimeUtils.convertDateToString(noticeInfo.getCTimeStamp(), TimeUtils.FORMAT1));
                        noticeInfoBusiness.setIsdel(noticeInfo.getIsDel());
                        noticeInfoBusiness.setIsread(marketingUserLink.getIsRead());
                        noticeInfoBusiness.setShopId(noticeInfo.getShopId());
                        //根据shopid查询logo
                        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(noticeInfo.getShopId());
                        if (shopInfo != null)
                        {
                            noticeInfoBusiness.setShopName(shopInfo.getShopName());
                            noticeInfoBusiness.setLogo1(shopInfo.getLogo1());
                            noticeInfoBusiness.setLogo2(shopInfo.getLogo2());
                        }
                        noticeInfoBusinessList.add(noticeInfoBusiness);
                    }

                }
            }
        }
        return noticeInfoBusinessList;
    }

    @Override
    public boolean findNoticeDetail(String parameter) throws Exception
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int findNoticeCount(MarketingUserLinkExample marketingUserLinkExample) throws Exception
    {
        return this.marketingUserLinkGeneratorQueryService.countByExample(marketingUserLinkExample);
    }

}
