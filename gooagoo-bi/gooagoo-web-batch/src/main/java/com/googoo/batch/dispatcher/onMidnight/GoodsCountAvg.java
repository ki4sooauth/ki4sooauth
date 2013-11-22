package com.googoo.batch.dispatcher.onMidnight;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.redis.data.RedisHashDao;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.Timestamp;

@Engine(BatchTimeCnstants.onMidnight)
public class GoodsCountAvg implements Tyre
{
    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 GoodsCountAvg");
        //计算某个商品的平均分
        //查询今天的评分记录，计算平均值，与以往的值再求平均
        UserCommentExample userComment = new UserCommentExample();
        Date lastTime = Timestamp.lastTime(Timestamp.GOODS_AVG);
        userComment.createCriteria().andCreateTimeGreaterThan(lastTime);
        List<UserComment> list = this.userCommentGeneratorQueryService.selectByExample(userComment);

        RedisHashDao redisDao = new RedisHashDao(RedisServerConstants.business_goods);

        //result中key为商品ID，value为跑批的评分list
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        for (int i = 0, size = list.size(); i < size; i++)
        {
            String goodsId = list.get(i).getGoodsId();
            if (result.get(goodsId) == null)
            {
                result.put(goodsId, new ArrayList<Integer>());
            }
            result.get(goodsId).add(list.get(i).getCommentLevel());
        }

        //计算商品平均分
        for (Map.Entry<String, List<Integer>> entry : result.entrySet())
        {
            List<Integer> levels = entry.getValue();
            double sum = 0;
            for (Integer i : levels)
            {
                sum += i;
            }
            Map<String, String> goods = redisDao.get(entry.getKey());
            String oldAvgS = goods.get("goodsavg");
            Double oldAvg = new Double(oldAvgS);
            sum = sum + oldAvg;
            double avg = sum / (levels.size() + 1);
            goods.put(entry.getKey(), avg + "");
        }
    }
}
