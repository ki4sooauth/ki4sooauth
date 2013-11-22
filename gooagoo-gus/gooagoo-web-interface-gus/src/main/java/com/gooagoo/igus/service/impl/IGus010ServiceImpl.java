package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.analysis.GuessYouLikeQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeGoods;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UGoods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 获取猜您喜欢商品列表
 * @author SPZ
 *
 */
@Service("igus010Service")
public class IGus010ServiceImpl implements IGusService
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
            List<GuessYouLikeGoods> guessYouLikeGoodsList = this.guessYouLikeQueryService.guessYouLikeGoods(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(guessYouLikeGoodsList))
            {
                GooagooLog.error("获取猜您喜欢商品列表：未获取到满足条件的猜您喜欢商品列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UGoods> ugoodsList = new ArrayList<UGoods>();
            for (GuessYouLikeGoods guessYouLikeGoods : guessYouLikeGoodsList)
            {
                UGoods ugoods = new UGoods();
                ugoods.setGoodsId(guessYouLikeGoods.getGoodsId());
                ugoods.setGoodsName(guessYouLikeGoods.getGoodsName());
                ugoods.setGoodsLink(UrlUtils.getGoodsUrl(guessYouLikeGoods.getGoodsId()));
                if (StringUtils.isNotBlank(guessYouLikeGoods.getGoodsImageUrl()))
                {
                    List<String> imageList = new Gson().fromJson(guessYouLikeGoods.getGoodsImageUrl(), new TypeToken<List<String>>()
                    {
                    }.getType());
                    ugoods.setGoodsImage(FormatDataUtils.formatImageInfo(imageList.get(0)));
                }
                ugoods.setShopId(guessYouLikeGoods.getShopId());
                ugoods.setShopName(guessYouLikeGoods.getShopName());
                ugoodsList.add(ugoods);
            }
            transData = new TransData<Object>(true, null, ugoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取猜您喜欢商品列表：获取猜您喜欢商品列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
