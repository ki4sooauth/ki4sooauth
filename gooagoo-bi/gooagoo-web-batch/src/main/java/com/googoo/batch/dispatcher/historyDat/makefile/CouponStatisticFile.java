package com.googoo.batch.dispatcher.historyDat.makefile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.vo.hightChartVo.chartVo.LineChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.FileUtils;
import com.mongodb.DBObject;

@Engine(BatchTimeCnstants.makefile)
public class CouponStatisticFile implements Tyre
{
    private final MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.COUPON_FILE_INFO);

    @Override
    public void run()
    {
        List<DBObject> all = this.dao.findAll();
        for (DBObject obj : all)
        {
            String id = obj.get("_id").toString();

            DBObject browses = (DBObject) obj.get("browse");
            DBObject collects = (DBObject) obj.get("collect");
            DBObject exchanges = (DBObject) obj.get("exchange");
            DBObject uses = (DBObject) obj.get("use");
            //DBObject shares = (DBObject) obj.get("share");

            //this.statistic(id, browses, collects, exchanges, uses, shares);
            this.statistic(id, browses, collects, exchanges, uses);
        }
    }

    private void statistic(String id, DBObject browses, DBObject collects, DBObject exchanges, DBObject uses)
    {
        List<Integer> brows = new ArrayList<Integer>();
        List<Integer> collect = new ArrayList<Integer>();
        List<Integer> exchange = new ArrayList<Integer>();
        List<Integer> use = new ArrayList<Integer>();
        //List<Integer> share = new ArrayList<Integer>();

        List<String> dateList = new ArrayList<String>();
        if (id.endsWith("H"))
        {
            Calendar time = Calendar.getInstance();
            int hour = time.get(Calendar.HOUR_OF_DAY);
            for (int i = 1; i <= hour; i++)
            {
                Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_HOUR, new Date(), i - hour - 1);
                dateList.add(i + "时");
                brows = this.getNums(browses, brows, "H", date);
                collect = this.getNums(collects, collect, "H", date);
                exchange = this.getNums(exchanges, exchange, "H", date);
                use = this.getNums(uses, use, "H", date);
                //share = this.getNums(shares, share, "H", date);
            }
            this.saveFile(id, brows, collect, exchange, use, dateList);
        }
        else if (id.endsWith("D"))
        {
            Calendar time = Calendar.getInstance();
            int day = time.get(Calendar.DAY_OF_MONTH);
            for (int i = 1; i <= day; i++)
            {
                Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), i - day);
                dateList.add(i + "日");
                brows = this.getNums(browses, brows, "D", date);
                collect = this.getNums(collects, collect, "D", date);
                exchange = this.getNums(exchanges, exchange, "D", date);
                use = this.getNums(uses, use, "D", date);
                //share = this.getNums(shares, share, "D", date);
            }
            this.saveFile(id, brows, collect, exchange, use, dateList);
        }
        else if (id.endsWith("M"))
        {
            Calendar time = Calendar.getInstance();
            int month = time.get(Calendar.MONTH) + 1;
            for (int i = 1; i <= month; i++)
            {
                Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_MONTH, new Date(), i - month);
                dateList.add(i + "月");
                brows = this.getNums(browses, brows, "M", date);
                collect = this.getNums(collects, collect, "M", date);
                exchange = this.getNums(exchanges, exchange, "M", date);
                use = this.getNums(uses, use, "M", date);
                //share = this.getNums(shares, share, "M", date);
            }
            this.saveFile(id, brows, collect, exchange, use, dateList);
        }
        else if (id.endsWith("Y"))
        {
            Calendar time = Calendar.getInstance();
            int year = time.get(Calendar.YEAR);
            for (int i = year - 5; i <= year; i++)
            {
                Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), i - year);
                dateList.add(i + "年");
                brows = this.getNums(browses, brows, "Y", date);
                collect = this.getNums(collects, collect, "Y", date);
                exchange = this.getNums(exchanges, exchange, "Y", date);
                use = this.getNums(uses, use, "Y", date);
                //share = this.getNums(shares, share, "Y", date);
            }
            this.saveFile(id, brows, collect, exchange, use, dateList);
        }
    }

    private void saveFile(String id, List<Integer> brows, List<Integer> collect, List<Integer> exchange, List<Integer> use, List<String> dateList)
    {
        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
        dataMap.put("浏览", brows);
        dataMap.put("收藏", collect);
        dataMap.put("兑换", exchange);
        dataMap.put("使用", use);
        //dataMap.put("分享", share);
        LineChartVo chartVo = new LineChartVo();
        String chartStr = chartVo.create("优惠凭证统计", "人次", "次", dateList, dataMap);
        String fileName = FileUtils.getfileName(id);
        FileUtils.createAndWriteFile(BatchConsants.COUPON, chartStr, fileName);
    }

    private List<Integer> getNums(DBObject object, List<Integer> list, String type, Date date)
    {
        if (object != null)
        {
            int b_nums = object.get(this.getDateKey(type, date)) == null ? 0 : Integer.parseInt(object.get(this.getDateKey(type, date)).toString());
            list.add(b_nums);
        }
        else
        {
            list.add(0);
        }
        return list;
    }

    private String getDateKey(String type, Date date)
    {
        String result = null;
        int year = this.getYearOfTime(date);
        int month = this.getMonthOfTime(date);
        int day = this.getDayOfTime(date);
        int hour = this.getHourOfTime(date);
        if ("Y".equals(type))
        {
            result = "Y" + year;
        }
        else if ("M".equals(type))
        {
            result = "Y" + year + "M" + month;
        }
        else if ("D".equals(type))
        {
            result = "Y" + year + "M" + month + "D" + day;
        }
        else if ("H".equals(type))
        {
            result = "Y" + year + "M" + month + "D" + day + "H" + hour;
        }
        return result;
    }

    private int getYearOfTime(Date date)
    {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.YEAR);
    }

    private int getMonthOfTime(Date date)
    {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return (time.get(Calendar.MONTH) + 1);
    }

    private int getDayOfTime(Date date)
    {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.DAY_OF_MONTH);
    }

    private int getHourOfTime(Date date)
    {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.HOUR_OF_DAY);
    }
}
