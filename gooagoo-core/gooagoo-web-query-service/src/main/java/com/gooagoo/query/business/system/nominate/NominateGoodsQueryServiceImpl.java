package com.gooagoo.query.business.system.nominate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.nominate.NominateGoodsQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.sys.nominate.NominateGoodsAdapterMapper;
import com.gooagoo.entity.business.system.nominate.NominateGoodsBusiness;
import com.google.gson.Gson;

@Service
public class NominateGoodsQueryServiceImpl implements NominateGoodsQueryService
{

    @Autowired
    private NominateGoodsAdapterMapper nominateGoodsAdapterMapper;

    @Override
    public List<NominateGoodsBusiness> findNominateGoodsBusiness(NominateGoodsBusiness nominateGoodsBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateGoodsBusiness-->入参:" + nominateGoodsBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateGoodsBusiness snominateGoodsBusiness = this.convertEndTime(nominateGoodsBusiness);
        pageIndex = this.pageIndex(pageIndex, pageSize);
        if (snominateGoodsBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐商品表结束时间处理" + TimeUtils.convertDateToString(snominateGoodsBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        GooagooLog.info("findNominateGoodsBusiness-->入参分页处理:" + pageIndex);
        List<NominateGoodsBusiness> nominateGoodsBusinessList = this.nominateGoodsAdapterMapper.findNominateGoodsBusiness(snominateGoodsBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的商品信息:" + new Gson().toJson(nominateGoodsBusinessList));
        return nominateGoodsBusinessList;
    }

    @Override
    public int countNominateGoodsBusiness(NominateGoodsBusiness nominateGoodsBusiness)
    {
        GooagooLog.info("countNominateGoodsBusiness-->入参:" + nominateGoodsBusiness);
        NominateGoodsBusiness snominateGoodsBusiness = this.convertEndTime(nominateGoodsBusiness);
        if (snominateGoodsBusiness.getEndTime() != null)
        {
            GooagooLog.info("countNominateGoodsBusiness-->入参推荐商品表结束时间处理" + TimeUtils.convertDateToString(snominateGoodsBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateGoodsAdapterMapper.countNominateGoodsBusiness(snominateGoodsBusiness);

        GooagooLog.debug("取出来的商品信息数量:" + count);
        return count;

    }

    @Override
    public List<NominateGoodsBusiness> findNominateGoods(NominateGoodsBusiness nominateGoodsBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateGoods-->入参:" + nominateGoodsBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateGoodsBusiness snominateGoodsBusiness = this.convertEndTime(nominateGoodsBusiness);
        pageIndex = this.pageIndex(pageIndex, pageSize);
        if (snominateGoodsBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoods-->入参推荐商品表结束时间处理" + TimeUtils.convertDateToString(snominateGoodsBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        GooagooLog.info("findNominateGoods-->入参分页处理:" + pageIndex);
        List<NominateGoodsBusiness> nominateGoodsBusinessList = this.nominateGoodsAdapterMapper.findNominateGoods(nominateGoodsBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的商品信息:" + new Gson().toJson(nominateGoodsBusinessList));
        return nominateGoodsBusinessList;
    }

    @Override
    public int countNominateGoods(NominateGoodsBusiness nominateGoodsBusiness)
    {
        GooagooLog.info("countNominateGoodsBusiness-->入参:" + nominateGoodsBusiness);
        NominateGoodsBusiness snominateGoodsBusiness = this.convertEndTime(nominateGoodsBusiness);
        if (snominateGoodsBusiness.getEndTime() != null)
        {
            GooagooLog.info("countNominateGoodsBusiness-->入参推荐商品表结束时间处理" + TimeUtils.convertDateToString(snominateGoodsBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateGoodsAdapterMapper.countNominateGoods(snominateGoodsBusiness);

        GooagooLog.debug("取出来的商品信息数量:" + count);
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

    private NominateGoodsBusiness convertEndTime(NominateGoodsBusiness nominateGoodsBusiness)
    {
        NominateGoodsBusiness snominateGoodsBusiness = nominateGoodsBusiness;
        Date endTime = null;
        try
        {
            if (snominateGoodsBusiness.getEndTime() != null)
            {
                endTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateGoodsBusiness.getEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        snominateGoodsBusiness.setEndTime(endTime);
        return snominateGoodsBusiness;
    }

}
