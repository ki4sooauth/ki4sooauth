package com.gooagoo.current.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.api.business.query.shop.cache.ShopPositionCacheQueryService;
import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.bi.entity.position.BehaviorLeaveShop;
import com.gooagoo.bi.entity.position.Leave;
import com.gooagoo.common.jms.AbstractMQMessageListener;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.current.comple.ApplyMember_Type4;
import com.gooagoo.current.comple.ApplyPhysics_Type5;
import com.gooagoo.current.comple.Attention_Type3;
import com.gooagoo.current.comple.BillServer;
import com.gooagoo.current.comple.Browse_Type9;
import com.gooagoo.current.comple.Checkout_TypeE;
import com.gooagoo.current.comple.Comment_Type6;
import com.gooagoo.current.comple.Exchange_TypeC;
import com.gooagoo.current.comple.Favorite_Type8;
import com.gooagoo.current.comple.Message_Type7;
import com.gooagoo.current.comple.Order_TypeD;
import com.gooagoo.current.comple.Server_TypeA;
import com.gooagoo.current.comple.Share_TypeB;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.LogUtil;
import com.gooagoo.current.tools.PositionZip;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Dispatcher;
import com.gooagoo.intelligence.utils.MQUtil;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.gooagoo.redis.data.RedisStringDao;

/**
 * 实时统计监听
 * @author Administrator
 */
public class ObjMessageListener extends AbstractMQMessageListener<Object>
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void process(Object obj)
    {
        GooagooLog.debug(JsonUtils.toJson(obj));

        MessageLog messageLog = new MessageLog();
        LogUtil logUtil = new LogUtil();
        GooagooMessage message = (GooagooMessage) obj;
        logUtil.setLog(message, messageLog);

        Object content = message.getContent();
        if (content instanceof BehaveLog)
        {
            this.behavelog(message);
        }
        else if (content instanceof ShopLog)
        {
            this.shopLog(message);
        }
        else if (content instanceof String)//位置引擎
        {
            this.position(message);
        }
        else
        {
            GooagooLog.debug("消息来源无法识别，分发失败");
        }
        logUtil.sendLog(messageLog);
    }

    private void shopLog(GooagooMessage<ShopLog> message)
    {
        ShopLog shopLog = message.getContent();
        Dispatcher dispatcher = new Dispatcher();
        try
        {
            if ("Y".equals(shopLog.getOperateResult()))
            {
                if ("gtsc05".equals(shopLog.getRemoteCode()))
                {
                    BillServer billServer = new BillServer(shopLog.getObjectCode(), "M");
                    dispatcher.send(DispatcherConstants.bill, billServer.assemblyBill()); //帐单
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("商家日志", e);
        }
        finally
        {
            dispatcher.close();
        }
    }

    /**
     * 用户行为
     * @param behaveLog
     */
    private void behavelog(GooagooMessage<BehaveLog> message)
    {
        Dispatcher dispatcher = new Dispatcher();
        try
        {
            BehaveLog behaveLog = message.getContent();
            if ("Y".equals(behaveLog.getOperateResult()))
            {
                char type = behaveLog.getBehaveType().charAt(0); //类型只有一个字符
                switch (type)
                {//优惠凭证兑换通过接口编码确定
                    case '0':
                        //这种行为没有了,帐单以shopLog的形式发过来
                        break;
                    case '3':
                        Attention_Type3.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.attention, behaveLog); //关注
                        break;
                    case '4':
                        ApplyMember_Type4.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.applyMember, behaveLog); //申请会员卡
                        break;
                    case '5':
                        ApplyPhysics_Type5.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.applyPhysics, behaveLog); //申请物理卡转换
                        break;
                    case '6':
                        Comment_Type6.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.comment, behaveLog); //评论
                        break;
                    case '7':
                        Message_Type7.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.message, behaveLog); //留言
                        break;
                    case '8':
                        Favorite_Type8.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.favorite, behaveLog); //收藏
                        break;
                    case '9':
                        Browse_Type9.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.browse, behaveLog); //浏览
                        break;
                    case 'A':
                        Server_TypeA.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.server, behaveLog); //使用服务
                        break;
                    case 'B':
                        Share_TypeB.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.share, behaveLog); //分享
                        break;
                    case 'C':
                        Exchange_TypeC.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.exchange, behaveLog); //兑换
                        break;
                    case 'D':
                        Order_TypeD.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.order, behaveLog); //下订单
                        break;
                    case 'E':
                        Checkout_TypeE.complemented(behaveLog);
                        dispatcher.send(DispatcherConstants.checkout, behaveLog); //申请结账
                        break;
                    default:
                        dispatcher.send(DispatcherConstants.other, behaveLog); //其他
                        break;
                }
            }
            else
            {
                GooagooLog.debug("OperateResult 不为Y");
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("用户行为", e);
        }
        finally
        {
            dispatcher.close();
            dispatcher.await();
            this.sendToMarketing(message);
        }
    }

    /**
     * 用户定位
     * @param position
     * @throws Exception 
     */
    private void position(GooagooMessage<String> message)
    {
        Dispatcher dispatcher = new Dispatcher();
        try
        {
            String strBehav = message.getContent();
            if (PositionZip.isTypeBehavior(strBehav))
            {
                RedisStringDao uid = new RedisStringDao(RedisServerConstants.business_mac);
                List<Behavior> behaviors = PositionZip.toBehavior(strBehav);
                for (Behavior behavior : behaviors)
                {
                    String userId = uid.get(behavior.getMacAddress());

                    char type = behavior.getBehaviour().charAt(0);
                    switch (type)
                    {
                        case '1': //到店
                            BehaviorGeneral arrive = this.general(behavior, userId);
                            dispatcher.send(DispatcherConstants.store, arrive);
                            break;
                        case '2'://到区域
                            BehaviorAreaChange behaviorAreaChange = this.areaChange(behavior, userId);
                            dispatcher.send(DispatcherConstants.area, behaviorAreaChange);
                            break;
                        case 'F'://离开店铺
                            BehaviorLeaveShop leave = this.leave(behavior, userId);
                            dispatcher.send(DispatcherConstants.leave, leave);
                            break;
                        case 'G'://路过店铺
                            BehaviorGeneral pass = this.general(behavior, userId);
                            dispatcher.send(DispatcherConstants.pass, pass);
                            break;
                        default:
                            GooagooLog.info("行为类型无法识别:" + behavior.getBehaviour());
                            break;
                    }
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("行为分析", e);
        }
        finally
        {
            dispatcher.close();
            dispatcher.await();
            this.sendToMarketing(message);
        }

    }

    private void sendToMarketing(GooagooMessage<?> message)
    {
        MQUtil mqutil = new MQUtil("marketing");
        mqutil.sendObjectMessage(message);
        mqutil.close();
    }

    private BehaviorGeneral general(Behavior behavior, String userId) throws Exception
    {
        BehaviorGeneral general = new BehaviorGeneral();
        String shopId = this.getShopId(behavior.getPositionId());
        general.setUserId(userId);
        general.setShopId(shopId);
        general.setMember(UserTools.isMember(userId, shopId));
        general.setMacAddress(behavior.getMacAddress());
        general.setEntityId(behavior.getEntityId());
        general.setBehaviour(behavior.getBehaviour());
        return general;
    }

    private BehaviorLeaveShop leave(Behavior behavior, String userId) throws Exception
    {

        BehaviorLeaveShop leave = new BehaviorLeaveShop();
        String shopId = this.getShopId(behavior.getPositionId());
        leave.setUserId(userId);
        leave.setShopId(shopId);
        leave.setMember(UserTools.isMember(userId, shopId));
        leave.setMacAddress(behavior.getMacAddress());
        leave.setEntityId(behavior.getEntityId());
        leave.setBehaviour(behavior.getBehaviour());

        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        Set<String> old = sortedSetDao.get(behavior.getMacAddress(), 0, -1); //已经保存的区域id

        long timeMillis = System.currentTimeMillis();
        for (String string : old)
        {
            double start = sortedSetDao.getScore(behavior.getMacAddress(), string);
            Leave leaveShopArea = new Leave();
            leaveShopArea.setId(string);
            leaveShopArea.setStart((long) start);
            leaveShopArea.setEnd(timeMillis);
            leaveShopArea.setDuration((timeMillis - (long) start) / 60000);
            leave.getLastArea().add(leaveShopArea);
        }
        return leave;
    }

    private BehaviorAreaChange areaChange(Behavior behavior, String userId) throws Exception
    {
        BehaviorAreaChange change = new BehaviorAreaChange();
        String shopId = this.getShopId(behavior.getPositionId());
        change.setUserId(userId);
        change.setShopId(shopId);
        change.setMember(UserTools.isMember(userId, shopId));
        change.setMacAddress(behavior.getMacAddress());
        change.setEntityId(behavior.getEntityId());
        change.setBehaviour(behavior.getBehaviour());

        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        Set<String> positions = this.cascadePosition(behavior.getPositionId());//所在区域id
        Set<String> old = sortedSetDao.get(behavior.getMacAddress(), 0, -1); //已经保存的区域id

        Set<String> newArea = new HashSet<String>();
        newArea.addAll(positions);
        newArea.removeAll(old); //本次新进入的区域
        change.setNewArea(newArea);
        Set<String> leaveArea = new HashSet<String>();
        leaveArea.addAll(old);
        leaveArea.removeAll(positions); //求出离开的区域

        long timeMillis = System.currentTimeMillis();
        for (String string : leaveArea)
        {
            double start = sortedSetDao.getScore(behavior.getMacAddress(), string);
            Leave leaveShopArea = new Leave();
            leaveShopArea.setId(string);
            leaveShopArea.setStart((long) start);
            leaveShopArea.setEnd(timeMillis);
            leaveShopArea.setDuration((timeMillis - (long) start) / 60000);
            change.getOldArea().add(leaveShopArea);
        }
        return change;
    }

    private String getShopId(String positionId) throws Exception
    {
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_position);
        List<String> map = hashDao.get(positionId, "shopId");
        if (map == null)
        {
            ShopPositionCacheQueryService service = SpringBeanUtils.getBean(ShopPositionCacheQueryService.class);
            Map<String, String> mapDataBase = service.findPosition(positionId);
            return mapDataBase.get("shopId");
        }
        else
        {
            return map.get(0);
        }
    }

    /**
     * 取得区域id及所有的父区域id
     * @param positionId
     * @return
     */
    private Set<String> cascadePosition(String positionId)
    {
        Set<String> positions = new HashSet<String>();
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_position);
        String parent = positionId;
        while (true)
        {
            positions.add(parent);
            parent = hashDao.getMapElement(parent, "parentId");
            if (parent == null || "-1".equals(parent))
            {
                break;
            }
        }
        return positions;
    }
}
