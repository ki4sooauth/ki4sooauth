package com.gooagoo.igus.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.MobileVersionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.igus.service.IGusService;

/**
 * 获取最新apk下载地址
 * @author SPZ
 *
 */
@Service("igus001Service")
public class IGus001ServiceImpl implements IGusService
{

    @Autowired
    private MobileVersionGeneratorQueryService mobileVersionGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            MobileVersionExample mobileVersionExample = new MobileVersionExample();
            mobileVersionExample.createCriteria().andMobileTypeEqualTo("1").andIsDelEqualTo("N");
            List<MobileVersion> mobileVersionList = this.mobileVersionGeneratorQueryService.selectByExample(mobileVersionExample);
            if (CollectionUtils.isEmpty(mobileVersionList))
            {
                GooagooLog.error("获取最新apk下载地址：apk没有最新下载地址", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            MobileVersion mobileVersion = mobileVersionList.get(0);
            GooagooLog.debug("获取最新apk下载地址：apk信息（" + mobileVersion.toString() + "）");
            transData = new TransData<Object>(true, null, mobileVersion.getLink());
        }
        catch (Exception e)
        {
            GooagooLog.error("获取最新apk下载地址：获取最新apk下载地址异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
