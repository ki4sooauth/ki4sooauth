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
import com.gooagoo.mobile.entity.mobb07.transform.FavoritePlazaRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口 mobb07 : 收藏广场列表（查询）
 */
@Service("mobb07")
public class MOBB07ServiceImpl implements ImobileService
{

    @Autowired
    private FavoriateMobileService favoriateMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String keyword = parameter.getString("keyword");
            String type = parameter.getString("type");
            String pageIndex = parameter.getString("pageindex");
            String pageSize = parameter.getString("pagesize");
            String userId = parameter.getString("userid");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobb07"));
            if (!StringUtils.hasText(pageIndex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }

            root = this.favoriateMobileService.getFavoritePlazaListInfo(userId, keyword, type, pageIndex, pageSize);
            root.setResult("true");
            root.setMsg("获取收藏广场列表成功");
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
