package com.gooagoo.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFile
{

    public static void main(String[] args)
    {
        try
        {
            List<String> list = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader("g:/1.txt"));
            String temp = "";
            while ((temp = reader.readLine()) != null)
            {
                if (temp.indexOf("statistics/") > 0)
                {
                    list.add(temp.substring(temp.indexOf("statistics/")));
                }
            }
            System.out.println(list.size());
            Collections.sort(list);
            for (String string : list)
            {
                cc("g:/" + string);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void cc(String path)
    {
        try
        {
            FileOutputStream out = new FileOutputStream(path);
            out.write(1);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
