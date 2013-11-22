package com.googoo.batch.dispatcher.historyDat;

import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.TransferBox;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.googoo.batch.constants.BatchTimeCnstants;

@Engine(BatchTimeCnstants.integralPoint)
public class Centre implements Tyre
{
    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Centre");
        try
        {
            TransferBox toMongo = new TransferBox();
            toMongo.send(BatchTimeCnstants.redis2mongo);
            toMongo.close();
            toMongo.await();

            TransferBox makefile = new TransferBox();
            makefile.send(BatchTimeCnstants.makefile);
            makefile.close();
            makefile.await();

            TransferBox delRedis = new TransferBox();
            delRedis.send(BatchTimeCnstants.del4redis);
            delRedis.close();
            delRedis.await();
        }
        catch (Exception e)
        {
            GooagooLog.error("", e);
        }
    }
}
