package com.googoo.batch.dispatcher.historyDat.makefile;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ActivityStatisticFileTest
{

    @Test
    public void test()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.ACTIVITY_FILE_INFO);

        List<DBObject> all = dao.findAll();
        for (DBObject obj : all)
        {
            if (obj.get("browse") != null)
            {
                String id = obj.get("_id").toString();
                if (id.endsWith("D"))
                {
                    for (int i = 0; i < 30; i++) //按天统计
                    {
                        Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, new Date(), 0 - i);
                        //System.out.println(date);
                        int year = this.getYearOfTime(date);
                        int month = this.getMonthOfTime(date);
                        int day = this.getDayOfTime(date);
                        int nums = obj.get("browse.Y" + year + "M" + month + "D" + day) == null ? 0 : Integer.parseInt(obj.get("browse.Y" + year + "M" + month + "D" + day).toString());
                        System.out.println(obj.get("_id") + " : " + "Y" + year + "M" + month + "D" + day + ":" + nums);

                    }

                    for (int i = 0; i < 12; i++) //按月统计
                    {

                    }
                }
            }
        }

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

    @Test
    public void time()
    {
        Calendar nTime = Calendar.getInstance();
        //nTime.setTime(now);
        int nYear = nTime.get(Calendar.YEAR);
        int nMonth = nTime.get(Calendar.MONTH) + 1;
        int nDay = nTime.get(Calendar.DAY_OF_MONTH);
        int hour = nTime.get(Calendar.HOUR_OF_DAY);

        System.out.println(nYear);
        System.out.println(nMonth);
        System.out.println(nDay);
        System.out.println(hour);

        for (int i = nYear - 5; i <= nYear; i++)
        {

            Date date = TimeUtils.dateAdd(TimeUtils.DATATYPE_YEAR, new Date(), i - nYear);
            System.out.println(date);
        }

    }

    @Test
    public void time2()
    {
        Format df = new SimpleDateFormat("yyyy-MM-dd-HH");
        System.out.println(df.format(new Date()));
    }

    @Test
    public void getNums()
    {
        //0182AIEG0LNI34H0NCQU1KEIISWR2HCH_N_*_W_D
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.ACTIVITY_FILE_INFO);

        BasicDBObject obj = new BasicDBObject();
        obj.put("_id", "0182AIEG0LNI34H0NCQU1KEIISWR2HCH_N_*_W_D");

        DBObject object = dao.findByDbObject(obj);

        DBObject browses = (DBObject) object.get("browse");

        System.out.println(browses.toMap().size());//判断browses里的长度
    }

    @Test
    public void trun()
    {
        ActivityStatisticFile tt = new ActivityStatisticFile();
        tt.run();
    }

    @Test
    public void testName()
    {
        String id = "187UAOEKS21ISA00A1BAQJMEBDHS6DBR_M_2_*_H";

        StringBuffer fileName = new StringBuffer();
        String[] ids = id.split("_");
        for (int i = 0; i < ids.length - 1; i++)
        {
            if (StringUtils.isNotBlank(ids[i]))
            {
                if ("*".equals(ids[i]))
                {
                    fileName.append("()" + "_");
                }
                else
                {
                    fileName.append(ids[i] + "_");
                }
            }
        }
        /*
        if ("Y".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy");
            fileName.append(df.format(new Date()));
        }
        */
        if ("M".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy");
            fileName.append(df.format(new Date()));
        }
        else if ("D".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy-MM");
            fileName.append(df.format(new Date()));
        }
        else if ("H".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy-MM-dd");
            fileName.append(df.format(new Date()));
        }
        System.out.println(fileName.toString());

    }
}
