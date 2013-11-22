package com.gooagoo.position.constants;

import java.util.ResourceBundle;

public class BehaviorConstants
{
    //无行为
    public static final String BEHAVIOR_NULL = "00";
    //到店
    public static final String BEHAVIOR_ARR_SHOP = "1";
    //到区域
    public static final String BEHAVIOR_ARR_AREA = "2";
    //离店
    public static final String BEHAVIOR_LEAVE_SHOP = "3";
    //离开区域
    public static final String BEHAVIOR_LEAVE_AREA = "4";
    //路过
    public static final String BEHAVIOR_GO_PAST_SHOP = "5";

    public static String MQ_DESTINATION_POSITION = "PositionQueue";
    public static String MQ_DESTINATION_BEHAVIOR = "PositionQueue";

    public static final String CACHE_PREFIX_BEHAVIOR = "be_";
    public static final String CACHE_PREFIX_POSITION_LIST = "pos_";

    static
    {
        try
        {
            ResourceBundle bundle = ResourceBundle.getBundle("activeMQ");

            MQ_DESTINATION_POSITION = bundle.getString("MQ_POSITION_QUEUE");
            MQ_DESTINATION_BEHAVIOR = bundle.getString("MQ_BEHAVIOR_QUEUE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
