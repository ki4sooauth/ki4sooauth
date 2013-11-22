package com.gooagoo.view.gus.web.bill;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UBillManual implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String time = null;//时间

    private final List<UBillManualDetails> manumalBillDetails = new ArrayList<UBillManualDetails>();

    public String getTime()
    {
        return this.time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public List<UBillManualDetails> getManumalBillDetails()
    {
        return this.manumalBillDetails;
    }

    public boolean compareDate(Date requestTime)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strThisTime = format.format(this.time);
        String strRrequestTime = format.format(requestTime);
        if (strThisTime.equals(strRrequestTime))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
