package com.gooagoo.core.business.system.cms;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.gooagoo.api.business.core.system.cms.SysCmsContentCoreService;
import com.gooagoo.api.generator.core.sys.CmsContentGeneratorCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;

@Service
public class SysCmsContentCoreServiceImpl implements SysCmsContentCoreService
{

    @Autowired
    private CmsContentGeneratorCoreService cmsContentGeneratorCoreService;
    @Autowired
    private PublishProtectedCoreService publishProtectedCoreService;

    private final static Object deleteObject = new Object();//删除CMS内容同步锁
    private final static Object releaseObject = new Object();//发布全部CMS内容同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean initCmsContentRoot(String shopId) throws Exception
    {
        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.createCriteria().andShopIdEqualTo(shopId).andParentCmsContentIdEqualTo("-1").andIsDelEqualTo("N");
        List<CmsContent> cmsContentList = this.cmsContentGeneratorCoreService.selectByExample(cmsContentExample);
        if (CollectionUtils.isNotEmpty(cmsContentList))
        {
            GooagooLog.info("商家[shopId=" + shopId + "]已初始化CMS内容根节点");
            return false;
        }
        CmsContent cmsContent4Mobile = this.initCmsContent(shopId, "M");
        CmsContent cmsContent4Website = this.initCmsContent(shopId, "W");
        if (!this.cmsContentGeneratorCoreService.insertSelective(cmsContent4Mobile))
        {
            GooagooLog.info("初始化手机CMS内容根节点失败[cmsContent4Mobile=" + cmsContent4Mobile.toString() + "]");
            return false;
        }
        if (!this.cmsContentGeneratorCoreService.insertSelective(cmsContent4Website))
        {
            GooagooLog.info("初始化网站CMS内容根节点失败[cmsContent4Website=" + cmsContent4Website.toString() + "]");
            return false;
        }
        return true;
    }

    @Override
    public boolean addCmsContent(CmsContent cmsContent) throws Exception
    {
        cmsContent.setIsDel("N");
        cmsContent.setPublishStatus("W");//审核发布状态-待审核
        cmsContent.setCmsContentUrl(UrlUtils.getCmsUrl(cmsContent.getCmsContentId()));//http://html.gooagoo.com/cms/cms内容主键.html
        return this.cmsContentGeneratorCoreService.insertSelective(cmsContent);
    }

    @Override
    public boolean updateCmsContent(CmsContent cmsContent) throws Exception
    {
        cmsContent.setPublishStatus("W");//审核发布状态-待审核
        cmsContent.setCmsContentUrl(null);
        return this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteCmsContent(String cmsContentId) throws Exception
    {
        synchronized (deleteObject)
        {
            CmsContent cmsContent = this.cmsContentGeneratorCoreService.selectUnDelByPrimaryKey(cmsContentId);
            if (cmsContent == null)
            {
                GooagooLog.info("查询cms内容信息为空[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            if (!this.cmsContentGeneratorCoreService.deleteByPrimaryKey(cmsContentId))
            {
                GooagooLog.info("删除cms内容信息失败[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
            String generateurl = bundle.getString("cms_generateurl");//生成路径
            File file = new File(generateurl + cmsContentId + ".html");
            if (file.exists() && file.isFile())
            {
                file.delete();
            }
            //递归删除所有子级cms内容
            this.recursionDeleteAllSubCmsContent(cmsContentId);
            return true;
        }
    }

    @Override
    public boolean checkCmsContent(String cmsContentId, String publishStatus, String auditNote) throws Exception
    {
        CmsContent cmsContent = this.cmsContentGeneratorCoreService.selectUnDelByPrimaryKey(cmsContentId);
        if (cmsContent == null)
        {
            GooagooLog.info("查询cms内容信息为空[cmsContentId=" + cmsContentId + "]");
            return false;
        }
        if (StringUtils.isBlank(cmsContent.getTemplateData()))
        {
            GooagooLog.info("cms内容模板数据不能为空[cmsContentId=" + cmsContentId + "]");
            throw new TemplateDataIsEmptyException("cms内容模板数据不能为空[cmsContentId=" + cmsContentId + "]");
        }
        if (!"W".equals(cmsContent.getPublishStatus()))
        {
            GooagooLog.info("cms内容信息状态不是待审核,不能进行审核操作[cmsContentId=" + cmsContentId + "]");
            return false;
        }
        if ("Y".equals(publishStatus))
        {
            cmsContent.setPublishStatus("A");
        }
        else
        {
            cmsContent.setPublishStatus("B");
        }
        cmsContent.setAuditNote(auditNote);
        return this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent);
    }

    @Override
    public boolean publishCmsContent(String cmsContentId) throws Exception
    {
        CmsContent cmsContent = this.cmsContentGeneratorCoreService.selectUnDelByPrimaryKey(cmsContentId);
        if (cmsContent == null)
        {
            GooagooLog.info("查询cms内容信息为空[cmsContentId=" + cmsContentId + "]");
            return false;
        }
        if (!"A".equals(cmsContent.getPublishStatus()))
        {
            GooagooLog.info("cms内容信息状态不是已审核通过,不能进行发布操作[cmsContentId=" + cmsContentId + "]");
            return false;
        }
        //发布内容只包括cms内容信息本身，发布cms内容信息时通过模板规则将模板内容生成静态文件保存到指定文件夹中
        if (!this.publishProtectedCoreService.generateEventOrCmsHtml(cmsContent, cmsContent.getChannelType()))
        {
            GooagooLog.info("发布CMS内容失败[cmsContentId=" + cmsContentId + "]");
            return false;
        }
        cmsContent.setPublishStatus("P");
        cmsContent.setPublishTime(new Date());
        return this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent);
    }

    @Override
    public boolean publishAllCmsContent(String cmsContentId) throws Exception
    {
        synchronized (releaseObject)
        {
            CmsContent cmsContent = this.cmsContentGeneratorCoreService.selectByPrimaryKey(cmsContentId);
            if (cmsContent == null)
            {
                GooagooLog.info("查询cms内容信息为空[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            if (!"A".equals(cmsContent.getPublishStatus()))
            {
                GooagooLog.info("cms内容信息状态不是已审核通过,不能进行发布操作[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            cmsContent.setPublishStatus("P");
            cmsContent.setPublishTime(new Date());
            if (!this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent))
            {
                GooagooLog.info("发布CMS内容失败[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            cmsContent.setPublishStatus("P");
            if (!this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent))
            {
                GooagooLog.info("发布CMS内容失败[cmsContentId=" + cmsContentId + "]");
                return false;
            }
            String conJson = cmsContent.getTemplateData();
            if (StringUtils.isBlank(conJson))
            {
                return false;
            }
            Map<String, String> conMap = JsonUtils.json2Map(conJson);
            String pubCon = conMap.get("publish");
            //发布内容只包括cms内容信息本身，发布cms内容信息时需通过模板规则将模板内容生成静态文件保存到指定文件夹中
            this.publishProtectedCoreService.generateEventOrCmsHtml(cmsContent, cmsContent.getChannelType());
            //递归发布所有子级cms内容
            return this.recursionReleaseAllSubCmsContent(cmsContentId);
        }
    }

    /**
     * //初始化CMS内容信息(手机/网站)
     * @param shopId
     * @param type(M:手机,W:网站)
     * @return
     */
    private CmsContent initCmsContent(String shopId, String type) throws Exception
    {
        CmsContent cmsContent = new CmsContent();
        if ("M".equals(type))
        {
            cmsContent.setCmsContentId(UUID.getUUID());
            cmsContent.setCmsContentName("手机");
            cmsContent.setOrderNo(2);
            cmsContent.setChannelType("M");
            cmsContent.setCmsContentUrl(UrlUtils.getCmsUrl(cmsContent.getCmsContentId()));
        }
        else if ("W".equals(type))
        {
            cmsContent.setCmsContentId(UUID.getUUID());
            cmsContent.setCmsContentName("网站");
            cmsContent.setOrderNo(1);
            cmsContent.setChannelType("W");
            cmsContent.setCmsContentUrl(UrlUtils.getCmsUrl(cmsContent.getCmsContentId()));
        }
        cmsContent.setTemplateId("");
        cmsContent.setCmsContentType("C");//CMS内容类型:栏目
        cmsContent.setParentCmsContentId("-1");
        cmsContent.setTemplateData("");
        cmsContent.setIsTop("N");
        cmsContent.setShopId(shopId);
        cmsContent.setPublishStatus("W");
        cmsContent.setIsDel("N");
        return cmsContent;
    }

    /**
     * 递归发布所有子级cms内容
     * @param parentCmsContentId 父级cms内容编号
     * @throws IOException 
     */
    private boolean recursionReleaseAllSubCmsContent(String parentCmsContentId) throws Exception
    {
        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.createCriteria().andParentCmsContentIdEqualTo(parentCmsContentId).andPublishStatusEqualTo("A").andIsDelEqualTo("N");
        List<CmsContent> cmsContentList = this.cmsContentGeneratorCoreService.selectByExample(cmsContentExample);
        if (CollectionUtils.isNotEmpty(cmsContentList))
        {
            for (CmsContent cmsContent : cmsContentList)
            {
                cmsContent.setPublishStatus("P");
                cmsContent.setPublishTime(new Date());
                if (!this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent))
                {
                    GooagooLog.info("发布CMS内容失败[cmsContentId=" + cmsContent.getCmsContentId() + "]");
                    return false;
                }
                //发布内容只包括cms内容信息本身，发布cms内容信息时通过模板规则将模板内容生成静态文件保存到指定文件夹中
                String conJson = cmsContent.getTemplateData();
                if (StringUtils.isBlank(conJson))
                {
                    continue;
                }
                Map<String, String> conMap = JsonUtils.json2Map(conJson);
                String pubCon = conMap.get("publish");
                this.publishProtectedCoreService.generateEventOrCmsHtml(cmsContent, cmsContent.getChannelType());
                this.recursionReleaseAllSubCmsContent(cmsContent.getCmsContentId());
            }
        }
        return true;
    }

    /**
     * 递归删除所有子级cms内容
     * @param parentCmsContentId 父级cms内容编号
     */
    private boolean recursionDeleteAllSubCmsContent(String parentCmsContentId)
    {
        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.createCriteria().andParentCmsContentIdEqualTo(parentCmsContentId);
        List<CmsContent> cmsContentList = this.cmsContentGeneratorCoreService.selectByExample(cmsContentExample);
        if (CollectionUtils.isNotEmpty(cmsContentList))
        {
            for (CmsContent cmsContent : cmsContentList)
            {
                if (!this.cmsContentGeneratorCoreService.deleteByPrimaryKey(cmsContent.getCmsContentId()))
                {
                    GooagooLog.info("删除cms内容信息失败[cmsContentId=" + cmsContent.getCmsContentId() + "]");
                    return false;
                }
                ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
                String generateurl = bundle.getString("cms_generateurl");//生成路径
                File file = new File(generateurl + cmsContent.getCmsContentId() + ".html");
                if (file.exists() && file.isFile())
                {
                    file.delete();
                }
                this.recursionDeleteAllSubCmsContent(cmsContent.getCmsContentId());
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean channelSeqencing(List<String> cmsContentIdList) throws Exception
    {
        if (CollectionUtils.isEmpty(cmsContentIdList))
        {
            return false;
        }
        for (int i = 0; i < cmsContentIdList.size(); i++)
        {
            String cmsContentId = cmsContentIdList.get(i);
            CmsContent cmsContent = new CmsContent();
            cmsContent.setCmsContentId(cmsContentId);
            cmsContent.setOrderNo(i + 1);
            if (!this.cmsContentGeneratorCoreService.updateByPrimaryKeySelective(cmsContent))
            {
                GooagooLog.info("栏目排序失败[cmsContentId=" + cmsContentId + "orderNo=" + i + 1 + "]");
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCmsContentUrl(String shopId, String channelType) throws Exception
    {
        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.createCriteria().andShopIdEqualTo(shopId).andParentCmsContentIdEqualTo("-1").andChannelTypeEqualTo(channelType).andIsDelEqualTo("N");
        List<CmsContent> cmsContentList = this.cmsContentGeneratorCoreService.selectByExample(cmsContentExample);
        if (CollectionUtils.isEmpty(cmsContentList))
        {
            return null;
        }
        CmsContentExample cmsContentExampleSub = new CmsContentExample();
        cmsContentExampleSub.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N").andParentCmsContentIdEqualTo(cmsContentList.get(0).getCmsContentId()).andChannelTypeEqualTo("M").andPublishStatusEqualTo("P").andCmsContentTypeEqualTo("C");
        List<CmsContent> cmsContentListSub = this.cmsContentGeneratorCoreService.selectByExample(cmsContentExample);
        if (CollectionUtils.isNotEmpty(cmsContentListSub))
        {
            return cmsContentListSub.get(0).getCmsContentUrl();
        }
        return null;
    }
}
