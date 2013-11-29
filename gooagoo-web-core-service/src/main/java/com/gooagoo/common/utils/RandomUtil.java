package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil
{

    public static List randomList(List list, int count)
    {
        if (list.size() <= count)
        {
            return list;
        }

        List tarlist = new ArrayList(list);
        List rslist = new ArrayList();

        for (int i = 0; i < count; i++)
        {
            int randomNum = (int) (Math.random() * tarlist.size());
            rslist.add(tarlist.get(randomNum));
            tarlist.remove(randomNum);
        }

        return rslist;
    }
}
