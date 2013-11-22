package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UArea;

/**
 * 获取区县列表
 * @author SPZ
 *
 */
@Service("igus006Service")
public class IGus006ServiceImpl implements IGusService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String cityId = ServletRequestUtils.getStringParameter(request, "cityId");
            UserCityareaExample userCityareaExample = new UserCityareaExample();
            userCityareaExample.createCriteria().andParentCityIdEqualTo(cityId).andLevelCodeEqualTo("D").andIsDelEqualTo("N");
            userCityareaExample.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(userCityareaExample);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.error("获取区县列表：未获取到满足条件的区县列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UArea> uareaList = new ArrayList<UArea>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                UArea uarea = new UArea();
                uarea.setAreaId(userCityarea.getCityId());
                uarea.setAreaName(userCityarea.getCityName());
                uareaList.add(uarea);
            }
            transData = new TransData<Object>(true, null, uareaList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取区县列表：获取区县列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
