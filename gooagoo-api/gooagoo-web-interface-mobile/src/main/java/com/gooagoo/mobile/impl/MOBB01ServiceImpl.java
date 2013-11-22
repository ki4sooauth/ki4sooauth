package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.FavoriateMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobb01.transform.FavoriteListgRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MODB01:收藏列表（Gooagoo服务器） 
 */
@Service("mobb01")
public class MOBB01ServiceImpl implements ImobileService
{

    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        FavoriteListgRoot root = new FavoriteListgRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String pagesize = parameter.getString("pagesize");
            String favoriteid = parameter.getString("favoriteid");
            String type = parameter.getString("type");
            String pageType = parameter.getString("pagetype");
            String cTimeStamp = parameter.getString("ctimestamp");
            String shopId = parameter.getString("shopid");
            String shopEntityId = parameter.getString("shopentityid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb01"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            if (!StringUtils.hasText(favoriteid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_FAVORIATEID_IS_NULL);
            }
            //            if (!StringUtils.hasText(type))
            //            {
            //                throw new MessageException(MessageConst.MOBILE_PARAMETER_TYPE_IS_NULL);
            //            }
            if (!StringUtils.hasText(pageType))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_IS_NULL);
            }
            if (!pageType.contains("P") && !pageType.contains("N"))
            {//分页类型不正确
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGETYPE_ERROR);
            }
            root = this.favoriateMobileService.getFavoritesOfGooagoo(userId, sessionId, shopId, shopEntityId, cTimeStamp, favoriteid, type, pageType, pagesize);
            root.setResult("true");
            root.setMsg("查询用户收藏信息成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}
