package com.gooagoo.open;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.open.OpenInterfaceParms;
import com.gooagoo.open.service.ParameterService;
import com.gooagoo.open.service.impl.ParameterServiceImpl;
import com.google.gson.Gson;

public class RequestParmsGenerator
{
    private static String classpath = "";
    @Autowired
    private static ParameterService parameterService;

    public static void main(String[] args)
    {
        ParameterService service = new ParameterServiceImpl();
        //获取open下请求参数
        Set<Class<?>> classes = getClasses("com.gooagoo.open.entity.mobile");
        String baseFilePath = classpath.replace("webapp/WEB-INF/classes", "java").substring(1);
        System.out.println("tatal:" + classes.size());
        for (Class<?> classType : classes)
        {
            String filePath = baseFilePath + "/" + classType.getSimpleName() + ".java";
            Map<String, String> desmap = getClassFieldDes(filePath);
            System.out.println(filePath);
            System.out.println(classType.getName());
            Field[] fields = classType.getDeclaredFields();
            for (Field field : fields)
            {
                if (!field.getName().equals("serialVersionUID"))
                {
                    OpenInterfaceParms parms = new OpenInterfaceParms();
                    parms.setInterfaceId(UUID.getUUID());
                    parms.setParameterName(field.getName());
                    parms.setParameterDes(desmap.get(field.getName()));
                    parms.setParameterType(field.getType().getSimpleName());
                    parms.setExample("test");
                    parms.setUpdateDt(Calendar.getInstance().getTime());
                    parms.setIsRequired("1");
                    System.out.println(new Gson().toJson(parms));
                    //System.out.println(field.getName() + "    " + field.getType().getSimpleName());
                    service.addInputParameter(parms);
                }
            }
        }
        System.out.println(classpath);
        System.out.println(baseFilePath);
    }

    /**
     * 从包package中获取所有的Class
     * @param pack
     * @return
     */
    public static Set<Class<?>> getClasses(String pack)
    {
        //排重
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        //递归
        boolean recursive = true;
        //包的目录名
        String packageDirName = pack.replace('.', '/');
        Enumeration<URL> dirs;
        try
        {
            //通过当前线程的类加载器来获取资源
            System.out.println(Thread.currentThread().getContextClassLoader().toString());
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements())
            {
                URL url = dirs.nextElement();
                //协议file
                String protocol = url.getProtocol();
                if ("file".equals(protocol))
                {
                    //url.getFile() 此 URL 的文件名协议后面的部分
                    System.err.println("file类型的扫描");

                    System.err.println("url.getFile():" + url.getFile());
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    classpath = filePath;
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(pack, filePath, recursive, classes);
                }
                else if ("jar".equals(protocol))
                {
                    // 如果是jar包文件
                    System.err.println("jar类型的扫描");
                    JarFile jar;
                    try
                    {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements())
                        {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/')
                            {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName))
                            {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1)
                                {
                                    // 获取包名 把"/"替换成"."
                                    pack = name.substring(0, idx).replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive)
                                {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory())
                                    {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(pack.length() + 1, name.length() - 6);
                                        try
                                        {
                                            // 添加到classes
                                            classes.add(Class.forName(pack + '.' + className));
                                        }
                                        catch (ClassNotFoundException e)
                                        {
                                            // log
                                            // .error("添加用户自定义视图类错误 找不到此类的.class文件");
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    catch (IOException e)
                    {
                        // log.error("在扫描用户定义视图时从jar包获取文件出错");
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return classes;
    }

    /**
     * 以文件的形式来获取包下的所有Class
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes)
    {
        //将给定路径名转换为抽象路径名
        File dir = new File(packagePath);
        System.out.println(dir.toString());
        if (!dir.exists() || !dir.isDirectory())
        {
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录    满足指定过滤器的文件和目录

        //将符合规则存储file[]
        File[] dirfiles = dir.listFiles(new FileFilter()
        {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            @Override
            public boolean accept(File file)
            {
                //是否路径，是否入参
                return (recursive && file.isDirectory()) || (file.getName().contains("Request") && file.getName().endsWith(".class"));
            }
        });
        for (File file : dirfiles)
        {
            System.out.println(packageName + "." + file.getName());
            System.out.println(file.getAbsolutePath());
            // 如果是目录 则继续扫描  除非空目录
            if (file.isDirectory())
            {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            }
            else
            {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try
                {
                    // 添加到集合中去
                    //classes.add(Class.forName(packageName + '.' + className));
                    //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    //线程中的类加载器，直接调用起来效率最高
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
                }
                catch (ClassNotFoundException e)
                {
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");
                    e.printStackTrace();
                }
            }
        }
    }

    public static Map<String, String> getClassFieldDes(String path)
    {
        Map<String, String> map = new HashMap<String, String>();
        try
        {
            File file = new File(path);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = bf.readLine();
            while (line != null)
            {
                if (line.contains("private String"))
                {
                    String str[] = line.replace("private String", "").trim().split(";/{2}");
                    if (str.length == 2)
                    {
                        map.put(str[0], str[1]);
                        System.out.println(str[0] + "," + str[1]);
                    }
                }
                line = bf.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return map;
    }
}
