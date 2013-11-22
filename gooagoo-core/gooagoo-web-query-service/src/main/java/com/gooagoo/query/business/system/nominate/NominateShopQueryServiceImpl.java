package com.gooagoo.query.business.system.nominate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.nominate.NominateShopQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.sys.nominate.NominateShopAdapterMapper;
import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;
import com.google.gson.Gson;

@Service
public class NominateShopQueryServiceImpl implements NominateShopQueryService
{
    @Autowired
    private NominateShopAdapterMapper nominateShopAdapterMapper;

    @Override
    public List<NominateShopBusiness> findNominateShopList(NominateShopBusiness nominateShopBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateShopList-->入参:" + nominateShopBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateShopBusiness snominateShopBusiness = this.convertEndTime(nominateShopBusiness);
        pageIndex = this.pageIndex(pageIndex, pageSize);
        if (snominateShopBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateShopList-->入参推荐商家表结束时间处理" + TimeUtils.convertDateToString(snominateShopBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        GooagooLog.info("findNominateShopList-->入参分页处理:" + pageIndex);
        List<NominateShopBusiness> nominateShopBusinessList = this.nominateShopAdapterMapper.findNominateShopList(nominateShopBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的商家信息:" + new Gson().toJson(nominateShopBusinessList));
        return nominateShopBusinessList;
    }

    @Override
    public List<NominateShopBusiness> findNominateShopBusinessList(NominateShopBusiness nominateShopBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateShopBusinessList-->入参:" + nominateShopBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateShopBusiness snominateShopBusiness = this.convertEndTime(nominateShopBusiness);
        pageIndex = this.pageIndex(pageIndex, pageSize);
        if (snominateShopBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateShopBusinessList-->入参推荐商家表结束时间处理" + TimeUtils.convertDateToString(snominateShopBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        GooagooLog.info("findNominateShopBusinessList-->入参分页处理:" + pageIndex);
        List<NominateShopBusiness> nominateShopBusinessList = this.nominateShopAdapterMapper.findNominateShopBusinessList(snominateShopBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的商家信息:" + new Gson().toJson(nominateShopBusinessList));
        return nominateShopBusinessList;
    }

    @Override
    public int CountNominateShopBusiness(NominateShopBusiness nominateShopBusiness)
    {
        GooagooLog.info("CountNominateShopBusiness-->入参:" + nominateShopBusiness);
        NominateShopBusiness snominateShopBusiness = this.convertEndTime(nominateShopBusiness);
        if (snominateShopBusiness.getEndTime() != null)
        {
            GooagooLog.info("CountNominateShopBusiness-->入参推荐商家表结束时间处理" + TimeUtils.convertDateToString(snominateShopBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateShopAdapterMapper.CountNominateShopBusiness(snominateShopBusiness);

        GooagooLog.debug("取出来的商家信息数量:" + count);
        return count;
    }

    @Override
    public int CountNominateShop(NominateShopBusiness nominateShopBusiness)
    {
        GooagooLog.info("CountNominateShopBusiness-->入参:" + nominateShopBusiness);
        NominateShopBusiness snominateShopBusiness = this.convertEndTime(nominateShopBusiness);
        if (snominateShopBusiness.getEndTime() != null)
        {
            GooagooLog.info("CountNominateShopBusiness-->入参推荐商家表结束时间处理" + TimeUtils.convertDateToString(snominateShopBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateShopAdapterMapper.countNominateShop(snominateShopBusiness);

        GooagooLog.debug("取出来的商家信息数量:" + count);
        return count;
    }

    private Integer pageIndex(Integer pageIndex, Integer pageSize)
    {
        if (pageIndex != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        return pageIndex;
    }

    private NominateShopBusiness convertEndTime(NominateShopBusiness nominateShopBusiness)
    {
        NominateShopBusiness snominateShopBusiness = nominateShopBusiness;
        Date endTime = null;
        try
        {
            if (snominateShopBusiness.getEndTime() != null)
            {
                endTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateShopBusiness.getEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        snominateShopBusiness.setEndTime(endTime);
        return snominateShopBusiness;
    }

}
