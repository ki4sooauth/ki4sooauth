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
import com.gooagoo.exception.business.behave.UserAlreadyCommentGoodsException;
import com.gooagoo.mobile.api.ConsumeBillLinkInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe11.transform.GoodsCommentRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE11:用户评论商品接口
 */
@Service("mobe11")
public class MOBE11ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkInfoMobileService consumeBillLinkInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GoodsCommentRoot root = new GoodsCommentRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String goodsid = parameter.getString("goodsid");
            String commentlevel = parameter.getString("commentlevel");
            String content = parameter.getString("content");
            String orderid = parameter.getString("orderid");
            String mac = parameter.getString("mac");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe11"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(orderid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(goodsid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSID_IS_NULL);
            }
            if (!StringUtils.hasText(commentlevel))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_COMMENTLEVEL_IS_NULL);
            }
            if (!StringUtils.hasText(content))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_CONTENT_IS_NULL);
            }

            this.consumeBillLinkInfoMobileService.userCommentGoods(request, mac, userid, sessionid, orderid, goodsid, commentlevel, content);
            root.setResult("true");
            root.setMsg("评论成功");
        }
        catch (UserAlreadyCommentGoodsException e)
        {//用户已评论过此商品
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_USER_ALREADY_COMMENT_THE_GOODS;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GooagooException e)
        {//评论商品失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_COMMENT_GOODS_FAIL;
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
