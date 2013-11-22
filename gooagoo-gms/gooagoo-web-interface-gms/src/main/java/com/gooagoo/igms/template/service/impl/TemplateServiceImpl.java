package com.gooagoo.igms.template.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.sys.TemplateInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.common.PageModel;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.entity.generator.sys.TemplateInfoExample;
import com.gooagoo.entity.generator.sys.TemplateInfoExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.template.service.TemplateService;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageCondition;

@Service(value = "templateService")
public class TemplateServiceImpl implements TemplateService
{
    @Autowired
    private TemplateInfoGeneratorQueryService templateInfoGeneratorQueryService;

    @Override
    public TransData<PageModel<FNode>> listTemplate(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String templateSource = ServletRequestUtils.getStringParameter(request, "templateSource", "");
        String userType = ServletRequestUtils.getStringParameter(request, "userType", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", null);

        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FNode> pm = new PageModel<FNode>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());

        TemplateInfoExample example = new TemplateInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andUserTypeEqualTo(userType);
        if ("S".equals(templateSource))
        {
            criteria.andUserIdEqualTo(shopId);
        }
        if (StringUtils.hasText(channelCode))
        {
            if ("4".equals(channelCode))
            {
                criteria.andChannelCodeEqualTo("E");
            }
            if ("5".equals(channelCode))
            {
                criteria.andChannelCodeEqualTo("Q");
            }
            if ("6".equals(channelCode))
            {
                criteria.andChannelCodeEqualTo("M");
            }
        }

        int count = this.templateInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<TemplateInfo> templateList = this.templateInfoGeneratorQueryService.selectByExample(example);
            for (TemplateInfo marketingTemplate : templateList)
            {
                pm.getResult().add(this.convertToFNode(marketingTemplate));
            }
        }
        return new TransData<PageModel<FNode>>(true, null, pm);
    }

    private FNode convertToFNode(TemplateInfo marketingTemplate)
    {
        FNode node = null;
        if (marketingTemplate != null)
        {
            node = new FNode();
            node.setCode(marketingTemplate.getTemplateId());
            node.setName(marketingTemplate.getTemplateName());
            node.setIcon(marketingTemplate.getTemplateImg());
            node.setRemarks(marketingTemplate.getAuthorization());
        }
        return node;
    }
}
