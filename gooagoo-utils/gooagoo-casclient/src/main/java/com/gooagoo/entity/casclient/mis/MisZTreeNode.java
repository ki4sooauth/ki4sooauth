package com.gooagoo.entity.casclient.mis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MisZTreeNode implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//节点编码

    private String pId;//父节点编码

    private String name;//节点名称

    private Boolean checked;//是否被选中

    private Boolean isParent;//是不是父节点

    private Boolean isHidden;//是否隐藏

    private Boolean open;//是否展开

    private String target;//等同a标签中的target

    private String url;//链接地址

    private String click;//点击事件

    private String note;//备注

    private Boolean chkDisabled;//选择框是否禁用

    private Boolean halfCheck;//是否被半选中

    private Boolean noCheck;//是否不显示选择框

    private String icon;//展开和折叠时图标路径

    private String iconClose;//折叠时图标路径

    private String iconOpen;//展开时图标路径

    private String iconSkin;//展开和折叠时图标样式名称

    private List<MisZTreeNode> children = new ArrayList<MisZTreeNode>();//子节点

    private String remark1;//备用字段1

    private String remark2;//备用字段1

    private String remark3;//备用字段1

    private String remark4;//备用字段1

    private String remark5;//备用字段1

    public MisZTreeNode()
    {
        super();
    }

    public MisZTreeNode(String id, String pId, String name, boolean checked)
    {
        this.setId(id);
        this.setpId(pId);
        this.setName(name);
        this.setChecked(checked);
    }

    public MisZTreeNode(String id, String pId, String name, String click)
    {
        this.setId(id);
        this.setpId(pId);
        this.setName(name);
        this.setClick(click);
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getpId()
    {
        return this.pId;
    }

    public void setpId(String pId)
    {
        this.pId = pId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getChecked()
    {
        return this.checked;
    }

    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }

    public Boolean getIsParent()
    {
        return this.isParent;
    }

    public void setIsParent(Boolean isParent)
    {
        this.isParent = isParent;
    }

    public Boolean getIsHidden()
    {
        return this.isHidden;
    }

    public void setIsHidden(Boolean isHidden)
    {
        this.isHidden = isHidden;
    }

    public Boolean getOpen()
    {
        return this.open;
    }

    public void setOpen(Boolean open)
    {
        this.open = open;
    }

    public String getTarget()
    {
        return this.target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getClick()
    {
        return this.click;
    }

    public void setClick(String click)
    {
        this.click = click;
    }

    public String getNote()
    {

        return this.note;
    }

    public void setNote(String note)
    {

        this.note = note;
    }

    public Boolean getChkDisabled()
    {
        return this.chkDisabled;
    }

    public void setChkDisabled(Boolean chkDisabled)
    {
        this.chkDisabled = chkDisabled;
    }

    public Boolean getHalfCheck()
    {
        return this.halfCheck;
    }

    public void setHalfCheck(Boolean halfCheck)
    {
        this.halfCheck = halfCheck;
    }

    public Boolean getNoCheck()
    {
        return this.noCheck;
    }

    public void setNoCheck(Boolean noCheck)
    {
        this.noCheck = noCheck;
    }

    public String getIcon()
    {
        return this.icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getIconClose()
    {
        return this.iconClose;
    }

    public void setIconClose(String iconClose)
    {
        this.iconClose = iconClose;
    }

    public String getIconOpen()
    {
        return this.iconOpen;
    }

    public void setIconOpen(String iconOpen)
    {
        this.iconOpen = iconOpen;
    }

    public String getIconSkin()
    {
        return this.iconSkin;
    }

    public void setIconSkin(String iconSkin)
    {
        this.iconSkin = iconSkin;
    }

    public List<MisZTreeNode> getChildren()
    {
        return this.children;
    }

    public void setChildren(List<MisZTreeNode> children)
    {
        this.children = children;
    }

    public void addChildren(MisZTreeNode zTreeNode)
    {
        if (this.children == null)
        {
            this.children = new ArrayList<MisZTreeNode>();
        }
        this.children.add(zTreeNode);
    }

    public String getRemark1()
    {
        return this.remark1;
    }

    public void setRemark1(String remark1)
    {
        this.remark1 = remark1;
    }

    public String getRemark2()
    {
        return this.remark2;
    }

    public void setRemark2(String remark2)
    {
        this.remark2 = remark2;
    }

    public String getRemark3()
    {
        return this.remark3;
    }

    public void setRemark3(String remark3)
    {
        this.remark3 = remark3;
    }

    public String getRemark4()
    {
        return this.remark4;
    }

    public void setRemark4(String remark4)
    {
        this.remark4 = remark4;
    }

    public String getRemark5()
    {
        return this.remark5;
    }

    public void setRemark5(String remark5)
    {
        this.remark5 = remark5;
    }

}
