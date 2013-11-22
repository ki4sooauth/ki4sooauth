package com.gooagoo.api.business.core.system.cms;

import java.util.List;

import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;

public interface SysCmsContentCoreService
{

    /**
     * 初始化CMS内容根节点(网站:内容编号为1、手机:内容编号为2)
     * @param shopId 商家编号
     * @return True/False
     * @throws Exception
     */
    public boolean initCmsContentRoot(String shopId) throws Exception;

    /**
     * 创建CMS内容信息
     * @param CmsContent cms内容信息
     * @return True/False
     * @throws Exception
     */
    public boolean addCmsContent(CmsContent cmsContent) throws Exception;

    /**
     * 修改CMS内容信息
     * @param CmsContent cms内容信息
     * @return True/False
     * @throws Exception
     */
    public boolean updateCmsContent(CmsContent cmsContent) throws Exception;

    /**
     * 删除CMS内容信息
     * @param cmsContentId cms内容信息的主键
     * @return True/False
     * @throws Exception
     */
    public boolean deleteCmsContent(String cmsContentId) throws Exception;

    /**
     * 审核CMS内容信息
     * @param cmsContentId CMS内容信息的主键
     * @param publishStatus 审核状态
     * @param auditNote 审核备注
     * @return True/False
     * @throws TemplateDataIsEmptyException cms内容模板数据为空异常
     */
    public boolean checkCmsContent(String cmsContentId, String publishStatus, String auditNote) throws Exception;

    /**
     * 发布CMS内容信息
     * @param cmsContentId CMS内容信息的主键
     * @return True/False
     * @throws Exception
     */
    public boolean publishCmsContent(String cmsContentId) throws Exception;

    /**
     * 发布全部CMS内容信息
     * @param cmsContentId CMS内容信息的主键
     * @return True/False
     * @throws Exception
     */
    public boolean publishAllCmsContent(String cmsContentId) throws Exception;

    /**
     * 栏目排序
     * @param cmsContentIdList cms内容信息的主键列表
     * @return True/False
     * @throws Exception
     */
    public boolean channelSeqencing(List<String> cmsContentIdList) throws Exception;

    /**
     * 获取手机虚拟商家、网站虚拟商家访问路径
     * @param shopId 商家编号
     * @param channelType 栏目分类:M-手机、W-网站
     * @return String 手机虚拟商家、网站虚拟商家访问路径
     * @throws Exception
     */
    public String getCmsContentUrl(String shopId, String channelType) throws Exception;

}
