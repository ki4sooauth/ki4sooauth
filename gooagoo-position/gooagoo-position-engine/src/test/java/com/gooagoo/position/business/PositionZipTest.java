package com.gooagoo.position.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.entity.position.Position;

public class PositionZipTest
{
    public static void main(String[] args) throws Exception
    {
        testBehavior();
    }

    public static void testPosition() throws IOException
    {
        List<Position> positions = new ArrayList<Position>();
        for (int i = 0; i < 10000; i++)
        {
            positions.add(new Position("08:00:27:00:60:9c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("02:03:2f:f5:40:93", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("01:00:27:0f:60:9c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("08:00:2f:00:60:9c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("03:03:4e:04:10:5c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("04:40:4c:50:20:4c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("05:00:98:06:30:3c", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("03:03:4e:04:60:2e", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("04:40:4c:50:40:1d", Math.random() + "", Math.random() + "", UUID.getUUID()));
            positions.add(new Position("05:00:98:06:50:9b", Math.random() + "", Math.random() + "", UUID.getUUID()));
        }
        String o = PositionZip.fromPosition(positions);
        System.out.println(PositionZip.isTypePosition(o));
        List<Position> pos = PositionZip.toPosition(o);
        for (Position position : pos)
        {
            System.out.print(" mac:" + position.getMacAddress());
            System.out.print(" x:" + position.getX());
            System.out.print(" y:" + position.getY());
            System.out.print(" mapId:" + position.getMapId());
            System.out.println();
        }
    }

    public static void testBehavior() throws IOException
    {
        List<Behavior> behaviors = new ArrayList<Behavior>();
        //behaviors.add(new Behavior("05:00:98:06:50:9b", "B", "00000000000000000000000000000000", "11111111111111111111111111111111", "22222222222222222222222222222222"));
        String b = PositionZip.fromBehavior(behaviors);
        System.out.println(PositionZip.isTypeBehavior(b));
        List<Behavior> behaviors2 = PositionZip.toBehavior(b);
        for (Behavior behavior : behaviors2)
        {
            System.out.print(" mac:" + behavior.getMacAddress());
            System.out.print(" behaviour:" + behavior.getBehaviour());
            System.out.print(" positionId:" + behavior.getPositionId());
            System.out.print(" shopId:" + behavior.getShopId());
            System.out.print(" entityId:" + behavior.getEntityId());
            System.out.println();
        }
    }
}
