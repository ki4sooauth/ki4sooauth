package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.recommend.RecommendShop;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UShop;

/**
 * 获取推荐商家列表
 * @author SPZ
 *
 */
@Service("igus016Service")
public class IGus016ServiceImpl implements IGusService
{

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Autowired
    private SysCmsContentQueryService sysCmsContentQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            List<RecommendShop> recommendShopList = this.recommendQueryService.recommendShop(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(recommendShopList))
            {
                GooagooLog.error("获取推荐商家列表：未获取到满足条件的推荐商家列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UShop> ushopList = new ArrayList<UShop>();
            for (RecommendShop recommendShop : recommendShopList)
            {
                UShop ushop = new UShop();
                ushop.setShopId(recommendShop.getShopId());
                ushop.setShopName(recommendShop.getShopName());
                ushop.setShopLogo(FormatDataUtils.formatImageInfo(recommendShop.getShopLogo()));
                try
                {
                    ushop.setShopLink(this.sysCmsContentQueryService.getCmsContentUrl(recommendShop.getShopId(), "W"));
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取推荐商家列表：获取手机虚拟商家、网站虚拟商家访问路径异常", e);
                }
                ushop.setAttentionNum(recommendShop.getAttentionNum());
                ushop.setMemberNum(recommendShop.getMemberNum());
                ushop.setFullRate(recommendShop.getFullRate());
                ushop.setAttentionCardName(recommendShop.getAttentionCardName());
                ushop.setAttentionCardImage(FormatDataUtils.formatCardImageInfo(recommendShop.getAttentionCardUrl()));
                ushop.setMemberCardName(recommendShop.getMemberCardName());
                ushop.setMemberCardImage(FormatDataUtils.formatCardImageInfo(recommendShop.getMemberCardUrl()));
                ushopList.add(ushop);
            }
            transData = new TransData<Object>(true, null, ushopList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取推荐商家列表：获取推荐商家列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
