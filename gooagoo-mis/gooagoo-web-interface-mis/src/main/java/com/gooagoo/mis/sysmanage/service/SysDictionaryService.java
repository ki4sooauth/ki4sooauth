package com.gooagoo.mis.sysmanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MSysDictionary;

public interface SysDictionaryService
{

    /**
     * 添加通用字典数据
     * @return
     * @throws Exception
     */
    public TransData<Object> addDic(HttpServletRequest request) throws Exception;

    /**
     * 修改通用字典数据
     * @return
     * @throws Exception
     */
    public TransData<Object> editDic(HttpServletRequest request) throws Exception;

    /**
     * 删除通用字典数据
     * @return
     * @throws Exception
     */
    public TransData<Object> delDic(HttpServletRequest request) throws Exception;

    /**
     * 查询通用字典详细信息
     * @return
     * @throws Exception
     */
    public TransData<MSysDictionary> findSysDictDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询通用字典数据
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MSysDictionary>> findAllDict(HttpServletRequest request) throws Exception;

    /**
     * 批量新增通用字典数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllDicList(HttpServletRequest request) throws Exception;

    /**
     * 查询通用字典数据（无分页）
     * @return
     * @throws Exception
     */
    public TransData<List<MSysDictionary>> findAllDictInfo(HttpServletRequest request) throws Exception;

}
