package com.gooagoo.api.business.query.marketing.notice;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.NoticeInfoBusiness;

public class TestNoticeQueryService
{

    public NoticeQueryService noticeQueryService;

    @Before
    public void testBefore()
    {
        this.noticeQueryService = ApplicationContextUtils.getBean(NoticeQueryService.class);
    }

    /**
     * moba04
     * @throws Exception
     */
    @Test
    public void testFindNoticeList() throws Exception
    {
        String userId = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";
        String shopId = null;
        String startPushTime = "2013-09-24 09:37:37";
        String endPushTime = "2013-09-24 15:44:37";
        String pageId = null;
        String pageType = null;
        Integer pageSize = null;
        List<NoticeInfoBusiness> noticeInfoBusinessList = this.noticeQueryService.findNoticeList("M", userId, shopId, startPushTime, endPushTime, pageId, pageType, pageSize);
        for (NoticeInfoBusiness item : noticeInfoBusinessList)
        {
            System.out.println(item.getPageId());
        }
        Assert.assertTrue("用户得到通知失败", CollectionUtils.isNotEmpty(noticeInfoBusinessList));
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindNoticeDetail() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
