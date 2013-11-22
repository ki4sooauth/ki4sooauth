package com.gooagoo.position.constants;

import java.util.ResourceBundle;

public class ConfigConstants
{
    public static int POSITION_TASK_FREQUENCY = 1000;
    public static int BEHAVIOR_TASK_FREQUENCY = 1000;
    public static int SCHEDULE_TASK_FREQUENCY = 100;

    public static int MAX_POSITIONS_SIZE = 1000;
    public static int MAX_BEHAVIOR_SIZE = 1000;

    public static int USER_POSITION_CACHE_SIZE = 20;

    static
    {
        try
        {
            ResourceBundle bundle = ResourceBundle.getBundle("config");

            POSITION_TASK_FREQUENCY = Integer.parseInt(bundle.getString("positionTaskFrequency"));
            BEHAVIOR_TASK_FREQUENCY = Integer.parseInt(bundle.getString("behaviorTaskFrequency"));
            SCHEDULE_TASK_FREQUENCY = Integer.parseInt(bundle.getString("scheduleTaskFrequency"));

            MAX_POSITIONS_SIZE = Integer.parseInt(bundle.getString("maxPositionSize"));
            MAX_BEHAVIOR_SIZE = Integer.parseInt(bundle.getString("maxBehaviorSize"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
