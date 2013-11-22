package com.gooagoo.icms.cmsContent.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooaoo.view.cms.MCmsContent;
import com.gooaoo.view.common.PageModel;
import com.gooaoo.view.common.ZTreeNode;

public interface CmsContentService
{
    /**
     * 初始化根结点
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> initRoot(HttpServletRequest request) throws Exception;

    /**
     * 创建cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 删除cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 修改cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 获取cms内容信息列表（分页）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MCmsContent>> pageCmsContent(HttpServletRequest request) throws Exception;

    /**
     * 获取cms内容信息列表（不分页） 
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<ZTreeNode>> getCmsContentList(HttpServletRequest request) throws Exception;

    /**
     *  获取cms内容信息详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MCmsContent> getCmsContent(HttpServletRequest request) throws Exception;

    /**
     * 审核cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> relese(HttpServletRequest request) throws Exception;

    /**
     * 发布全部cms内容信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> releseAll(HttpServletRequest request) throws Exception;

    /**
     * 判断是否初初始化根结点
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> isInitRoot(HttpServletRequest request) throws Exception;

}