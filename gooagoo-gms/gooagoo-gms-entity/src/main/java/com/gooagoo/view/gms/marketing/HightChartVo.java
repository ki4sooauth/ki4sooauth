package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

public class HightChartVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private LineVo lineVo = new LineVo(); //折线图，柱状图数据
    
    private PieVo pieVo = new PieVo();//饼状图数据
    
    public PieVo getPieVo()
    {
        return pieVo;
    }

    public void setPieVo(PieVo pieVo)
    {
        this.pieVo = pieVo;
    }

    public LineVo getLineVo()
    {
        return lineVo;
    }

    public void setLineVo(LineVo lineVo)
    {
        this.lineVo = lineVo;
    }
}
