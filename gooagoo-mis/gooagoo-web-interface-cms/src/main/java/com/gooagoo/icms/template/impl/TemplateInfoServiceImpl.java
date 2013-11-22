package com.gooagoo.icms.template.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.sys.TemplateInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoExample.Criteria;
import com.gooagoo.icms.common.util.CmsInterfaceUtil;
import com.gooagoo.icms.template.TemplateInfoService;
import com.gooaoo.view.cms.MTemplateInfo;
import com.gooaoo.view.common.PageCondition;
import com.gooaoo.view.common.PageModel;

@Service(value = "templateInfoService")
public class TemplateInfoServiceImpl implements TemplateInfoService
{
    @Autowired
    private TemplateInfoGeneratorQueryService templateInfoGeneratorQueryService;

    @Override
    public TransData<PageModel<MTemplateInfo>> getTemplateInfoList(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        MTemplateInfo templateInfo = ServletUtils.objectMethod(MTemplateInfo.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        String type = ServletRequestUtils.getStringParameter(request, "type", "");

        PageModel<MTemplateInfo> pm = new PageModel<MTemplateInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        TemplateInfoExample example = new TemplateInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andChannelCodeEqualTo("S");
        if (org.springframework.util.StringUtils.hasText(type) && "Y".equals(type))
        {
            criteria.andUserIdEqualTo(shopId);
        }
        if (org.springframework.util.StringUtils.hasText(templateInfo.getTemplateType()))
        {
            criteria.andTemplateTypeEqualTo(templateInfo.getTemplateType());
        }
        if (org.springframework.util.StringUtils.hasText(templateInfo.getUserType()))
        {
            criteria.andUserTypeEqualTo(templateInfo.getUserType());
        }
        Integer count = this.templateInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<TemplateInfo> list = this.templateInfoGeneratorQueryService.selectByExample(example);
            for (TemplateInfo info : list)
            {
                pm.getResult().add(this.convertToMCmsContent(info));
            }
        }

        return new TransData<PageModel<MTemplateInfo>>(true, null, pm);
    }

    @Override
    public MTemplateInfo getTemplateInfo(HttpServletRequest request) throws Exception
    {
        String templateId = ServletRequestUtils.getStringParameter(request, "templateId", "");

        TemplateInfo templateInfo = this.templateInfoGeneratorQueryService.selectByPrimaryKey(templateId);

        return this.convertToMCmsContent(templateInfo);
    }

    private MTemplateInfo convertToMCmsContent(TemplateInfo info) throws IllegalArgumentException, IllegalAccessException
    {
        MTemplateInfo mTemplateInfo = new MTemplateInfo();

        if (info != null)
        {
            EntityTools.copyValue(info, mTemplateInfo);
        }
        return mTemplateInfo;
    }

}
