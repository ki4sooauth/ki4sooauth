package com.gooagoo.behave.gus.action;

import com.gooagoo.common.jms.AbstractMQMessageListener;

public class GusMessageListener extends AbstractMQMessageListener<String>
{
    private int count = 0;
    private long start = System.currentTimeMillis();

    @Override
    public void process(String behaveLog)
    {
        try
        {
            Count.add();
            this.count++;
            if (this.count % 10000 == 0)
            {
                System.out.println(this.count + "==" + (System.currentTimeMillis() - this.start));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
