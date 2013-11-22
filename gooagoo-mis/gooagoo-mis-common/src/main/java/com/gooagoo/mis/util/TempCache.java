package com.gooagoo.mis.util;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.view.mis.common.MFNode;
import com.gooagoo.view.mis.common.MZTreeNode;

public class TempCache
{
    static
    {
        initData();
    }

    public static void initData()
    {
        initRootChannel();
        initPositonTree();
        initChannelTree();
    }

    public static void initRootChannel()
    {
        try
        {
            MFNode a1 = new MFNode();
            a1.setCode("W");
            a1.setName("网站");
            a1.setParentCode("1");
            MFNode a2 = new MFNode();
            a2.setCode("M");
            a2.setName("手机");
            a2.setParentCode("1");
            MFNode a3 = new MFNode();
            a3.setCode("P");
            a3.setName("位置触发");
            a3.setParentCode("1");
            MFNode a4 = new MFNode();
            a4.setCode("S");
            a4.setName("服务触发");
            a4.setParentCode("1");
            List<MFNode> list = new ArrayList<MFNode>();
            list.add(a1);
            list.add(a2);
            list.add(a3);
            list.add(a4);
            //            GMSUtil.setRedisValue(GMSConstant.CHANNEL_ROOT_LIST, list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void initChannelTree()
    {
        try
        {
            List<MZTreeNode> zlist = new ArrayList<MZTreeNode>();
            MZTreeNode n1 = new MZTreeNode();
            n1.setId("W");
            n1.setName("网站");
            n1.setpId("0");
            n1.getChildren().add(new MZTreeNode("101", "W", "网站虚拟店铺", null));
            MZTreeNode n2 = new MZTreeNode();
            n2.setId("M");
            n2.setName("手机");
            n2.getChildren().add(new MZTreeNode("201", "M", "手机虚拟店铺", null));
            n2.setpId("0");
            MZTreeNode n3 = new MZTreeNode();
            n3.setId("P");
            n3.setName("位置触发");
            n3.setpId("0");
            MZTreeNode n4 = new MZTreeNode();
            n4.setId("S");
            n4.setName("服务触发");
            n4.getChildren().add(new MZTreeNode("301", "S", "服务1", null));
            n4.getChildren().add(new MZTreeNode("302", "S", "服务2", null));
            n4.setpId("0");
            zlist.add(n1);
            zlist.add(n2);
            zlist.add(n3);
            zlist.add(n4);

            //            GMSUtil.setRedisValue(GMSConstant.ZTREE_CHANNEL_LIST, zlist);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void initPositonTree()
    {
        try
        {
            List<MZTreeNode> zlist = new ArrayList<MZTreeNode>();
            MZTreeNode n1 = new MZTreeNode();
            n1.setId("W");
            n1.setName("位置1");
            n1.setpId("0");
            n1.getChildren().add(new MZTreeNode("101", "W", "位置11", null));
            MZTreeNode n2 = new MZTreeNode();
            n2.setId("M");
            n2.setName("位置2");
            n2.getChildren().add(new MZTreeNode("201", "M", "位置22", null));
            n2.setpId("0");
            MZTreeNode n3 = new MZTreeNode();
            n3.setId("P");
            n3.setName("位置3");
            n3.setpId("0");
            MZTreeNode n4 = new MZTreeNode();
            n4.setId("S");
            n4.setName("位置4");
            n4.getChildren().add(new MZTreeNode("301", "S", "位置41", null));
            n4.getChildren().add(new MZTreeNode("302", "S", "位置42", null));
            n4.setpId("0");
            zlist.add(n1);
            zlist.add(n2);
            zlist.add(n3);
            zlist.add(n4);

            //            GMSUtil.setRedisValue(GMSConstant.ZTREE_POSITION_LIST, zlist);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
