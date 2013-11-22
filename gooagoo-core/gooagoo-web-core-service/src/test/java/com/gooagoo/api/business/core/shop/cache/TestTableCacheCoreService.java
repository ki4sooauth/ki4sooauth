package com.gooagoo.api.business.core.shop.cache;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisListDao;
import com.google.gson.reflect.TypeToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestTableCacheCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public TableCacheCoreService tableCacheCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfo() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfoByType() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 通过餐桌号查询餐桌信息
     * @throws Exception
     */
    @Test
    public void testFindTableInfoByStatus() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 平台查询博立协议的房台汇总信息（餐桌状态查询）
     * @throws Exception
     */
    @Test
    public void testUpdateTableStatus() throws Exception
    {
        String mac = "40:2c:f4:a8:38:b0";
        String shopentityid = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String json = "[{\"tablearea\":\"空闲\",\"tablename\":\"101台\",\"tableno\":\"101\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"102台\",\"tableno\":\"102\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"103台\",\"tableno\":\"103\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"104台\",\"tableno\":\"104\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"105台\",\"tableno\":\"105\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"106台\",\"tableno\":\"106\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"107台\",\"tableno\":\"107\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"108台\",\"tableno\":\"108\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"109台\",\"tableno\":\"109\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"110台\",\"tableno\":\"110\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"111台\",\"tableno\":\"111\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"112台\",\"tableno\":\"112\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"113台\",\"tableno\":\"113\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"114台\",\"tableno\":\"114\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"115台\",\"tableno\":\"115\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"116台\",\"tableno\":\"116\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"117台\",\"tableno\":\"117\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"},{\"tablearea\":\"空闲\",\"tablename\":\"118台\",\"tableno\":\"118\",\"tablestate\":\"空闲\",\"tabletype\":\"标准台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"131台\",\"tableno\":\"131\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"132台\",\"tableno\":\"132\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"133台\",\"tableno\":\"133\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"134台\",\"tableno\":\"134\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"135台\",\"tableno\":\"135\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"136台\",\"tableno\":\"136\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"137台\",\"tableno\":\"137\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += ",{\"tablearea\":\"空闲\",\"tablename\":\"138台\",\"tableno\":\"138\",\"tablestate\":\"已点餐\",\"tabletype\":\"测试台\",\"payment\":\"0.00\"}";
        json += "]";
        TypeToken<List<Map<String, String>>> typeToken = new TypeToken<List<Map<String, String>>>()
        {
        };
        List<Map<String, String>> tablesinfo = JsonUtils.json2Genericity(json, typeToken);
        Assert.isTrue(this.tableCacheCoreService.updateTableStatus(mac, shopentityid, tablesinfo), "查询博立协议的房台汇总信息失败");
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        //        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.catering_table);
        //        RedisDatabase baseDao = new RedisDatabase(RedisServerConstants.catering_table);
        //        String key2 = "01822K7105HMGOM07GRNH4EIISWR2K8D_0_101台";
        //        String key3 = "01822K7105HMGOM07GRNH4EIISWR2K8D_1_标准台";
        //        String key4 = "01822K7105HMGOM07GRNH4EIISWR2K8D_2_空闲";
        //        String key5 = "01822K7105HMGOM07GRNH4EIISWR2K8D_标准台_空闲";
        List<String> list = redisListDao.get(shopentityid);
        //        Map<String, String> map2 = redisHashDao.get(key2);
        //        List<String> list3 = redisListDao.get(key3);
        //        List<String> list4 = redisListDao.get(key4);
        //        List<String> list5 = redisListDao.get(key5);
        System.out.println("key1::::::::" + list.toString());
        //        System.out.println("key2::::::::" + map2.toString());
        //        System.out.println("key3::::::::" + list3.toString());
        //        System.out.println("key4::::::::" + list4.toString());
        //        System.out.println("key5::::::::" + list5.toString());
        //        baseDao.del(key1);
        //        baseDao.del(key2);
        //        baseDao.del(key3);
        //        baseDao.del(key4);
        //        baseDao.del(key5);
    }

}
