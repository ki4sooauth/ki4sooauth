package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.analysis.GuessYouLikeQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeCoupon;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UCoupon;

/**
 * 获取猜您喜欢优惠凭证列表
 * @author SPZ
 *
 */
@Service("igus014Service")
public class IGus014ServiceImpl implements IGusService
{

    @Autowired
    private GuessYouLikeQueryService guessYouLikeQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            Map<String, List<GuessYouLikeCoupon>> guessYouLikeCouponMap = this.guessYouLikeQueryService.guessYouLikeCoupon(userId, pageIndex, pageSize);
            List<GuessYouLikeCoupon> guessYouLikeCouponList = guessYouLikeCouponMap.get("1");
            if (CollectionUtils.isEmpty(guessYouLikeCouponList))
            {
                GooagooLog.error("获取猜您喜欢优惠凭证列表：未获取到满足条件的猜您喜欢优惠凭证列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UCoupon> ucouponList = new ArrayList<UCoupon>();
            for (GuessYouLikeCoupon guessYouLikeCoupon : guessYouLikeCouponList)
            {
                UCoupon ucoupon = new UCoupon();
                ucoupon.setCouponId(guessYouLikeCoupon.getCouponId());
                ucoupon.setCouponName(guessYouLikeCoupon.getCouponName());
                ucoupon.setCouponLink(UrlUtils.getCouponUrl(guessYouLikeCoupon.getCouponId()));
                ucoupon.setCouponImage(FormatDataUtils.formatImageInfo(guessYouLikeCoupon.getCouponImageUrl()));
                ucoupon.setShopId(guessYouLikeCoupon.getShopId());
                ucoupon.setShopName(guessYouLikeCoupon.getShopName());
                ucouponList.add(ucoupon);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucouponList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取猜您喜欢优惠凭证列表：获取猜您喜欢优惠凭证列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
