package com.gooagoo.view.gms.map;

/**
 * svg path 标签的 每个画线指令 对象
 *
 */
public class PathPosition extends SvgPoint
{
    private static final long serialVersionUID = 1L;
    private String instruction;
    private String numString;

    public String getInstruction()
    {
        return this.instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public String getNumString()
    {
        return this.numString;
    }

    public void setNumString(String numString)
    {
        this.numString = numString;
    }

    @Override
    public String toString()
    {
        return this.instruction + " " + this.numString;
    }
}
