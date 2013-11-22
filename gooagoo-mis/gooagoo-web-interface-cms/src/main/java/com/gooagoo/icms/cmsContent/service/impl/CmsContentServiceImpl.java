package com.gooagoo.icms.cmsContent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.cms.SysCmsContentCoreService;
import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.entity.generator.sys.CmsContentExample.Criteria;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;
import com.gooagoo.icms.cmsContent.service.CmsContentService;
import com.gooagoo.icms.common.util.CMSUtil;
import com.gooagoo.icms.common.util.CmsInterfaceUtil;
import com.gooagoo.icms.common.util.MessageConst;
import com.gooaoo.view.cms.MCmsContent;
import com.gooaoo.view.common.PageCondition;
import com.gooaoo.view.common.PageModel;
import com.gooaoo.view.common.ZTreeNode;

@Service(value = "cmsContentService")
public class CmsContentServiceImpl implements CmsContentService
{
    @Autowired
    private CmsContentGeneratorQueryService cmsContentGeneratorQueryService;
    @Autowired
    private SysCmsContentCoreService sysCmsContentCoreService;

    /**
     * 判断是否初初始化根结点
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<Object> isInitRoot(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        CmsContentExample example = new CmsContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andIsDelEqualTo("N");
        criteria.andCmsContentTypeEqualTo("C");

        int count = this.cmsContentGeneratorQueryService.countByExample(example);
        boolean result = false;
        if (count == 0)
        {
            result = true;
        }

        return new TransData<Object>(true, null, result);
    }

    /**
     * 初始化根结点
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<Object> initRoot(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        boolean result = this.sysCmsContentCoreService.initCmsContentRoot(shopId);

        return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    /**
     * 添加cms内容管理信息
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        MCmsContent mCmsContent = ServletUtils.objectMethod(MCmsContent.class, request);
        String parentCmsContentId = ServletRequestUtils.getStringParameter(request, "parentCmsContentId", "");

        boolean result = false;
        if (!org.springframework.util.StringUtils.hasText(parentCmsContentId.trim()))
        {
            GooagooLog.info("传入参数：父级结点id值　parentCmsContentId　为空！");
            return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        }
        CmsContent obj = this.cmsContentGeneratorQueryService.selectByPrimaryKey(parentCmsContentId);
        if (obj == null)
        {
            GooagooLog.info("根据传入父级结点id值查询父级结点信息不存在或已被删除！parentCmsContentId=" + parentCmsContentId);
            return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        }
        mCmsContent.setCmsContentId(StringUtils.getUUID());
        mCmsContent.setShopId(shopId);
        mCmsContent.setChannelType(obj.getChannelType());
        if ("C".equals(mCmsContent))
        {
            mCmsContent.setIsTop("N");
        }

        CmsContent cmsContent = this.covertToCmsContent(mCmsContent);
        if (this.checkMCmsContent(cmsContent))
        {
            result = this.sysCmsContentCoreService.addCmsContent(cmsContent);
        }

        return CMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) mCmsContent.getCmsContentId(), mCmsContent.getCmsContentId());
    }

    /**
     * 删除cms内容管理信息
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String[] cmsContentIds = ids.split(",");
        boolean result = false;
        int count = 0;

        for (String cmsContentId : cmsContentIds)
        {
            if (this.sysCmsContentCoreService.deleteCmsContent(cmsContentId))
            {
                count++;
            }
        }
        if (count > 0)
        {
            result = true;
        }

        return CMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) String.valueOf(count), ids);
    }

    /**
     * 修改cms内容管理信息
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        MCmsContent mCmsContent = ServletUtils.objectMethod(MCmsContent.class, request);
        String updateType = ServletRequestUtils.getStringParameter(request, "updateType", "");

        if ("C".equals(mCmsContent))
        {
            mCmsContent.setIsTop("N");
        }
        if ("clearTemplate".equals(updateType))
        {
            mCmsContent.setTemplateId("");
            mCmsContent.setTemplateData("");
        }
        mCmsContent.setPublishTime(null);
        CmsContent cmsContent = this.covertToCmsContent(mCmsContent);

        boolean result = false;
        if (this.checkMCmsContent(cmsContent))
        {
            result = this.sysCmsContentCoreService.updateCmsContent(cmsContent);
        }

        return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, mCmsContent.getCmsContentId());
    }

    /**
     * 获取cms内容管理信息列个表（分页）
     */
    @Override
    public TransData<PageModel<MCmsContent>> pageCmsContent(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        MCmsContent mCmsContent = ServletUtils.objectMethod(MCmsContent.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<MCmsContent> pm = new PageModel<MCmsContent>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        CmsContentExample example = new CmsContentExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("is_top desc, order_no asc, c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getParentCmsContentId()))
        {
            criteria.andParentCmsContentIdEqualTo(mCmsContent.getParentCmsContentId());
        }
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getCmsContentType()))
        {
            criteria.andCmsContentTypeEqualTo(mCmsContent.getCmsContentType());
        }
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(mCmsContent.getPublishStatus());
        }

        int count = this.cmsContentGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CmsContent> list = this.cmsContentGeneratorQueryService.selectByExample(example);
            for (CmsContent cmsContent : list)
            {
                pm.getResult().add(this.convertToMCmsContent(cmsContent));
            }
        }

        return new TransData<PageModel<MCmsContent>>(true, null, pm);
    }

    /**
     * 获取cms内容管理信息列表（不分页）
     */
    @Override
    public TransData<List<ZTreeNode>> getCmsContentList(HttpServletRequest request) throws Exception
    {
        String shopId = CmsInterfaceUtil.getShopIdByInterface(request);

        MCmsContent mCmsContent = ServletUtils.objectMethod(MCmsContent.class, request);
        String selectId = request.getParameter("selectId");

        List<ZTreeNode> resultList = new ArrayList<ZTreeNode>();

        CmsContentExample example = new CmsContentExample();
        example.setOrderByClause("cms_content_type desc, is_top desc, order_no asc, c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getParentCmsContentId()))
        {
            criteria.andParentCmsContentIdEqualTo(mCmsContent.getParentCmsContentId());
        }
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getCmsContentType()))
        {
            criteria.andCmsContentTypeEqualTo(mCmsContent.getCmsContentType());
        }
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getChannelType()))
        {
            criteria.andChannelTypeEqualTo(mCmsContent.getChannelType());
        }
        if (org.springframework.util.StringUtils.hasText(mCmsContent.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(mCmsContent.getPublishStatus());
        }
        List<CmsContent> list = this.cmsContentGeneratorQueryService.selectByExample(example);
        for (CmsContent cmsContent : list)
        {
            resultList.add(this.convertToZTreenode(cmsContent, selectId));
        }

        return new TransData<List<ZTreeNode>>(true, null, resultList);
    }

    /**
     * 获取cms内容管理详细信息
     */
    @Override
    public TransData<MCmsContent> getCmsContent(HttpServletRequest request) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");

        CmsContent cmsContent = this.cmsContentGeneratorQueryService.selectByPrimaryKey(cmsContentId);

        MCmsContent mCmsContent = this.convertToMCmsContent(cmsContent);

        return new TransData<MCmsContent>(true, null, mCmsContent, cmsContentId);
    }

    /**
     * 审核cms内容管理信息
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "publishStatus", "");
        String auditNote = ServletRequestUtils.getStringParameter(request, "auditNote", "");

        boolean result = false;
        String failMessage = MessageConst.GMS_OPERATE_FAIL;
        try
        {
            result = this.sysCmsContentCoreService.checkCmsContent(cmsContentId, publishStatus, auditNote);
        }
        catch (TemplateDataIsEmptyException e)
        {
            failMessage = MessageConst.CMS_TEMPLATEDATA_CAN_NOT_BE_EMPTY;
        }

        return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, failMessage, cmsContentId);
    }

    /**
     * 发布cms内容管理信息
     */
    @Override
    public TransData<Object> relese(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String[] cmsContentIds = ids.split(",");
        boolean result = false;
        int count = 0;

        for (String cmsContentId : cmsContentIds)
        {
            if (this.sysCmsContentCoreService.publishCmsContent(cmsContentId))
            {
                count++;
            }
        }
        if (count > 0)
        {
            result = true;
        }
        return CMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) String.valueOf(count), ids);
    }

    /**
     * 发布全部cms内容管理信息
     */
    @Override
    public TransData<Object> releseAll(HttpServletRequest request) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");

        boolean result = this.sysCmsContentCoreService.publishAllCmsContent(cmsContentId);

        return CMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    private CmsContent covertToCmsContent(MCmsContent mCmsContent) throws IllegalArgumentException, IllegalAccessException
    {
        CmsContent cmsContent = new CmsContent();
        if (cmsContent != null)
        {
            EntityTools.copyValue(mCmsContent, cmsContent);
        }

        return cmsContent;
    }

    private MCmsContent convertToMCmsContent(CmsContent cmsContent) throws IllegalArgumentException, IllegalAccessException
    {
        MCmsContent mCmsContent = new MCmsContent();
        if (cmsContent != null)
        {
            EntityTools.copyValue(cmsContent, mCmsContent);
        }

        return mCmsContent;
    }

    private boolean checkMCmsContent(CmsContent cmsContent)
    {
        //        if (cmsContent == null)
        //        {
        //            return false;
        //        }
        //        if (!org.springframework.util.StringUtils.hasText(cmsContent.getCmsContentName()))
        //        {
        //            return false;
        //        }
        //        // TODO Auto-generated method stub
        //
        return true;
    }

    /**
     * 将cmsContent转换成ZTreeNode对象
     * @param cmsContent
     * @return
     */
    private ZTreeNode convertToZTreenode(CmsContent cmsContent, String selectId)
    {
        ZTreeNode zn = new ZTreeNode();
        if (cmsContent != null)
        {
            zn.setId(cmsContent.getCmsContentId());
            zn.setName(cmsContent.getCmsContentName());
            zn.setpId(cmsContent.getParentCmsContentId());
            if ("-1".equals(cmsContent.getParentCmsContentId()) && "W".equals(cmsContent.getChannelType()))
            {
                zn.setOpen(true);
            }
            zn.setClick("channelDetail('" + cmsContent.getCmsContentId() + "',this);");
            if (org.springframework.util.StringUtils.hasText(selectId) && selectId.equals(cmsContent.getCmsContentId()))
            {
                zn.setChecked(true);
            }
        }
        return zn;
    }

}
