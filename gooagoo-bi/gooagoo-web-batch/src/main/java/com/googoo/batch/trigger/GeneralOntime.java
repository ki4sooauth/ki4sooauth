package com.googoo.batch.trigger;

import org.springframework.stereotype.Service;

import com.gooagoo.intelligence.transferBox.TransferBox;
import com.googoo.batch.constants.BatchTimeCnstants;

@Service("GeneralOntime")
public class GeneralOntime
{
    public void midnight()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.onMidnight);
        transferBox.close();
    }

    public void monday()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.onMonday);
        transferBox.close();
    }

    public void integralPoint()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.integralPoint);
        transferBox.close();
    }
}
