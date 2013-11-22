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
import com.gooagoo.view.gus.UCity;

/**
 * 获取市列表
 * @author SPZ
 *
 */
@Service("igus005Service")
public class IGus005ServiceImpl implements IGusService
{

    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String provinceId = ServletRequestUtils.getStringParameter(request, "provinceId");
            UserCityareaExample userCityareaExample = new UserCityareaExample();
            userCityareaExample.createCriteria().andParentCityIdEqualTo(provinceId).andLevelCodeEqualTo("C").andIsDelEqualTo("N");
            userCityareaExample.setOrderByClause("sort_order");
            List<UserCityarea> userCityareaList = this.userCityareaGeneratorQueryService.selectByExample(userCityareaExample);
            if (CollectionUtils.isEmpty(userCityareaList))
            {
                GooagooLog.error("获取市列表：未获取到满足条件的市列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UCity> ucityList = new ArrayList<UCity>();
            for (UserCityarea userCityarea : userCityareaList)
            {
                UCity ucity = new UCity();
                ucity.setCityId(userCityarea.getCityId());
                ucity.setCityName(userCityarea.getCityName());
                ucityList.add(ucity);
            }
            transData = new TransData<Object>(true, null, ucityList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取市列表：获取市列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
