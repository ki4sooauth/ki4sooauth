package com.gooagoo.igms.cryout.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.cryout.FCryout;

public interface CryoutService
{
    /**
     * 吆喝信息列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FCryout>> pageCryout(HttpServletRequest request) throws Exception;

    /**
     * 创建吆喝信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改吆喝信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 获取吆喝信息详细内容
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FCryout> getCryout(HttpServletRequest request) throws Exception;

    /**
     * 删除吆喝信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核吆喝信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布吆喝信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;

}
