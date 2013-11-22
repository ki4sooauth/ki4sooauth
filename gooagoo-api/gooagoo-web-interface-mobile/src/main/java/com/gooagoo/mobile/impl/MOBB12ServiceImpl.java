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
import com.gooagoo.mobile.entity.mobb12.transform.GetUserCouponNumsRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/***
 * 接口 mobb12 : 查询用户可用优惠券数量
 */

@Service("mobb12")
public class MOBB12ServiceImpl implements ImobileService
{
    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GetUserCouponNumsRoot root = new GetUserCouponNumsRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userId = parameter.getString("userid");
            String sessionId = parameter.getString("sessionid");
            String shopId = parameter.getString("shopid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb12"));

            if (!StringUtils.hasText(userId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }

            Integer useNums = this.favoriateMobileService.GetUserUserableCouponNums(userId, sessionId, shopId);
            root.setResult("true");
            root.setUseablenums(useNums != null ? useNums.toString() : "0");
            root.setMsg("查询用户可用优惠券数量成功");

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
