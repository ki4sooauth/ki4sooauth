package com.gooagoo.batch.utils;

import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.log.GooagooLog;

public class JobEntryUtils
{

    public static String jobDetailEntry(String jobName, String instanceName, String methodName, String cronExpression)
    {
        try
        {
            DesUtils desUtils = new DesUtils("gooagoo_batch");
            return desUtils.encrypt(jobName + "^" + instanceName + "^" + methodName + "^" + cronExpression);
        }
        catch (Exception e)
        {
            GooagooLog.error("加密异常", e);
            return null;
        }
    }
}
