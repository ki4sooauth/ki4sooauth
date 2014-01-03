package com.gooagoo.crm;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class ImageFileUpLoad
{
    @Test
    public void fileUpLoad()
    {

    }

    private static ArrayList filelist = new ArrayList();

    public static void main(String[] args)
    {
        refreshFilelist("d:\\xhsd\\data\\0000000000");
    }

    private static void refreshFilelist(String strPath)
    {
        // TODO Auto-generated method stub
        File dirFile = new File(strPath); //创建指定路径的文件
        File[] files = dirFile.listFiles(); //列出指定路径下所有的文件存放在files数组中
        if (files == null)
        {
            return;
        }
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isDirectory())
            {
                refreshFilelist(files[i].getAbsolutePath()); //是的话，递归继续查询下级目录
            }
            else
            {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                System.out.println(strFileName); //否则输出文件全路径
            }
            filelist.add(files[i].getAbsolutePath());//将便利出来的文件路径添加入list集合中
        }
    }
}
