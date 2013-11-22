package com.googoo.batch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.ResourceBundle;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.utils.SpringBeanUtils;

public class Timestamp
{
    public static final String ACTIVTTY_LAST_TIMESTAMP = "activityTimeStamp";
    public static final String GOODS_LAST_TIMESTAMP = "goodsTimeStamp";
    public static final String COUPON_LAST_TIMESTAMP = "couponTimeStamp";
    public static final String MEMBERFEATURE = "memberFeature";
    public static final String USER_SHOP = "userShop";
    public static final String MEMBEROFCARD = "memberofcard";
    public static final String SHOP_POSITION = "shopPosition";
    public static final String MEMBER_BASE_ACCOUNT = "member_base_account";
    public static final String GOODS_AVG = "goodsavg";
    public static final String GUESS_YOU_LIKE = "guessYouLike";

    public static void del()
    {
        String baseDir = System.getProperty("java.io.tmpdir") + "gooagooLastTime/";
        File path = new File(baseDir);
        path.delete();
        System.out.println("Over");
    }

    private static final String baseDir;
    static
    {
        String tmpdir = "";
        try
        {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("batch");
            tmpdir = resourceBundle.getString("tmpdir");
            File tmpPath = new File(tmpdir);
            if (!tmpPath.exists())
            {
                tmpdir = System.getProperty("java.io.tmpdir");
            }
        }
        catch (Exception e)
        {
            GooagooLog.debug("临时文件目录没有指定，使用操作系统临时目录");
            tmpdir = System.getProperty("java.io.tmpdir");
        }
        baseDir = tmpdir + "/gooagooLastTime/";
        File path = new File(baseDir);
        if (!path.exists())
        {
            path.mkdir();
        }
    }

    /**
     *  记录上次跑批的时间戳
     * @param key
     * @return
     */
    public static Date lastTime(String key)
    {
        SystemBusinessCoreService service = SpringBeanUtils.getBean(SystemBusinessCoreService.class);
        Date sysTime = service.getCoreSysCurrentTime();
        Date d = new Date(0);
        try
        {
            File file = new File(baseDir, key + ".tmp");
            if (file.exists())
            {
                try
                {
                    InputStream is = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(is);
                    long datetime = ois.readLong();
                    d = new Date(datetime);
                    ois.close();
                    is.close();
                }
                catch (Exception e)
                {
                    GooagooLog.error("临时文件中记录的时间戳格式不正确(可以不理会，稍后会重新生成文件)", e);
                }
            }

            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeLong(sysTime.getTime());
            oos.flush();
            oos.close();
            os.close();
        }
        catch (Exception e)
        {
            GooagooLog.error("记录上次跑批的时间戳", e);
        }
        /* RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.business_user);
         Date d = new Date(sortedSetDao.getScore("lastTime", key).longValue());
         sortedSetDao.put("lastTime", sysTime.getTime(), key);*/
        return d;
    }

    public static void main(String[] args)
    {

        System.out.println(System.getProperty("java.io.tmpdir"));
        /**RedisDatabase database = new RedisDatabase(RedisServerConstants.business_user);
        database.del("lastTime");**/
        //RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.business_user);
        //sortedSetDao.delElement("lastTime", "userShop");

    }
}
