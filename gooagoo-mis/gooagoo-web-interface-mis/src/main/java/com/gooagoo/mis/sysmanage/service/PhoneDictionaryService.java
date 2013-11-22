package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MPhoneDictionary;

public interface PhoneDictionaryService
{

    /**
     * 添加手机型号字典数据
     * @return
     * @throws gooagooException
     */
    public TransData<Object> addPhoneDic(HttpServletRequest request) throws Exception;

    /**
     * 修改手机型号字典数据
     * @return
     * @throws gooagooException
     */
    public TransData<Object> editPhoneDic(HttpServletRequest request) throws Exception;

    /**
     * 删除手机型号字典数据
     * @return
     * @throws gooagooException
     */
    public TransData<Object> delPhoneDic(HttpServletRequest request) throws Exception;

    /**
     * 查询手机型号字典详细信息
     * @return
     * @throws gooagooException
     */
    public TransData<MPhoneDictionary> findPhoneDictDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询手机型号字典数据
     * @return
     * @throws gooagooException
     */
    public TransData<PageModel<MPhoneDictionary>> findPhoneAllDict(HttpServletRequest request) throws Exception;

}
