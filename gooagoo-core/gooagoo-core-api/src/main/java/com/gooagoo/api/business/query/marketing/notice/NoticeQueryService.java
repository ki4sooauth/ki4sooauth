package com.gooagoo.api.business.query.marketing.notice;

import java.util.List;

import com.gooagoo.entity.business.marketing.NoticeInfoBusiness;
import com.gooagoo.entity.business.marketing.NoticeLinkInfoBussiness;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;

public interface NoticeQueryService
{
    /**
     * moba04:用户查询通知列表（分页）
     * @param userId
     * @param shopId
     * @param cTimeStamp
     * @param pageId
     * @param pagetype
     * @param pagesize
     * @return
     * @throws Exception
     */
    public NoticeLinkInfoBussiness findUserReceiveNotice(String userId, String shopId, String cTimeStamp, String pageId, String pagetype, Integer pagesize) throws Exception;

    /**
     * 用户查询通知列表（分页）
     * moba04
     * @param source W-网站 M-手机
     * @param MarketingUserLinkExample
     * @return
     * @throws Exception
     */
    public List<NoticeInfoBusiness> findNoticeList(String source, String userId, String shopId, String startPushTime, String endPushTime, String pageId, String pageType, Integer pageSize) throws Exception;

    /**
     * 用户查询通知次数
     * @param MarketingUserLinkExample
     * @return
     * @throws Exception
     */
    public int findNoticeCount(MarketingUserLinkExample marketingUserLinkExample) throws Exception;

    /**
     *  
      6.7.5. 查看通知详情
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findNoticeDetail(String parameter) throws Exception;

}
