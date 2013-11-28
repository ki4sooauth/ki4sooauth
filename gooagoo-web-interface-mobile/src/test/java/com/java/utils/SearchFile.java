package com.java.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchFile
{

    //获取某路径下得所有文件夹路径名
    public List<String> findDirectory(String searchPath)
    {
        // List<String> resultList = new ArrayList<String>();

        File baseDir = new File(searchPath);
        if (!baseDir.exists() || !baseDir.isDirectory())
        { // 判断目录是否存在
            System.out.println("文件查找失败：" + baseDir + "不是一个目录！\n");
        }
        File tempFile = null;

        tempFile = baseDir;// 将列表中的第一个元素取出并删除
        List<String> directoryPaths = new ArrayList<String>();
        if (tempFile.exists() && tempFile.isDirectory())
        {
            File[] files = tempFile.listFiles();
            for (int i = 0; i < files.length; i++)
            {
                if (files[i].exists() && files[i].isDirectory())
                {
                    directoryPaths.add(files[i].getPath());
                    System.out.println("文件夹名称为:" + files[i].getName());
                    System.out.println("文件夹名路径为:" + files[i].getPath());
                }
            }
        }
        return directoryPaths;
    }

    /**
     * 查找符合条件的文件，并返回一个文件名列表
     * @param searchPath 搜索路径
     * @param kindOfFile 搜索文件类型
     * @param containFileName 搜索文件包含的名称
     * @param notContainFileName 搜索文件不包含的名称
     * @return
     */
    public List<String> findFiles(String searchPath, String kindOfFile, String containFileName, String notContainFileName)
    {
        // List<String> resultList = new ArrayList<String>();
        LinkedList<File> fileList = new LinkedList<File>(); // 创建一个连接列表fileList

        File baseDir = new File(searchPath);
        if (!baseDir.exists() || !baseDir.isDirectory())
        { // 判断目录是否存在
            System.out.println("文件查找失败：" + baseDir + "不是一个目录！\n");
        }
        String tempName = null;
        fileList.addLast(baseDir);// 将File对象添加到fileList列表中
        String packageName = null;
        File tempFile = null;
        List<String> resultStrs = new ArrayList<String>();
        tempFile = baseDir;// 将列表中的第一个元素取出并删除
        if (tempFile.exists() && tempFile.isDirectory())
        {
            File[] files = tempFile.listFiles();

            for (int i = 0; i < files.length; i++)
            {
                packageName = files[i].getPath();//文件路径

                tempName = files[i].getName();//文件名

                //过滤"。svn"文件夹
                if (".svn".equals(tempName))
                {
                    continue;
                }
                else if (!tempName.contains(containFileName))
                {
                    continue;
                }
                else if (tempName.contains(notContainFileName))
                {
                    continue;
                }
                //                System.out.println("搜索路径" + packageName);
                if (!files[i].isDirectory())
                {
                    // 如果是文件则根据文件名与目标文件名进行匹配
                    //tempName = files[i].getName();

                    if (MatchWord.matchWord(kindOfFile, tempName))
                    {
                        System.out.println("当前搜索到的文件为" + packageName + "\n");
                        resultStrs.add(packageName);
                    }
                }
                else
                {
                    this.findFiles(packageName, kindOfFile, containFileName, notContainFileName);
                }
            }
        }
        return resultStrs;
    }
}
