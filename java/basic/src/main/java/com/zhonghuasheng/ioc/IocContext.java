package com.zhonghuasheng.ioc;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.zhonghuasheng.ioc.annotation.MyComponent;

public class IocContext {

    public static final Map<Class<?>, Object> APPLICATIONCONTEXT_MAP = new ConcurrentHashMap<Class<?>, Object>();

    static {
        String packagenameString = "com.zhonghuasheng.ioc";

        try {
            initBean(packagenameString);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void initBean(String packagenameString) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取路径
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagenameString.replace(".", "/"));

        while (urls.hasMoreElements()) {
            addClassByAnnotation(urls.nextElement().getPath(), packagenameString);
        }

        IocUtil.inject();
    }

    private static void addClassByAnnotation(String filePath, String packagename) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取文件和文件夹
        File[] files = getClassFile(filePath);
        if (files != null && files.length > 0) {
            for (File file : files) {
                String fileName = file.getName();
                if (file.isFile()) {
                    Class<?> clazz = Class.forName(packagename + "." + fileName.substring(0, fileName.lastIndexOf(".")));
                    if (clazz.isAnnotationPresent(MyComponent.class)) {
                        APPLICATIONCONTEXT_MAP.put(clazz, clazz.newInstance());
                    }
                } else {
                    addClassByAnnotation(file.getPath(), packagename + "." + fileName);
                }
            }
        }
        
    }

    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
            }
        });
    }
}
