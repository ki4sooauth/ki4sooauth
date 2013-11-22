package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CryoutMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobc05.transform.BoutiqueRecommendRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

@Service("mobc05")
public class MOBC05ServiceImpl implements ImobileService
{
    @Autowired
    private CryoutMobileService cryoutMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String pageIndex = parameter.getString("pageindex");
            String pagesize = parameter.getString("pagesize");
            String shopid = parameter.getString("shopid");
            String type = parameter.getString("type");
            String userId = parameter.getString("userId");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobc05"));

            if (!StringUtils.hasText(pageIndex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pagesize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }

            root = this.cryoutMobileService.getBoutiqueRecommend(userId, shopid, type, pageIndex, pagesize);
            root.setResult("true");
            root.setMsg("查询吆喝广场下精品推荐信息成功");
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
