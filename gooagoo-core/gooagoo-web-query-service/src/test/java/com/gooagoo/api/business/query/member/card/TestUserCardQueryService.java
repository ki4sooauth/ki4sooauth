package com.gooagoo.api.business.query.member.card;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.member.MemberOfCardBusiness;

public class TestUserCardQueryService
{

    public UserCardQueryService userCardQueryService;

    @Before
    public void testBefore()
    {
        this.userCardQueryService = ApplicationContextUtils.getBean(UserCardQueryService.class);
    }

    /**
     * 用户会员卡列表
     * @throws Exception
     */
    @Test
    public void testFindUserMemberCardList() throws Exception
    {
        String userId = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";
        String shopId = null;
        String ctimestamp = null;
        String pageId = "1002000000000200";
        String pageType = "P";
        Integer pageSize = 1;
        List<MemberOfCardBusiness> memberOfCardBusinessList = this.userCardQueryService.findUserMemberCardList(userId, shopId, ctimestamp, pageSize);
        Assert.assertTrue("查询用户会员卡列表失败", CollectionUtils.isNotEmpty(memberOfCardBusinessList));
    }
}
