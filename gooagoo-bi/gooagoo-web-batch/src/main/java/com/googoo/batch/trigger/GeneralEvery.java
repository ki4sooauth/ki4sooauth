package com.googoo.batch.trigger;

import org.springframework.stereotype.Service;

import com.gooagoo.intelligence.transferBox.TransferBox;
import com.googoo.batch.constants.BatchTimeCnstants;

@Service("GeneralEvery")
public class GeneralEvery
{
    public void minutes()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.everyMinutes);
        transferBox.close();
    }

    public void tenminutes()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.everyTenMinutes);
        transferBox.close();
    }

    public void halfhour()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.everyHalfhour);
        transferBox.close();
    }

    public void hour()
    {
        TransferBox transferBox = new TransferBox();
        transferBox.send(BatchTimeCnstants.everyHour);
        transferBox.close();
    }
}
