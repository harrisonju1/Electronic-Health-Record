package com.ex.util;

import com.ex.controllers.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapper {

    private static Map<String, String> mapping = new HashMap<>();

    public static void init(String configPath) {
        try {
            configPath = FrontController.class.getClassLoader().getResource("/"+configPath).getFile().substring(1);
            System.out.println("Loading config:"+configPath);
            Properties prop = new Properties();
            mapping = new HashMap<>();
            prop.load(new FileReader(configPath));
            Set<String> props = prop.stringPropertyNames();
            for (String p:props) {
                mapping.put(p, prop.getProperty(p));
                System.out.println("mapping: "+p+" = "+prop.getProperty(p));
            }
            System.out.println(""+mapping.size()+" mappings added!");
        } catch (IOException e) {
            System.out.println("Cannot find map file "+configPath);
            e.printStackTrace();
        }
    }

    public static boolean handle(String path, HttpServletRequest req, HttpServletResponse resp) {
        String classAndMethod = mapping.get(path);
        if (classAndMethod==null)
            return false;
        System.out.println("Found mapping:"+classAndMethod+"");
        String[] split = classAndMethod.split("\\.");
        if (split.length<2)
            return false;
        String className = "com.ex.controllers." + split[0];
        String methodName = split[1];
        Class c;
        Method m;
        try {
            c = Class.forName(className);
            if (c==null) {
                System.out.println("Class " + className + " not found!");
                return false;
            }
            m = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            if (m==null) {
                System.out.println("Method "+methodName+" not found!");
                return false;
            }
            Object inst = c.newInstance();
            m.invoke(inst, req, resp);
            System.out.println(methodName + " request received.");
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }
}
