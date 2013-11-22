package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.igus.common.service.IProvinceCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UProvince;

@Service("iProvinceCommonService")
public class IProvinceCommonServiceImpl implements IProvinceCommonService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST)
    public TransData<Object> getProvinceList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //1、获取省列表
            UserCityareaExample queryCondition = new UserCityareaExample();
            queryCondition.createCriteria().andLevelCodeEqualTo("P").andIsDelEqualTo("N");
            queryCondition.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.info("查询省列表：未获取到满足条件的省列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UProvince> uprovinceList = new ArrayList<UProvince>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                UProvince uprovince = new UProvince();
                uprovince.setProvinceId(userCityarea.getCityId());
                uprovince.setProvinceName(userCityarea.getCityName());
                uprovinceList.add(uprovince);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uprovinceList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询省列表：查询省列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}
