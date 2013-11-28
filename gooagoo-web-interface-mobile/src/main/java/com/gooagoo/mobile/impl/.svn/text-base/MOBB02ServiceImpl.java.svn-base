package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.CouponAlreadyPastPublishEndTimeException;
import com.gooagoo.exception.business.user.FavoriteNotExistOrDeletedException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.FavoriateMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobb02.transform.AddFavoriteRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBB02:添加收藏
 */
@Service("mobb02")
public class MOBB02ServiceImpl implements ImobileService
{
    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        AddFavoriteRoot root = new AddFavoriteRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String adurl = parameter.getString("adurl");
            String adtype = parameter.getString("adtype");
            String shopadid = parameter.getString("shopadid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb02"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }

            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }

            if (StringUtils.hasText(shopadid) && !StringUtils.hasText(adtype))
            {//当shopaid不为空，adtype不能为空
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPADID_HAVE_VALUE_ADTYPE_IS_NULL);
            }

            if (!StringUtils.hasText(shopadid) && !StringUtils.hasText(adurl))
            {//adurl和shopadid两者必填其一
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPADID_AND_ADURL_IS_NULL);
            }

            this.favoriateMobileService.addFavorites(userId, sessionId, adtype, shopadid, adurl);
            root.setResult("true");
            root.setMsg("收藏成功");
        }
        catch (AlreadyCollectException e)
        {
            //已收藏过了,不允许再次收藏
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_ALREADY_STORE;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (FavoriteNotExistOrDeletedException e)
        {
            // 收藏信息不存在或已删除异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_STORE_INFO_DEL_OR_NOT_EXIST;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }

        catch (CouponAlreadyPastPublishEndTimeException e)
        {
            // 优惠凭证已过发行期异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_EXCEED_PUBLISH_END_TIME;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (CouponExhaustiveException e)
        {// 已超过商家发放优惠券个数异常（优惠券已发放完毕）
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_EXCEED_PUBLISH_END_TIME;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (AlreadyExceedUserOwnCouponNumException e)
        {
            // 已超过用户拥有优惠券最大个数异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_STORE_NUM_EXCEED_MAX_OWN_NUMS;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (OperateFailException e)
        {//收藏失败
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_FAVORIATE_STORE_FAIL;
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
