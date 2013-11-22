package com.gooagoo.mis.sysmanage.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.PhoneDictionaryService;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MPhoneDictionary;

@Service(value = "phoneDictionaryService")
public class PhoneDictionaryServiceImpl implements PhoneDictionaryService
{

//    @Autowired
//    private CoreDictionaryService coreDictionaryService;
//    @Autowired
//    private QueryDictionaryService queryDictionaryService;

    /**
     * 手机型号字典添加
     */
    @Override
    public TransData<Object> addPhoneDic(HttpServletRequest request) throws Exception
    {
       // PhoneDictionaryRequest phone = ServletUtils.objectMethod(PhoneDictionaryRequest.class, request);
        boolean flag = false;
        //boolean flag = this.coreDictionaryService.add(phone);
        return new TransData<Object>(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL);
    }

    /**
     * 手机型号字典编辑
     */
    @Override
    public TransData<Object> editPhoneDic(HttpServletRequest request) throws Exception
    {
        //PhoneDictionaryRequest phone = ServletUtils.objectMethod(PhoneDictionaryRequest.class, request);
        boolean flag = false;
        //boolean flag = this.coreDictionaryService.update(phone);
        return new TransData<Object>(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL);
    }

    /**
     * 手机型号字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delPhoneDic(HttpServletRequest request) throws Exception
    {
        //String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        //String[] ids = dicIds.split(",");
        boolean flag = false;
        /*for (int i = 0; i < ids.length; i++)
        {
            PhoneDictionaryRequest phone = new PhoneDictionaryRequest();
            phone.setId(ids[i] != null && !"".equals(ids[i]) ? Integer.parseInt(ids[i]) : null);
            phone.setIsDel("Y");
            flag = this.coreDictionaryService.update(phone);
            if (!flag)
            {
                break;
            }
        }*/
        return new TransData<Object>(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询手机型号字典详情
     */
    @Override
    public TransData<MPhoneDictionary> findPhoneDictDetail(HttpServletRequest request) throws Exception
    {
       // String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
       // String[] dicId = dicIds.split(",");
        MPhoneDictionary phone = null;
        //MPhoneDictionary phone = this.queryDictionaryService.getDictionaryInfo(dicId[0]);
        return new TransData<MPhoneDictionary>(true, null, phone);
    }

    /**
     * 查询手机型号字典信息 
     */
    @Override
    public TransData<PageModel<MPhoneDictionary>> findPhoneAllDict(HttpServletRequest request) throws Exception
    {
//        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
//        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
//        pageCondition.setPageSize(pageSize);
//        PhoneDictionaryRequest phone = ServletUtils.objectMethod(PhoneDictionaryRequest.class, request);
//        if (phone.getIsDel() == null || "".equals(phone.getIsDel()))
//        {
//            phone.setIsDel("N");
//        }
//        PageModel<MPhoneDictionary> pm = null;
        //PageModel<MPhoneDictionary> pm = this.queryDictionaryService.getAllDictionary(phone, pageCondition);
        return new TransData<PageModel<MPhoneDictionary>>(true, null, null);
    }

}
