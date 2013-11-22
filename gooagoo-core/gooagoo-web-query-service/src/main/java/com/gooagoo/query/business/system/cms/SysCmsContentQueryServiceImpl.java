package com.gooagoo.query.business.system.cms;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.exception.common.NullException;

@Service
public class SysCmsContentQueryServiceImpl implements SysCmsContentQueryService
{

    @Autowired
    private CmsContentGeneratorQueryService cmsContentGeneratorQueryService;

    @Override
    public String getCmsContentUrl(String shopId, String channelType) throws Exception
    {
        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.createCriteria().andShopIdEqualTo(shopId).andParentCmsContentIdEqualTo("-1").andChannelTypeEqualTo(channelType).andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        List<CmsContent> cmsContentList = this.cmsContentGeneratorQueryService.selectByExample(cmsContentExample);
        if (CollectionUtils.isEmpty(cmsContentList))
        {
            GooagooLog.warn("获取手机虚拟商家、网站虚拟商家访问路径为空[shopId=" + shopId + "、channelType=" + channelType + "]");
            throw new NullException("获取手机虚拟商家、网站虚拟商家访问路径为空[shopId=" + shopId + "、channelType=" + channelType + "]");
        }
        return cmsContentList.get(0).getCmsContentUrl();
    }

}
