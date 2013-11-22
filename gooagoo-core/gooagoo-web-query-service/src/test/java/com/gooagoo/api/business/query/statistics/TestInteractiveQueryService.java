package com.gooagoo.api.business.query.statistics;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.query.business.statistics.InteractiveQueryServiceImpl;

public class TestInteractiveQueryService
{

    public InteractiveQueryService interactiveService;

    @Before
    public void testBefore()
    {
        interactiveService = new InteractiveQueryServiceImpl();
    }

    /**
     * 查询手机互动人数
     * @throws Exception
     */
    public void testFindPhoneInterPeopleNum() throws Exception
    {
        Date date = TimeUtils.convertStringToDate("2013-10-30");
        //01822MAPVKNP054085QBQVEIISWR0JGT_1_M_Y2013M10D28
        InteractiveQueryService i = new InteractiveQueryServiceImpl();
        int num = i.findPhoneInterPeopleNum("01822R97QK2FRDT085QBV2EIISWR0JGT", "D", "A", date);
        System.out.println(num);
    }

    /**
     * 查询手机互动次数
     * @throws Exception
     */
    @Test
    public void testFindPhoneInterTimes() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询手机互动人群
     * @throws Exception
     */
    @Test
    public void testFindPhoneInterPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查询网站互动人数
     * @throws Exception
     */
    @Test
    public void testFindWebInterPeopleNum() throws Exception
    {
        InteractiveQueryService interactiveService = new InteractiveQueryServiceImpl();
        int i = interactiveService.findWebInterPeopleNum("185EVK63KPRTKH00A1BAQJMCA2H349CC", "", "A", null);
        System.out.println(i);
    }

    /**
     * 查询网站互动次数
     * @throws Exception
     */
    @Test
    public void testFindWebInterTimes() throws Exception
    {
        Assert.assertNotNull("", "");
    }

    /**
     * 查询网站互动人群
     * @throws Exception
     */
    @Test
    public void testFindWebInterPeople() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
