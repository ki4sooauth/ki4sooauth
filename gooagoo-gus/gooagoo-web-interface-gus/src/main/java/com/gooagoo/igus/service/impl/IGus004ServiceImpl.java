package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UProvince;

/**
 * 获取省列表
 * @author SPZ
 *
 */
@Service("igus004Service")
public class IGus004ServiceImpl implements IGusService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            UserCityareaExample userCityareaExample = new UserCityareaExample();
            userCityareaExample.createCriteria().andLevelCodeEqualTo("P").andIsDelEqualTo("N");
            userCityareaExample.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(userCityareaExample);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.error("获取省列表：未获取到满足条件的省列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UProvince> uprovinceList = new ArrayList<UProvince>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                UProvince uprovince = new UProvince();
                uprovince.setProvinceId(userCityarea.getCityId());
                uprovince.setProvinceName(userCityarea.getCityName());
                uprovinceList.add(uprovince);
            }
            transData = new TransData<Object>(true, null, uprovinceList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取省列表：获取省列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
