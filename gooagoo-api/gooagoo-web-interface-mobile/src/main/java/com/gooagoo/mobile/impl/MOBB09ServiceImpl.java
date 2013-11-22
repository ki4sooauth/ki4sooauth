package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.user.ShopNotExistAttentionCardException;
import com.gooagoo.exception.business.user.UserAlreadyAttentionShopException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;
import com.gooagoo.mobile.api.FavoriateMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobb09.transform.AttentionShopRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * mobb09:用户关注商家 （发关注卡） 
 */
@Service("mobb09")
public class MOBB09ServiceImpl implements ImobileService
{

    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        AttentionShopRoot root = new AttentionShopRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb09"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }

            this.favoriateMobileService.userAttentionShop(userid, sessionid, shopid);
            root.setResult("true");
            root.setMsg("关注成功");
        }
        catch (ShopNotExistAttentionCardException e)
        {//商家无关注卡异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_SHOP_NOT_ALLOW_TO_ATTENTION;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (UserAlreadyAttentionShopException e)
        {//用户已关注商家异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_ALREADY_ATTENTION_SHOP;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (UserAlreadyShopMemberException e)
        {//用户已是商家会员异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_ALREADY_IS_MEMBER_OF_SHOP;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GooagooException e)
        {//用户关注商家失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_ATTENTION_SHOP_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
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
