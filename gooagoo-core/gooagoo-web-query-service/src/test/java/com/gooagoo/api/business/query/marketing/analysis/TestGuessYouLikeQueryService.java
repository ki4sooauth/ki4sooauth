package com.gooagoo.api.business.query.marketing.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeActivity;
import com.gooagoo.entity.business.marketing.analysis.GuessYouLikeGoods;

public class TestGuessYouLikeQueryService
{

    public GuessYouLikeQueryService guessYouLikeQueryService;

    @Before
    public void testBefore()
    {
        this.guessYouLikeQueryService = ApplicationContextUtils.getBean(GuessYouLikeQueryService.class);
    }

    /**
     * 猜你喜欢（活动）分页
     * @throws Exception
     */
    @Test
    public void testGuessYouLikeActivity() throws Exception
    {
        List<GuessYouLikeActivity> list = this.guessYouLikeQueryService.guessYouLikeActivity("01822N0IJLPA8N700C5V4PBJ43P1R5JO", 0, 5);
        for (GuessYouLikeActivity activity : list)
        {
            System.out.println(activity.getActivityId() + " : " + activity.getActivityName());
        }
    }

    /**
     * 猜你喜欢（优惠券）分页
     * @throws Exception
     */
    @Test
    public void testGuessYouLikeCoupon() throws Exception
    {
        Map<String, List<String>> result = new HashMap<String, List<String>>();

        List<String> list = new ArrayList<String>();
        list.add("cc");
        result.put("1", list);

        for (int i = 0; i < 3; i++)
        {
            if (result.get("1") == null)
            {
                List<String> list3 = new ArrayList<String>();
                list3.add("aa");
                result.put("1", list3);
            }
            else
            {
                List<String> list2 = result.get("1");
                list2.add("bb");
                result.put("1", list2);
            }
        }
        System.out.println(result);
    }

    /**
     * 猜你喜欢（商品）分页
     * @throws Exception
     */
    @Test
    public void testGuessYouLikeGoods() throws Exception
    {
        List<GuessYouLikeGoods> list = this.guessYouLikeQueryService.guessYouLikeGoods("01822N0IJLPA8N700C5V4PBJ43P1R5JO", 0, 5);
        for (GuessYouLikeGoods goods : list)
        {
            System.out.println(goods.getGoodsId() + " : " + goods.getGoodsName());
        }

    }

}
