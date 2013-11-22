package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MUserCityarea;

public interface UserCityDictionaryService
{

    /**
     * 添加省份城市字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addUserDic(HttpServletRequest request) throws Exception;

    /**
     * 修改省份城市字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editUserDic(HttpServletRequest request) throws Exception;

    /**
     * 删除省份城市字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delUserDic(HttpServletRequest request) throws Exception;

    /**
     * 查询省份城市字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MUserCityarea>> findUserCityareaDict(HttpServletRequest request) throws Exception;

    /**
     * 查询省份城市字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MUserCityarea> findUserCityDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增省份城市字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllUserCity(HttpServletRequest request) throws Exception;
    
}
