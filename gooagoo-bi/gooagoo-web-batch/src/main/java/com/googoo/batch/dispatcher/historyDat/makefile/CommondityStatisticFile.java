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
public class CommondityStatisticFile implements Tyre
{
    private final MongoDao goodsSerial_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSSERIAL_FILE_INFO);
    private final MongoDao goodsCategory_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSCATEGORY_FILE_INFO);
    private final MongoDao goodsBrand_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSBRAND_FILE_INFO);

    @Override
    public void run()
    {
        MongoDao[] mongoDaos = { this.goodsSerial_file_dao, this.goodsCategory_file_dao, this.goodsBrand_file_dao };
        String[] titles = { "商品统计", "品类统计", "品牌统计" };
        String[] dirs = { BatchConsants.GOODS, BatchConsants.CATEGORY, BatchConsants.BRAND };
        for (int i = 0; i < 3; i++)
        {
            List<DBObject> all = mongoDaos[i].findAll();
            for (DBObject obj : all)
            {
                String id = obj.get("_id").toString();

                DBObject browses = (DBObject) obj.get("browse");
                DBObject collects = (DBObject) obj.get("collect");
                DBObject pays = (DBObject) obj.get("pay");
                DBObject comments = (DBObject) obj.get("comment");

                this.statistic(id, browses, collects, pays, comments, titles[i], dirs[i]);
            }
        }
    }

    private void statistic(String id, DBObject browses, DBObject collects, DBObject pays, DBObject comments, String title, String dir)
    {
        List<Integer> brows = new ArrayList<Integer>();
        List<Integer> collect = new ArrayList<Integer>();
        List<Integer> pay = new ArrayList<Integer>();
        List<Integer> comment = new ArrayList<Integer>();
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
                pay = this.getNums(pays, pay, "H", date);
                comment = this.getNums(comments, comment, "H", date);
            }
            this.saveFile(id, brows, collect, pay, comment, dateList, title, dir);
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
                pay = this.getNums(pays, pay, "D", date);
                comment = this.getNums(comments, comment, "D", date);
            }
            this.saveFile(id, brows, collect, pay, comment, dateList, title, dir);
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
                pay = this.getNums(pays, pay, "M", date);
                comment = this.getNums(comments, comment, "M", date);
            }
            this.saveFile(id, brows, collect, pay, comment, dateList, title, dir);
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
                pay = this.getNums(pays, pay, "Y", date);
                comment = this.getNums(comments, comment, "Y", date);
            }
            this.saveFile(id, brows, collect, pay, comment, dateList, title, dir);
        }
    }

    private void saveFile(String id, List<Integer> brows, List<Integer> collect, List<Integer> pay, List<Integer> comment, List<String> dateList, String title, String dir)
    {
        Map<String, List<?>> dataMap = new HashMap<String, List<?>>();
        dataMap.put("浏览", brows);
        dataMap.put("收藏", collect);
        dataMap.put("消费", pay);
        dataMap.put("评论", comment);
        LineChartVo chartVo = new LineChartVo();
        String chartStr = chartVo.create(title, "人次", "次", dateList, dataMap);
        String fileName = FileUtils.getfileName(id);
        FileUtils.createAndWriteFile(dir, chartStr, fileName);
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