package com.atguigu.se.classloader;

import com.atguigu.se.classloader.help.LoadPerson;
import org.junit.Test;

import java.net.URL;

/**
 * @author lhh
 * @date 2019/4/9 14:01
 * @Description:
 */
public class ClassLoaderDemo {
    /**
     * 下面程序可以获得根类加载器所加载的核心类库,
     * 并会看到本机安装的Java环境变量指定的jdk中提供的核心jar包路径：
     */
    @Test
    public void bootClassLoaderDemo() {
        LoadPerson loadPerson = new LoadPerson();
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

    @Test
    public void fun2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CompileClassLoader mcl = new CompileClassLoader();
        Class<?> clazz = Class.forName("com.atguigu.se.classloader.help.LoadPerson", true, mcl);
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}
