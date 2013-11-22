package com.gooagoo.mis.util;

import java.util.Comparator;

import com.gooagoo.view.mis.common.MZTreeNode;

public class TreeNodeComparator implements Comparator<MZTreeNode>
{

    /**
     * 
     */
    @Override
    public int compare(MZTreeNode vo1, MZTreeNode vo2)
    {
        return vo1.getId().compareTo(vo2.getId());
    }

}
