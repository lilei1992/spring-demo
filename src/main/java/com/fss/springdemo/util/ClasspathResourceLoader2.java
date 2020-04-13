package com.fss.springdemo.util;

import org.beetl.core.resource.ClasspathResourceLoader;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 21:00
 **/
public class ClasspathResourceLoader2 extends ClasspathResourceLoader {
    public ClasspathResourceLoader2() {
        // TODO Auto-generated constructor stub
    }

    public ClasspathResourceLoader2(ClassLoader classLoader) {
        super(classLoader);
        // TODO Auto-generated constructor stub
    }

    public ClasspathResourceLoader2(String root) {
        super(root);
        // TODO Auto-generated constructor stub
    }

    public ClasspathResourceLoader2(ClassLoader classLoader, String root) {
        super(classLoader, root);
        // TODO Auto-generated constructor stub
    }

    public ClasspathResourceLoader2(String root, String charset) {
        super(root, charset);
        // TODO Auto-generated constructor stub
    }

    public ClasspathResourceLoader2(ClassLoader classLoader, String root, String charset) {
        super(classLoader, root, charset);
        // TODO Auto-generated constructor stub
    }

    protected String getChildPath(String path,String child){
        path = super.getChildPath(path, child);
        System.out.println("路径是 ---> " + path);
        return path;
    }
}
