package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.igus.common.service.IAreaCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UArea;

@Service("iAreaCommonService")
public class IAreaCommonServiceImpl implements IAreaCommonService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_AREACOMMON_GETAREALIST)
    public TransData<Object> getAreaList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String cityId = ServletRequestUtils.getStringParameter(request, "cityId");
            //1、获取区列表
            UserCityareaExample queryCondition = new UserCityareaExample();
            queryCondition.createCriteria().andParentCityIdEqualTo(cityId).andLevelCodeEqualTo("D").andIsDelEqualTo("N");
            queryCondition.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.info("查询区列表：未获取到满足条件的区列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UArea> uareaList = new ArrayList<UArea>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                try
                {
                    UArea uarea = new UArea();
                    uarea.setAreaId(userCityarea.getCityId());
                    uarea.setAreaName(userCityarea.getCityName());
                    uareaList.add(uarea);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询区列表：组装单个区信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uareaList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询区列表：查询区列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}
