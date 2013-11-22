package com.gooagoo.position.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.util.StringUtils;

import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.entity.position.Position;
import com.gooagoo.position.business.AreaCache;
import com.gooagoo.position.business.Buffer;
import com.gooagoo.position.business.PositionZip;
import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.constants.DeviceType;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.position.entity.MacPosition;
import com.gooagoo.position.entity.PositionCache;
import com.gooagoo.position.log.PositionEngineLog;
import com.gooagoo.position.rule.DurationRule;
import com.gooagoo.position.utils.CoordinateTransformationUtil;
import com.gooagoo.position.utils.SendMessageUtil;
import com.gooagoo.redis.data.RedisStringDao;

public class PositionTask extends TimerTask
{
    private ConcurrentLinkedQueue<Behavior> behaviorQueue = null;
    private SendMessageUtil smu = new SendMessageUtil();

    private RedisStringDao guide = new RedisStringDao(RedisConstants.business_guide);

    public PositionTask(ConcurrentLinkedQueue<Behavior> queue)
    {
        this.behaviorQueue = queue;
    }

    @Override
    public void run()
    {
        List<MacPosition> macPositions = Buffer.get();
        List<Position> positions = new ArrayList<Position>(macPositions.size());
        List<PositionCache> positionCaches = new ArrayList<PositionCache>(macPositions.size());
        for (MacPosition macPosition : macPositions)
        {
            Position position = new Position();
            PositionCache positionCache = new PositionCache();
            this.region(macPosition, position, positionCache);
            //定位只取声波设备数据，并且只发送打开导引的用户数据
            if (macPosition.getType() == DeviceType.SOUND && this.checkGuide(macPosition.getMac()))
            {
                positions.add(position);
            }
            positionCaches.add(positionCache);
            DurationRule.matching(positionCache.getMac(), positionCache.getShopId());
        }
        this.sendMessage(positions);
        this.analysisBehavior(positionCaches);
    }

    /**
     * 是否打开导引
     * @param mac
     * @return 手机端打开导引 true
     */
    private boolean checkGuide(String mac)
    {
        String status = this.guide.get(mac);
        if ("I".equals(status))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 计算区域
     * @param macPosition
     * @param position
     */
    private void region(MacPosition macPosition, Position position, PositionCache positionCache)
    {
        String mapId = AreaCache.getMapId(macPosition.getDevice(), macPosition.getType());
        if (!StringUtils.hasText(mapId))
        {
            PositionEngineLog.error("[" + this.getClass().getSimpleName() + "]mapId is null.......", new NullPointerException("mapId is null"));
            return;
        }
        PositionEngineLog.debug("[" + this.getClass().getSimpleName() + "]Map ID:" + mapId);
        Map<String, String> map = AreaCache.mapInfo(mapId);

        double ratioLocation = Double.parseDouble(map.get("ratioLocation"));
        double ratioGrid = Double.parseDouble(map.get("ratioGrid"));
        double ratioSvg = Double.parseDouble(map.get("ratioSvg"));
        //double mapRealWidth = Double.parseDouble(map.get("mapRealWidth"));
        double mapRealHeight = Double.parseDouble(map.get("mapRealHeight"));

        long svgx = CoordinateTransformationUtil.realToSvgX(macPosition.getX(), ratioLocation, ratioSvg);
        long svgy = CoordinateTransformationUtil.realToSvgY(macPosition.getY(), mapRealHeight, ratioLocation, ratioSvg);

        PositionEngineLog.debug("[" + this.getClass().getSimpleName() + "]SVG point x:" + svgx + "    y:" + svgy);

        position.setX(Long.toString(svgx));//svg图上的x座标
        position.setY(Long.toString(svgy));//svg图上的y座标
        position.setMacAddress(macPosition.getMac());
        position.setMapId(mapId);

        int gridx = CoordinateTransformationUtil.realToGridX(macPosition.getX(), ratioLocation, ratioGrid);
        int gridy = CoordinateTransformationUtil.realToGridY(macPosition.getY(), mapRealHeight, ratioLocation, ratioGrid);
        PositionEngineLog.debug("[" + this.getClass().getSimpleName() + "]grid point x:" + gridx + "    y:" + gridy);
        Map<String, String> area = AreaCache.gridCoordinateInfo(mapId, gridx, gridy);
        PositionEngineLog.debug("[" + this.getClass().getSimpleName() + "]area:" + area);
        if (area != null && area.keySet().size() > 0)
        {
            positionCache.setPositionId(area.get("positionId"));
            positionCache.setGridAttribute(area.get("gridAttribute").charAt(0));
        }
        positionCache.setEntityId(map.get("shopEntityId"));
        positionCache.setShopId(map.get("shopId"));
        positionCache.setMac(macPosition.getMac());
    }

    private void sendMessage(List<Position> positions)
    {
        if (positions != null && positions.size() > 0)
        {
            try
            {
                GooagooMessage<String> message = new GooagooMessage<String>();
                message.setSource("4");
                message.setBehaveCode("001");
                message.setFlag(true);
                message.setContent(PositionZip.fromPosition(positions));

                this.smu.sendObjectMessage(BehaviorConstants.MQ_DESTINATION_POSITION, message);
                PositionEngineLog.debug("Send to " + BehaviorConstants.MQ_DESTINATION_POSITION + " queue message:" + message.getContent().getBytes().length);
            }
            catch (IOException e)
            {
                PositionEngineLog.error("发送定位信息", e);
            }
        }
    }

    private void analysisBehavior(List<PositionCache> positionCaches)
    {
        if (positionCaches != null && positionCaches.size() > 0)
        {
            ExecutorService pool = Executors.newFixedThreadPool(100);
            for (PositionCache obj : positionCaches)
            {
                BehaviorRule br = new BehaviorRule(this.behaviorQueue, obj);
                pool.execute(br);
            }
            pool.shutdown();
        }
    }
}
