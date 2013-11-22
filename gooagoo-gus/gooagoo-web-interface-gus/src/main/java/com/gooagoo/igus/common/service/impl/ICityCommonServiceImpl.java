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
import com.gooagoo.igus.common.service.ICityCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.UCity;

@Service("iCityCommonService")
public class ICityCommonServiceImpl implements ICityCommonService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST)
    public TransData<Object> getCityList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String provinceId = ServletRequestUtils.getStringParameter(request, "provinceId");
            //1、获取市列表
            UserCityareaExample queryCondition = new UserCityareaExample();
            queryCondition.createCriteria().andParentCityIdEqualTo(provinceId).andLevelCodeEqualTo("C").andIsDelEqualTo("N");
            queryCondition.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.info("查询区列表：未获取到满足条件的市列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UCity> ucityList = new ArrayList<UCity>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                try
                {
                    UCity ucity = new UCity();
                    ucity.setCityId(userCityarea.getCityId());
                    ucity.setCityName(userCityarea.getCityName());
                    ucityList.add(ucity);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询市列表：组装单个市信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ucityList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询市列表：查询市列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}
